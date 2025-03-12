package ie.williamswalsh.using_person_set;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCreation {

    @Test
    void executeMultiplePersonTasks() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 8; i++) {
            executor.execute(new PersonTask());
        }
    }
}
