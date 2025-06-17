package ie.williamswalsh.number_range;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class BadNumberRange {
    // In-variant: in -> Non, variant -> changing => Non-changing -> something that needs to be held true
    // lower < upper
    private long lower;
    private long upper;

    public BadNumberRange() {}

    public BadNumberRange(long lower, long upper) {
        if (lower > upper) {
            throw new IllegalArgumentException("Invariant violated upon object Construction");
        }
        this.lower = lower;
        this.upper = upper;
    }

    public long getLower() {
        return lower;
    }

    public long getUpper() {
        return upper;
    }

    public void setLower(long lower) {
        if (lower > this.upper) {
            throw new IllegalArgumentException("Invariant violated");
        }
        this.lower = lower;
    }

    public void setUpper(long upper) {
        if (upper < this.lower) {
            throw new IllegalArgumentException("Invariant violated");
        }
        this.upper = upper;
    }

    public void incrementUpper() {
        long currUpper = this.getUpper();
        this.setUpper(++currUpper);
    }
}
