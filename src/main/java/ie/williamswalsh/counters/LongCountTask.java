package ie.williamswalsh.counters;

import java.util.concurrent.Callable;

public class LongCountTask implements Callable<Long> {
    LongCounter counter;

    public LongCountTask(LongCounter counter) {
        this.counter = counter;
    }

    public Long call() {
        return counter.getNextValue();
    }
}
