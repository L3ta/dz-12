package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ManTest {

    @DataProvider(name = "manProvider")
    public Object[][] provideManData() {
        return new Object[][] {
                {"Роман", "Батькович", 66},
                {"Олексій", "Петрович", 50},
                {"Іван", "Іванович", 30}
        };
    }

    @Test(dataProvider = "manProvider")
    public void testGetFirstName(String firstName, String lastName, int age) {
        Man man = new Man(firstName, lastName, age);
        assertEquals(man.getFirstName(), firstName);
    }

    @Test(dataProvider = "manProvider")
    public void testSetFirstName(String firstName, String lastName, int age) {
        Man man = new Man(firstName, lastName, age);
        man.setFirstName("НовийІм'я");
        assertEquals(man.getFirstName(), "НовийІм'я");
    }

    @Test(dataProvider = "manProvider")
    public void testIsRetired(String firstName, String lastName, int age) {
        Man man = new Man(firstName, lastName, age);
        if (age > 65) {
            assertTrue(man.isRetired());
        } else {
            assertFalse(man.isRetired());
        }
    }
}



