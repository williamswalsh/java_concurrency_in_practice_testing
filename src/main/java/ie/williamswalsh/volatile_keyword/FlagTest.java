package ie.williamswalsh.volatile_keyword;

class FlagTest {

    // WO volatile -> program never stops as thread will only check its cached version of the running flag
    static boolean running = true;


    // W volatile -> program will stop, as the value of the volatile variable will be read from the memory not from the thread-local cache.
//    volatile static boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            int count=0;
            while (running) {
                // System.out.println("Loop: " + count++);
//                System.out.println("Busy.....");
            }
            System.out.println("Stopped.");
        });

        thread.start();
        Thread.sleep(1000);
        running = false; // Main thread sets running = false
    }
}
