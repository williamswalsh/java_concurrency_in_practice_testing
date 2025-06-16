package ie.williamswalsh.counters;


import net.jcip.annotations.GuardedBy;

public class SafeCounter implements Counter, Stateable{

    @GuardedBy("this")
    private int value;


    public synchronized int getNextValue() {
        printState();
        return value++;
    }
}

