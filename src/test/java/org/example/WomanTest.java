package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class WomanTest {

    @DataProvider(name = "womanProvider")
    public Object[][] provideWomanData() {
        return new Object[][] {
                {"Тетяна", "Абалдуєва", 59},
                {"Олена", "Іванова", 45},
                {"Марія", "Петрівна", 30}
        };
    }

    @Test(dataProvider = "womanProvider")
    public void testGetFirstName(String firstName, String lastName, int age) {
        Woman woman = new Woman(firstName, lastName, age);
        assertEquals(woman.getFirstName(), firstName);
    }

    @Test(dataProvider = "womanProvider")
    public void testSetFirstName(String firstName, String lastName, int age) {
        Woman woman = new Woman(firstName, lastName, age);
        woman.setFirstName("НовеІм'я");
        assertEquals(woman.getFirstName(), "НовеІм'я");
    }

    @Test(dataProvider = "womanProvider")
    public void testIsRetired(String firstName, String lastName, int age) {
        Woman woman = new Woman(firstName, lastName, age);
        if (age > 60) {
            assertTrue(woman.isRetired());
        } else {
            assertFalse(woman.isRetired());
        }
    }
}


