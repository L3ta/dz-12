package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ManTest {

    @Test
    public void testIsRetired() {
        Man man = new Man("Роман", "Батькович", 66);
        Assert.assertTrue(man.isRetired());
    }

    @Test
    public void testRegisterPartnership() {
        Man man = new Man("Роман", "Батькович", 30);
        Woman woman = new Woman("Тетяна", "Абалдуєва", 25);
        man.registerPartnership(woman);
        Assert.assertEquals(woman.getLastName(), "Батькович");
    }

    @Test
    public void testSettersAndGetters() {
        Man man = new Man("Роман", "Батькович", 30);
        man.setFirstName("Іван");
        man.setLastName("Шевченко");
        man.setAge(40);

        Assert.assertEquals(man.getFirstName(), "Іван");
        Assert.assertEquals(man.getLastName(), "Шевченко");
        Assert.assertEquals(man.getAge(), 40);
    }
}




