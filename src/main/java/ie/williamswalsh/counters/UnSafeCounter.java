package ie.williamswalsh.counters;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnSafeCounter implements Counter, Stateable{

    private int value;

    public int getNextValue() {
        printState();
        return value++;
    }
}
