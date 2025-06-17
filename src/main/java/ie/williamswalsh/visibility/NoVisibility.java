package ie.williamswalsh.visibility;


// This example doesn't demonstrate the lack of visibility on ready variable from other thread.
// JVM difference? -> still works in JDK 17/8?
public class NoVisibility {
    private static boolean ready;
    private static int number;


    private static class ReaderThread extends Thread {
        public void run() {
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        };
    }


    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
        // ready variable isn't visible from other started thread.

    }
}
