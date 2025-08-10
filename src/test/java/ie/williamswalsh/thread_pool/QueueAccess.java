package ie.williamswalsh.thread_pool;

import org.junit.jupiter.api.Test;
import java.util.concurrent.*;
public class QueueAccess {

    @Test
    void accessQueue() throws InterruptedException {
        ExecutorService executor = new ThreadPoolExecutor(
                2,
                2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>()
        );

        executor.submit(() -> {
            System.out.println("Started");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("Finished");
        });
        executor.submit(() -> {
            System.out.println("Started");
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("Finished");
        });
        executor.submit(() -> {
            System.out.println("Started");
//            try {
//                Thread.sleep(8000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("Finished");
        });

        BlockingQueue<Runnable> queue = ((ThreadPoolExecutor) executor).getQueue();
        System.out.println("Tasks in queue: " + queue.size());
        Runnable r = queue.take();  // blocks indefinitely - until a task is added to queue in a different thread
        System.out.println("Statement never reached");
        System.out.println(r);
        executor.shutdown();
    }
}
