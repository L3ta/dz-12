package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WomanTest {

    @Test
    public void testIsRetired() {
        Woman woman = new Woman("Тетяна", "Абалдуєва", 61);
        Assert.assertTrue(woman.isRetired());
    }

    @Test
    public void testRegisterPartnership() {
        Woman woman = new Woman("Тетяна", "Абалдуєва", 25);
        Man man = new Man("Роман", "Батькович", 30);
        woman.registerPartnership(man);
        Assert.assertEquals(woman.getLastName(), "Батькович");
    }

    @Test
    public void testDeregisterPartnership() {
        Woman woman = new Woman("Тетяна", "Абалдуєва", 25);
        Man man = new Man("Роман", "Батькович", 30);
        woman.registerPartnership(man);
        woman.deregisterPartnership(true);
        Assert.assertEquals(woman.getLastName(), "Абалдуєва");
    }

    @Test
    public void testSettersAndGetters() {
        Woman woman = new Woman("Тетяна", "Абалдуєва", 25);
        woman.setFirstName("Ірина");
        woman.setLastName("Коваль");
        woman.setAge(35);
        woman.setMaidenName("Лисенко");

        Assert.assertEquals(woman.getFirstName(), "Ірина");
        Assert.assertEquals(woman.getLastName(), "Коваль");
        Assert.assertEquals(woman.getAge(), 35);
        Assert.assertEquals(woman.getMaidenName(), "Лисенко");
    }
}


