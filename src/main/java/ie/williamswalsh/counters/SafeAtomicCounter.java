package ie.williamswalsh.counters;


import net.jcip.annotations.GuardedBy;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeAtomicCounter implements Counter, Stateable{

    // Starting at -1 as the value returned from the increment function is the new incremented value
    // not the current value before incrementing.
    @GuardedBy("AtomicInteger Variable")
    private final AtomicInteger value = new AtomicInteger(-1);

    public int getNextValue() {
        printState();
        return value.incrementAndGet();
    }
}

