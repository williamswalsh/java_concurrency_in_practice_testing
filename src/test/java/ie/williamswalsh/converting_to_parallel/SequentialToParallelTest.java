package ie.williamswalsh.converting_to_parallel;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequentialToParallelTest {

    void process(int input) {
        System.out.println("Processing integer: " + input);
    }

    List<Integer> createListOfLength(int length) {
        List list = new ArrayList<>();
        int index = 0;
        while(index < length) {
            list.add(index);
            index++;
        }
        return list;
    }

    @Test
    void testCreateListMethod() {
        List<Integer> list = createListOfLength(2);
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    void sequential() {
        for (int i : createListOfLength(10000000)) {
            process(i);
        }
    }

    @Test
    void parallel() {
        ExecutorService executor = Executors.newFixedThreadPool(11);
        for (int i : createListOfLength(10000000)) {
            executor.submit(() -> process(i));
        }
    }

}
