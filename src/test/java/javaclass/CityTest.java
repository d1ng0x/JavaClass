package javaclass;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CityTest {
    List<Pair<Person, Address>> database;
    Person person1 = new Person("Ivanov", "Ivan");
    Person person2 = new Person("Petrov", "Petr");
    Address address1 = new Address("Lenina", 10, 4);
    Address address2 = new Address("Koroleva", 2, 37);
    City city = new City(database);

    @Test
    void add() {
        city.addPair(person1, address1);
        city.addPair(person2, address2);
        assertEquals(2,city.getDatabase().size());
    }

    @Test
    void remove(){
        city.addPair(person1, address1);
        city.addPair(person2, address2);
        city.removePerson(person1);
        assertEquals(1,city.getDatabase().size());
    }
    @Test
    void getAddress(){
        city.addPair(person1, address1);
        assertEquals("ул.Lenina д.10 кв.4", city.getAddress(person1).toString());
    }
    @Test
    void change(){
        city.addPair(person1, address1);
        city.addPair(person2, address2);
        city.changeAddress(person1,new Address("Типанова",10,63));
        assertEquals("ул.Типанова д.10 кв.63", city.getAddress(person1).toString());
    }
    @Test
    void testEquals(){
        City ex = new City(database);
        ex.addPair(person1, address1);
        city.addPair(person1, address1);
        assertEquals(city.getDatabase(), ex.getDatabase());
        assertEquals(ex.getDatabase(), city.getDatabase());
        city.changeAddress(person1, new Address("Koroleva", 2, 37));
        assertNotEquals(city.getDatabase(), ex.getDatabase());
    }
    @Test
    void testHashCode() {
        City ex = new City(database);
        ex.addPair(person1, address1);
        city.addPair(person1, address1);
        assertEquals(city.hashCode(), ex.hashCode());
    }

    @Test
    void testToString(){
        city.addPair(person1, address1);
        assertEquals("Ivanov Ivan ул.Lenina д.10 кв.4",city.toString());
    }
}


