package javaclass;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void constructorTest() {
        Person test = new Person("Храпунов", "Алексей");
        assertEquals ("Алексей", test.getName());
        assertEquals ("Храпунов",test.getSurname());

    }
    @Test
    void setName() {
        Person nameTest = new Person("Храпунов", "Алексей");
        nameTest.setName("Сергей");
        assertEquals("Сергей", nameTest.getName());
    }
    @Test
    void setSurname() {
        Person surnameTest = new Person("Храпунов", "Алексей");
        surnameTest.setSurname("Сергеев");
        assertEquals("Сергеев", surnameTest.getSurname());
    }
   @Test
   void testEquals() {
       Person a = new Person("Храпунов", "Алексей");
       Person b = new Person("Храпунов", "Алексей");
       assertEquals(b, a);
       assertEquals(a, b);
       Person example1 = new Person("Храпунов", "Алексей");
       Person example2 = new Person("Сергеев", "Алексей");
           assertNotEquals(example2, example1);
    }
    @Test
    void testHashCode() {
        Person example1 = new Person("Храпунов", "Алексей");
        Person example2 = new Person("Храпунов", "Алексей");
        assertEquals(example2.hashCode(), example1.hashCode());
    }
    @Test
    void testToString() {
        Person toStringTest = new Person("Храпунов", "Алексей");
        assertEquals("Храпунов Алексей", toStringTest.toString());
    }
}


