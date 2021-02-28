package javaclass;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AddressTest {
    @Test
    void constructorTest() {
        Address test = new Address("Типанова", 10, 63);
        assertEquals("Типанова", test.getStreet());
        assertEquals(10, test.getHome());
        assertEquals(63, test.getFlat());
    }

    @Test
    void setStreet() {
        Address nameTest = new Address("Типанова", 10, 63);
        nameTest.setStreet("Победы");
        assertEquals("Победы", nameTest.getStreet());
    }
    @Test
    void setHome() {
        Address nameTest = new Address("Типанова", 10, 63);
        nameTest.setHome(9);
        assertEquals(9, nameTest.getHome());
    }
    @Test
    void setFlat() {
        Address nameTest = new Address("Типанова", 10, 63);
        nameTest.setFlat(50);
        assertEquals(50, nameTest.getFlat());
    }
    @Test
    void testEquals() {
        Address a = new Address("Типанова", 10, 63);
        Address b = new Address("Типанова", 10, 63);
        assertEquals(b, a);
        assertEquals(a, b);
        Address example1 = new Address("Типанова", 10, 63);
        Address example2 = new Address("Типанова", 9, 63);
        assertNotEquals(example2, example1);
    }
    @Test
    void testHashCode() {
        Address example1 = new Address("Типанова", 10, 63);
        Address example2 = new Address("Типанова", 10, 63);
        assertEquals(example2.hashCode(), example1.hashCode());
    }
    @Test
    void testToString() {
        Address toStringTest = new Address("Типанова", 10, 63);
        assertEquals("ул.Типанова д.10 кв.63", toStringTest.toString());
    }
}
