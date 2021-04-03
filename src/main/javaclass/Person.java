import java.util.Objects;

public class Person {

    private String surname, name;

    public Person(String surname, String name) {
        if (name == null || surname == null) throw new IllegalArgumentException("Name can not be null");
        this.surname = surname;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null) throw new IllegalArgumentException("Wrong data");
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Wrong data");
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return name.equals(other.name) && surname.equals(other.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }
}


