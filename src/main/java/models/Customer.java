package models;


import java.util.ArrayList;

public class Customer {
    private String name;
    private int phoneNumber;
    private String preferredAnimal;
    private String preferredBreed;
    private int id;

    public Customer(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (phoneNumber != customer.phoneNumber) return false;
        if (id != customer.id) return false;
        if (!name.equals(customer.name)) return false;
        if (preferredAnimal != null ? !preferredAnimal.equals(customer.preferredAnimal) : customer.preferredAnimal != null)
            return false;
        return preferredBreed != null ? preferredBreed.equals(customer.preferredBreed) : customer.preferredBreed == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + phoneNumber;
        result = 31 * result + (preferredAnimal != null ? preferredAnimal.hashCode() : 0);
        result = 31 * result + (preferredBreed != null ? preferredBreed.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
