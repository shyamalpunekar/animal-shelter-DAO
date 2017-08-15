package models;

import java.time.LocalDateTime;

public class Animals {
    private String animalName;
    private String gender;
    private LocalDateTime admittanceDate;
    private String animalType;
    private String animalBreed;
    private int id;
    private boolean adopted;

    public Animals(String animalName) {
        this.animalName = animalName;
        this.adopted = false;
        this.admittanceDate = LocalDateTime.now();
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

    public String getAnimalBreed() {
        return animalBreed;
    }

    public void setAnimalBreed(String animalBreed) {
        this.animalBreed = animalBreed;
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



}
