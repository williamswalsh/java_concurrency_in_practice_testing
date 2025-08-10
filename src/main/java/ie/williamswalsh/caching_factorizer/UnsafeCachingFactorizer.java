package ie.williamswalsh.caching_factorizer;

import net.jcip.annotations.NotThreadSafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

@NotThreadSafe
public class UnsafeCachingFactorizer {
    final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();

    public BigInteger[] getFactors(BigInteger input) {
        if (input.equals(lastNumber.get())) {
            return lastFactors.get();
        } else {
          BigInteger[] factors = factor(input);

          // If caching removed - test takes 29 seconds
          // If caching present - test takes 23 seconds
            lastNumber.set(input);
            lastFactors.set(factors);
            return factors;
        }
    }


    public static BigInteger[] factor(BigInteger n) {
        ArrayList<BigInteger> factors = new ArrayList<>();
        BigInteger i = BigInteger.ONE;
        BigInteger sqrt = n.sqrt();
        while (i.compareTo(sqrt) <= 0) {
            if (n.mod(i).equals(BigInteger.ZERO)) {
                factors.add(i);
                BigInteger other = n.divide(i);
                if (!i.equals(other)) {
                    factors.add(other);
                }
            }
            i = i.add(BigInteger.ONE);
        }
        factors.sort(null);
        return factors.toArray(new BigInteger[0]);
    }
}
