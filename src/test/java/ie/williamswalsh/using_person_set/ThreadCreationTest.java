package ie.williamswalsh.using_person_set;

import ie.williamswalsh.Person;
import ie.williamswalsh.PersonSet;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadCreationTest {

    @Test
    void executeMultiplePersonTasks() throws InterruptedException {
        PersonSet sharedPersonSet = new PersonSet();
        sharedPersonSet.addPerson(new Person("William", "Walsh"));

        Person[] people = {
                new Person("Georgia", "BS"),
                new Person("Pamela", "BS"),
                new Person("Tony", "BS"),
                new Person("Samuel", "BS"),
                new Person("Donal", "Walsh"),
                new Person("Natalie", "Walsh"),
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            executor.execute(new PersonTask(sharedPersonSet, people[i]));
        }
        executor.shutdown();
        executor.awaitTermination(1000, TimeUnit.SECONDS);

        System.out.println("PersonSet: " + sharedPersonSet);
    }
}
