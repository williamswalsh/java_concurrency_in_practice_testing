package ie.williamswalsh.counters;

public interface Stateable {

//    Log IO like this can make a program go from very fast to completely failing
//    Number of active threads grow!!
//    No logging    ->  <300ms, threads: ?
//    1      line   ->  <800ms, threads: 34
//    2      lines  -> >5000ms, threads: 2563
//    3      lines  -> >5500ms, threads: 4826
//    4 -> threads: 5486
//    5 -> threads: 8191(stalls?)
    default void printState() {
//        System.out.println("=================================================");
//        System.out.println("ID: " + Thread.currentThread().getId());
//        System.out.println("Name: " + Thread.currentThread().getName());
//        System.out.println("Group: " + Thread.currentThread().getThreadGroup());
//        System.out.println("CtxClassLoader: " + Thread.currentThread().getContextClassLoader());
//        System.out.println("Priority: " + Thread.currentThread().getPriority());
//        System.out.println("StackTrace: " + Thread.currentThread().getStackTrace());
//        System.out.println("State: " + Thread.currentThread().getState());
//        System.out.println("Alive: " + Thread.currentThread().isAlive());
//        System.out.println("Daemon: " + Thread.currentThread().isDaemon());
//        System.out.println("Interrupted: " + Thread.currentThread().isInterrupted());
//        System.out.println("=================================================");
    }
}
