package ie.williamswalsh.runtime_info;

import org.junit.jupiter.api.Test;

public class GetCpusTest {

    @Test
    void getCpus() {
        int cpuCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Available CPUs: " + cpuCount);
    }
}
