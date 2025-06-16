package ie.williamswalsh.visibility;

public class NoVisibility {
    // define class-wide state
    static boolean ready = false;
    static int number = 0;

    public static void main(String[] args) {

        // define behaviour lambda
        Runnable r = () -> {
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        };

        // start thread
        new Thread(r).start();

        number = 42;
        ready = true;
    }
}
