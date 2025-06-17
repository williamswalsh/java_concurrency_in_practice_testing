package ie.williamswalsh.number_range;

import java.util.concurrent.atomic.AtomicLong;

public class BestNumberRange {
    // In-variant: in -> Non, variant -> changing => Non-changing -> something that needs to be held true
    // lower < upper
    private final AtomicLong lower;
    private final AtomicLong upper;

    public BestNumberRange(long lower, long upper) {
        this.lower = new AtomicLong(lower);
        this.upper = new AtomicLong(upper);
    }

    public synchronized long getLower() {
        return lower.get();
    }

    public synchronized long getUpper() {
        return upper.get();
    }

    public synchronized void setLower(long lower) {
        if (lower > this.upper.get()) {
            throw new IllegalArgumentException("Invariant violated");
        }
        this.lower.set(lower);
    }

    public synchronized void setUpper(long upper) {
        if (upper < this.lower.get()) {
            throw new IllegalArgumentException("Invariant violated");
        }
        this.upper.set(upper);
    }

    public synchronized void incrementUpper() {
        long currUpper = this.getUpper();
        this.setUpper(++currUpper);
    }
}
