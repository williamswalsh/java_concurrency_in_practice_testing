package ie.williamswalsh.factorizer;

import ie.williamswalsh.caching_factorizer.UnsafeCachingFactorizer;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

public class UnSafeCacheFactorizerTest {

    @Test
    void test() {
        UnsafeCachingFactorizer f = new UnsafeCachingFactorizer();
        Arrays.stream(f.getFactors(BigInteger.valueOf(999999999))).forEach(System.out::println);
        Arrays.stream(f.getFactors(BigInteger.valueOf(999999999))).forEach(System.out::println);
    }
}
