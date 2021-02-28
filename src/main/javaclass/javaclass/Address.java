package javaclass;

import java.util.Objects;

public class Address {

    private String street;
    private int home, flat;

    public Address(String street, int home, int flat) {
        this.street = street;
        this.home = home;
        this.flat = flat;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Address)) return false;
        Address other = (Address) obj;
        return street.equals(other.street) && home == other.home && flat == other.flat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, home, flat);
    }

    @Override
    public String toString() {
        return "ул." + street + " д." + home + " кв." + flat;
    }
}

