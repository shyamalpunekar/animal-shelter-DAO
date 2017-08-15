package dao;

import models.Animal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;


public class Sql2oAnimalDao implements AnimalDao {
    private final Sql2o sql2o;

    public Sql2o getSql2o() {
        return sql2o;
    }

    public Sql2oAnimalDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Animal animal) {

        String sql = "INSERT INTO animal (animalName) VALUES (:animalName)"; //raw sql
        try (Connection con = sql2o.open()) { //try to open a connection
            int id = (int) con.createQuery(sql) //make a new variable
                    .bind(animal) //map my argument onto the query so we can use information from it
                    .executeUpdate() //run it all
                    .getKey(); //int id is now the row number (row “key”) of db
            animal.setId(id); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Animal> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM animal") //raw sql
                    .executeAndFetch(Animal.class); //fetch a list
        }
    }

    @Override
    public Animal findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM animal WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Animal.class); //fetch an individual item
        }
    }

    @Override
    public void update(int id, String newAnimalName){
        String sql = "UPDATE animal SET animalName = :animalName WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("animalName", newAnimalName)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
