package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Animal {

    private String animalName;
    private String gender;
    private LocalDateTime admittanceDate;
    private String animalType;
    ArrayList<String> animalBreeds;
    private int id;
    private boolean adopted;

    public Animal(String animalName) {
        this.animalName = animalName;
        this.adopted = false;
        this.admittanceDate = LocalDateTime.now();
       // this.animalBreeds = getAnimalBreeds();
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getAdmittanceDate() {
        return admittanceDate;
    }

    public void setAdmittanceDate(LocalDateTime admittanceDate) {
        this.admittanceDate = admittanceDate;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public ArrayList<String> getAnimalBreeds() {
        return animalBreeds;
    }

    public void setAnimalBreeds(ArrayList<String> animalBreeds) {
        this.animalBreeds = animalBreeds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animals = (Animal) o;

        if (id != animals.id) return false;
        if (adopted != animals.adopted) return false;
        if (!animalName.equals(animals.animalName)) return false;
        if (gender != null ? !gender.equals(animals.gender) : animals.gender != null) return false;
        if (admittanceDate != null ? !admittanceDate.equals(animals.admittanceDate) : animals.admittanceDate != null)
            return false;
        if (animalType != null ? !animalType.equals(animals.animalType) : animals.animalType != null) return false;
        return animalBreeds != null ? animalBreeds.equals(animals.animalBreeds) : animals.animalBreeds == null;
    }

    @Override
    public int hashCode() {
        int result = animalName.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (admittanceDate != null ? admittanceDate.hashCode() : 0);
        result = 31 * result + (animalType != null ? animalType.hashCode() : 0);
        result = 31 * result + (animalBreeds != null ? animalBreeds.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (adopted ? 1 : 0);
        return result;
    }



}
