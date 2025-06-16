package ie.williamswalsh.counters;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CounterTest {

    @Test
    void testSafeCounter() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Counter safeCounter = new SafeCounter();
        List<CountTask> tasks = new ArrayList<>();
        int numOfTasks = 50000;

        for (int i = 0; i < numOfTasks; i++) {
            tasks.add(new CountTask(safeCounter));
        }

        // Blocks until all are submitted and completed - returns a future with future.isDone=true
        executor.invokeAll(tasks);
        assertEquals(numOfTasks, safeCounter.getNextValue());
    }

    @Test
    void testSafeAtomicCounter() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Counter safeCounter = new SafeAtomicCounter();
        List<CountTask> tasks = new ArrayList<>();
        int numOfTasks = 50000;

        for (int i = 0; i < numOfTasks; i++) {
            tasks.add(new CountTask(safeCounter));
        }

        // Blocks until all are submitted and completed - returns a future with future.isDone=true
        executor.invokeAll(tasks);
        assertEquals(numOfTasks, safeCounter.getNextValue());
    }

    @Test
    void testUnSafeCounter() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Counter unSafeCounter = new UnSafeCounter();
        List<CountTask> tasks = new ArrayList<>();
        int numOfTasks = 50000;

        for (int i = 0; i < numOfTasks; i++) {
            tasks.add(new CountTask(unSafeCounter));
        }
        executor.invokeAll(tasks);

//        Value is Off by 200+ counts
        assertNotEquals(numOfTasks, unSafeCounter.getNextValue());
    }

    @Test
    void testUsingInvokeAllWithSafeCounter() throws InterruptedException {
        SafeCounter safeCounter = new SafeCounter();
        List<Callable<Integer>> tasks = List.of(
                new CountTask(safeCounter),
                new CountTask(safeCounter),
                new CountTask(safeCounter)
        );

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.invokeAll(tasks);
        assertEquals(3, safeCounter.getNextValue());
    }
}
