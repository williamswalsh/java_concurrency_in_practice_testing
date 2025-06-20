package ie.williamswalsh.initialization;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class SafeLazyInit {
    private static String resource;

    // Safe lazy init
    // synchronized keyword only allows 1 thread to enter this objects method.
    // 2 threads can't be in method simultaneously
    // 2nd method call will be blocked until first thread completes execution.
    public synchronized static String getResource() {
        return (resource==null)? "": resource;
    }
}
