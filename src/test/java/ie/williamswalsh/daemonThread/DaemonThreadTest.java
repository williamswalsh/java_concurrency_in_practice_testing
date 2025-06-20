package ie.williamswalsh.daemonThread;

public class DaemonThreadTest {


    public static void main(String[] args) {
        Runnable runnable = () -> {
            while (true) {
                System.out.println("Daemon thread running...");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    break;
                }
            }
        };

        Thread daemonThread = new Thread(runnable);
        daemonThread.setDaemon(true); // Mark this thread as daemonThread
        daemonThread.start();

        System.out.println("Main thread finished.");
    }
}
