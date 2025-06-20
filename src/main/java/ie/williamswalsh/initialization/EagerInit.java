package ie.williamswalsh.initialization;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class EagerInit {
    private static String resource = "";

    public static String getResource() {
        return resource;
    }
}
