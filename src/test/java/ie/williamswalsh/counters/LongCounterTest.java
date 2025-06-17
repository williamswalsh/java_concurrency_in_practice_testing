package ie.williamswalsh.counters;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

public class LongCounterTest {

    @Test
    void testSafeCounter() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        LongCounter safeCounter = new LongCounter();
        List<LongCountTask> tasks = new ArrayList<>();
        int numOfTasks = 50000;

        for (int i = 0; i < numOfTasks; i++) {
            tasks.add(new LongCountTask(safeCounter));
        }

        // Blocks until all are submitted and completed - returns a future with future.isDone=true
        executor.invokeAll(tasks);
        assertEquals(numOfTasks, safeCounter.getNextValue());
    }

    @Test
    void testExceedCount() {
        LongCounter safeCounter = new LongCounter(9223372036854775807L);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> safeCounter.getNextValue(),
                "Expected invokeAll to throw, but it didn't"
        );
        assertEquals("Counter overflow", exception.getMessage());
    }
}
