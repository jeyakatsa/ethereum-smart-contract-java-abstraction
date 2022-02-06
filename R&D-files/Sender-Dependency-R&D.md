## Sender Dependency Research & Development

*Problems & Solutions ordered top-down from recent-to-oldest*

### Problem:
This Solidity Keyword needs to be converted into a Java Dependency:
```solidity 
.sender
``` 
`Sender` Interface in Java needs to extend to the `Address` Interface.

#### Hypothesis:
1. Refactor Dependency.

##### Findings
- `msg.sender` (address): sender of the message (current call)

```java
interface A {
   void funcA();
}
interface B extends A {
   void funcB();
}
class C implements B {
   public void funcA() {
      System.out.println("This is funcA");
   }
   public void funcB() {
      System.out.println("This is funcB");
   }
}
```
Does an interface extention need a constructor and/or to call extended interface's functions?
```java
Address head;

public static class Address {
    byte[] data;
    Address sender
    Address next;

    Address(byte[] d) {
        data = d;
    }

    public Address() {

    }
}
```
***Sender interface essentially needs to return "previous" Address called.***
##### Test Case/s:
```java
public static class Address {
    byte[] data;
    Sender sender;
    Sender next;

    Sender(byte[] d) {
        data = d;
    }

    public Sender() {

    }
}
```
Insufficient.
### Solution:
```java
public static class Address {
    byte[] data;
    Sender sender;
    Sender next;

    void Sender(byte[] d) {
        data = d;
    }

    public void Sender() {

    }
}
```
-----------------------------------------------------------------------
