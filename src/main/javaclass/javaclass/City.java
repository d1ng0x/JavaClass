package javaclass;

import javafx.util.Pair;
import java.util.*;

public class City {

    private final List<Pair<Person, Address>> database;

    public City(List<Pair<Person, Address>> list) {
        database = new ArrayList<>();
    }


    public void addPair(Person person, Address address) {
        database.add(new Pair<>(person, address));
    }

    public void removePerson(Person person) {
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getKey() == person) {
                database.remove(i);
                break;
            }
        }
    }

    public void changeAddress(Person person, Address newAddress) {
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getKey() == person) {
                database.set(i, new Pair<>(person, newAddress));
                break;
            }
        }
    }

    public Address getAddress(Person person) {
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getKey() == person) {
                return database.get(i).getValue();
            }
        }
        return new Address("", 0,0);
    }


    ArrayList<Person> personsOnStreet(String street) {
        return personsInHome(street, 0);
    }

    ArrayList<Person> personsInHome(String street, int home) {
        ArrayList<Person> result = new ArrayList<>();

        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getValue().getStreet().equals(street) && (home == database.get(i).getValue().getHome())) {
                result.add(database.get(i).getKey());
            }
        }
        return result;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(database, city.database);
    }
    @Override
    public int hashCode() {
        return Objects.hash(database);
    }
    @Override
    public String toString() {
        return database.toString();
    }
}