package dao;

import models.Animal;

import java.util.List;

/**
 * Created by Guest on 8/15/17.
 */
public interface AnimalDao {
    //create
    void add(Animal animal);

    //read
    List<Animal> getAll();

    Animal findById(int id);
    //update
    void update(int id, String content);
    //delete
    void deleteById(int id);
    //void clearAllAnimals();

    void clearAllAnimals(int id);


}