## Value Dependency Research & Development

*Problems & Solutions ordered top-down from recent-to-oldest*

### Problem:
This Solidity Keyword needs to be converted into a Java Dependency:
```solidity 
.value
``` 
`Value` Interface in Java needs to extend to the `Uint256` Interface.

#### Hypothesis:
1. Refactor Dependency.

##### Findings
- The value of `msg.value` is always the amount of Ethers sent with the (internal) transaction - if contract `A` calls contract `B` it may pass along less Ethers than `msg.value` and then `msg.value` in `B` is the new amount. So, yes, the whole amount will be taken from `msg.sender` (or, more specifically, from `tx.origin` - the EOA who initially started the transaction).
```solidity
contract A {
    function a() payable external {
        B bb = new B();
        bb.b.value(msg.value / 2)();
    }
}

contract B {
    event showb(uint);
    function b() payable external {
        emit showb(msg.value);
    }
}
```
##### Test Case/s:
```java
public interface Value extends Uint256 {public static class Uint256 {}}
```
### Solution:
```java
//TBD
```
-----------------------------------------------------------------------
