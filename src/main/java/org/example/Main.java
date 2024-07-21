package org.example;


class Person {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected Person partner;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.partner = null;
    }

    // Гетер для firstName
    public String getFirstName() {
        return firstName;
    }

    // Сетер для firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Гетер для lastName
    public String getLastName() {
        return lastName;
    }

    // Сетер для lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Гетер для age
    public int getAge() {
        return age;
    }

    // Сетер для age
    public void setAge(int age) {
        this.age = age;
    }

    // Гетер для partner
    public Person getPartner() {
        return partner;
    }

    // Сетер для partner
    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public boolean isRetired() {
        return false;
    }

    public void registerPartnership(Person partner) {
        this.partner = partner;
        partner.setPartner(this);
    }

    public void deregisterPartnership(boolean revertToPreviousLastName) {
        if (this.partner != null) {
            this.partner.setPartner(null);
        }
        this.partner = null;
    }
}

class Man extends Person {
    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public boolean isRetired() {
        return this.age > 65;
    }

    @Override
    public void registerPartnership(Person partner) {
        if (partner instanceof Woman) {
            Woman womanPartner = (Woman) partner;
            womanPartner.setLastName(this.lastName);
        }
        super.registerPartnership(partner);
    }
}

class Woman extends Person {
    private String maidenName;

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.maidenName = lastName;
    }

    @Override
    public boolean isRetired() {
        return this.age > 60;
    }

    @Override
    public void registerPartnership(Person partner) {
        if (partner instanceof Man) {
            this.maidenName = this.lastName;
            this.setLastName(partner.getLastName());
        }
        super.registerPartnership(partner);
    }

    @Override
    public void deregisterPartnership(boolean revertToPreviousLastName) {
        if (revertToPreviousLastName) {
            this.setLastName(this.maidenName);
        }
        super.deregisterPartnership(revertToPreviousLastName);
    }

    // Гетер для maidenName
    public String getMaidenName() {
        return maidenName;
    }

    // Сетер для maidenName
    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }
}

public class Main {
    public static void main(String[] args) {
        Man john = new Man("Роман", "Батькович", 66);
        Woman jane = new Woman("Тетяна", "Абалдуєва", 59);

        System.out.println(john.getFirstName() + " " + john.getLastName() + " перебуває на пенсії: " + john.isRetired());
        System.out.println(jane.getFirstName() + " " + jane.getLastName() + " перебуває на пенсії: " + jane.isRetired());

        john.registerPartnership(jane);

        System.out.println("Після реєстрації шлюбу:");
        System.out.println(jane.getFirstName() + " " + jane.getLastName());

        jane.deregisterPartnership(true);

        System.out.println("Після скасування реєстрації шлюбу:");
        System.out.println(jane.getFirstName() + " " + jane.getLastName());
    }
}