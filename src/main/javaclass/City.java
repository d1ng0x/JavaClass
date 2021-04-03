import javafx.util.Pair;
import java.util.*;

public class City {

    private final List<Pair<Person, Address>> database = new ArrayList<>();

    public City(List<Pair<Person, Address>> list) {
        database.clear();
        if (list != null) {
            database.addAll(list);
        }
    }


    public boolean addPair(Person person, Address address) {
        if (person == null || address == null) throw new IllegalArgumentException("Wrong data");
        int a = database.size();
        database.add(new Pair<>(person, address));
        return database.size() > a;
    }

    public boolean removePerson(Person person) {
        if (person == null) throw new IllegalArgumentException("Wrong data");
        int b = database.size();
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getKey() == person) {
                database.remove(i);
                break;
            }
        }
        return database.size() < b;
    }

    public boolean changeAddress(Person person, Address newAddress) {
        if (newAddress == null) throw new IllegalArgumentException("Wrong data");
        int c = 0;
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getKey() == person) {
                c = i;
                database.set(i, new Pair<>(person, newAddress));
                break;
            }
        }
        return database.get(c).getValue().equals(newAddress);
    }

    public Address getAddress(Person person) {
        for (Pair<Person, Address> personAddressPair : database) {
            if (personAddressPair.getKey() == person) {
                return personAddressPair.getValue();
            }
        }
        return new Address("", 0, 0);
    }


    public ArrayList<Person> personsOnStreet(String street) {
        ArrayList<Person> persons = new ArrayList<>();
        for (Pair<Person, Address> personAddressPair : database) {
            if (personAddressPair.getValue().getStreet().equals(street)) {
                persons.add(personAddressPair.getKey());
            }
        }
        return persons;
    }

    public ArrayList<Person> personsInHome(String street, int home) {
        ArrayList<Person> result = new ArrayList<>();
        for (Pair<Person, Address> personAddressPair : database) {
            if (personAddressPair.getValue().getStreet().equals(street) && (home == personAddressPair.getValue().getHome())) {
                result.add(personAddressPair.getKey());
            }
        }
        return result;
    }

    public List<Pair<Person, Address>> getDatabase() {
        return new ArrayList<>(database);
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
        StringBuilder SB = new StringBuilder();
        for (Pair<Person, Address> personAddressPair : database) {
            SB.append(personAddressPair.getKey());
            SB.append(" ");
            SB.append(personAddressPair.getValue());
            SB.append(";");
        }
        return SB.toString();
    }
}


