package ie.williamswalsh.counters;

import java.util.concurrent.Callable;

public class CountTask implements Callable<Integer> {
    Counter counter;

    public CountTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() {
        return counter.getNextValue();
    }
}
