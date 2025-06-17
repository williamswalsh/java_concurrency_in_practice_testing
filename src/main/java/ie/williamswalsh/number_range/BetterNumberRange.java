package ie.williamswalsh.number_range;

public class BetterNumberRange {
    // In-variant: in -> Non, variant -> changing => Non-changing -> something that needs to be held true
    // lower < upper
    private volatile long lower;
    private volatile long upper;

    public BetterNumberRange() {}

    public BetterNumberRange(long lower, long upper) {
        if (lower > upper) {
            throw new IllegalArgumentException("Invariant violated upon object Construction");
        }
        this.lower = lower;
        this.upper = upper;
    }

    public synchronized long getLower() {
        return lower;
    }

    public synchronized long getUpper() {
        return upper;
    }

    public synchronized void setLower(long lower) {
        if (lower > this.upper) {
            throw new IllegalArgumentException("Invariant violated");
        }
        this.lower = lower;
    }

    public synchronized void setUpper(long upper) {
        if (upper < this.lower) {
            throw new IllegalArgumentException("Invariant violated");
        }
        this.upper = upper;
    }

    public synchronized void incrementUpper() {
        long currUpper = this.getUpper();
        this.setUpper(++currUpper);
    }
}
