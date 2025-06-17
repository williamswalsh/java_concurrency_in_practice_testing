package ie.williamswalsh.number_range;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NumberRangeTest {

    @Test
    void testBadNumberRangeSingleThread() {
        BadNumberRange range = new BadNumberRange(4, 5);

        for (int i = 0; i <10; i++) {
            long currUpper = range.getUpper();
            range.setUpper(++currUpper);
        }

        // No issue value is perfect
        assertEquals(15, range.getUpper());
    }


    @Test
    void testBadNumberRangeTenThreads() throws InterruptedException {
        BadNumberRange range = new BadNumberRange(4, 5);

        Runnable r = () -> {
            for (int i = 0; i < 100; i++) {
                range.incrementUpper();
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.submit(r);
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        assertEquals(10005, range.getUpper());
//        Assert fails
    }

    @Test
    void testStillFailingNumberRangeTenThreads() throws InterruptedException {
        BetterNumberRange range = new BetterNumberRange(4, 5);

        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                range.incrementUpper();
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.submit(r);
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

//        Still fails with all sychronized methods
        assertEquals(105, range.getUpper());
//        Assert fails
    }

    @Test
    void testBestNumberRangeStillFailingTenThreads() throws InterruptedException {
        BestNumberRange range = new BestNumberRange(4, 5);

        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                range.incrementUpper();
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.submit(r);
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

//        Still fails with all sychronized methods
        assertEquals(100005, range.getUpper());
//        Assert fails
    }
}
