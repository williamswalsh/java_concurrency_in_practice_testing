


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