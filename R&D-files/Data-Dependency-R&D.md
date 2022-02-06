## Data Dependency Research & Development

*Problems & Solutions ordered top-down from recent-to-oldest*

### Problem:
This Solidity Keyword needs to be converted into a Java Dependency:
```solidity 
.data
``` 
`Data` Interface in Java needs to extend to the `Bytes` Interface.

#### Hypothesis:
1. Refactor Dependency.

##### Findings
- `msg.data` (bytes calldata): complete calldata.

##### Test Case/s:
```java
public interface Data extends javax.xml.crypto.Data, ByteValue {}
```
Likely sufficient... More research to be done.
### Solution:
```java
public interface Data extends ByteValue {
    //@Override functions extended from ByteValue imported (similar to Address Dependency)
    }
}
```
-----------------------------------------------------------------------
