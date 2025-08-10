
### Race condition
Occurs when the correctness of a computation depends on the timing and therefore order of multiple threads by a runtime.  
**Check-Then-Act** is a type of race condition.  
Where variables are connected both variables must be updated atomically or neither is updated.  
Invalid state can be created when only one is updated.  
See [`UnsafeCachingFactorizer`](src/main/java/ie/williamswalsh/UnsafeCachingFactorizer.java).

### Invariants
Invariants are rules/conditions that must be held true.  
They ensure data consistency and therefore program correctness.  
An example of an invariant is a current accounts balance can only be positive,  
i.e. the account doesn't allow for negative balances.  

### Defensive copy
Defensive copy is a technique where you create a copy of an object (usually a mutable one)  
**before storing or returning it**, instead of using the original reference.  
This prevents the calling method from modifying your internal state.  




# Synchronised Keyword

1) Synchronised methods
```java
// This method is synchronized to the this object 
public synchronized void transfer(Account to, int amount) {
    this.balance -= amount;
    to.balance += amount;
}

// This method is synchronized to the Class object 
public static synchronized void transfer(Account to, int amount) {
        this.balance -= amount;
        to.balance += amount;
}
```
2) Synchronised block
```java
// Can synchronise smaller snippets of code.
// Can synchronise on different objects
public void transfer(Account to, int amount) {
    // Some non-critical code
    System.out.println("Starting transfer...");

    synchronized (this) {
        this.balance -= amount;
        to.balance += amount;
    }

    // More non-critical code
    System.out.println("Transfer complete.");
}
```