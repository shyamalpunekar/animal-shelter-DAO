package dao;

import models.Animal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class Sql2oAnimalDaoTest {

    private Sql2oAnimalDao taskDao; //ignore me for now
    //private Connection conn;

    private Sql2oAnimalDao animalDao; //ignore me for now. We'll create this soon.
    private Connection conn; //must be sql2o class conn

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        animalDao = new Sql2oAnimalDao(sql2o); //ignore me for now
        //keep connection open through entire test so it does not get erased.
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    public Animal easyAnimal() {return new Animal("cat");}


    @Test
    public void addingCourseSetsId() throws Exception {
        Animal animal = easyAnimal();
        int originalAnimalId = animal.getId();
        animalDao.add(animal);
        assertNotEquals(originalAnimalId, animal.getId()); //how does this work?
    }

    @Test
    public void existingAnimalsCanBeFoundById() throws Exception {
        Animal animal = easyAnimal();
        animalDao.add(animal);
        Animal foundAnimal = animalDao.findById(animal.getId());
        assertEquals(animal, foundAnimal);
    }

    @Test
    public void addedAnimalsAreReturnedFromgetAll() throws Exception {
        Animal animal = easyAnimal();
        animalDao.add(animal);
        assertEquals(1, animalDao.getAll().size());
    }

    @Test
    public void noAnimalsReturnsEmptyList() throws Exception {
        assertEquals(0, animalDao.getAll().size());
    }

    @Test
    public void updateChangesAnimalContent() throws Exception {
        String animalName = "Peter";
        Animal animal = easyAnimal();
        animalDao.add(animal);

        animalDao.update(animal.getId(),"Henry");
        Animal updatedAnimal = animalDao.findById(animal.getId()); //why do I need to refind this?
        assertNotEquals(animalName, updatedAnimal.getAnimalName());
    }

    @Test
    public void deleteByIdDeletesCorrectAnimal() throws Exception {
        Animal animal = easyAnimal();
        animalDao.add(animal);
        animalDao.deleteById(animal.getId());
        assertEquals(1, animalDao.getAll().size());
    }

    @Test
    public void clearAllClearsAll() throws Exception {
        Animal animal = easyAnimal();
        Animal otherAnimal = new Animal( "brush the cat");
        animalDao.add(animal);
        animalDao.add(otherAnimal);
        int daoSize = animalDao.getAll().size();
        animalDao.clearAllAnimals(1);
        assertTrue(daoSize > 0 && daoSize > animalDao.getAll().size()); //this is a little overcomplicated, but illustrates well how we might use `assertTrue` in a different way.
    }

    @Test
    public void categoryIdIsReturnedCorrectly() throws Exception {
        Animal animal = easyAnimal();
        int originalCatId = animal.getId();
        animalDao.add(animal);
        assertNotEquals(originalCatId, animalDao.findById(animal.getId()));
    }



}