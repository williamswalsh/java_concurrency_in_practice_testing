package ie.williamswalsh.counters;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class LongCounter {

    public LongCounter() {}

    public LongCounter(long count) {
        this.count = count;
    }

    private long count;

    public synchronized long getNextValue() {
        if (count == Long.MAX_VALUE) {
            throw new IllegalArgumentException("Counter overflow");
        }
        return count++;
    }
}
