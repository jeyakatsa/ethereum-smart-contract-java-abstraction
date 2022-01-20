# Java Smart Contract Abstraction Research & Development

### To allow the building of smart contracts in Java on Ethereum (with Rust, Python, and Go as the next focus).

#### Note: *This project started as a focused version of the [New ERC Token](https://github.com/jeyakatsa/New-ERC-Token) with an overall goal of bringing more developers into the Ethereum ecosystem.*

## Estimated Roadmap:

### Month-By-Month *(2022)*
January:
- Begin building Java Abstraction. *[Status: [In-Development](https://github.com/jeyakatsa/Ethereum-Smart-Contract-Java-Abstraction)]*
- Research & Develop Solidity-Keywords to Java-Dependency conversions *[Status: In-Development]*

February - December:
- ***Java*** Smart Contract Abstraction Build. *[Status: [In-Development](https://github.com/jeyakatsa/Ethereum-Smart-Contract-Java-Abstraction)]*
- ***Rust*** Smart Contract Abstraction Build. *[Status: Announced]*
- ***Python*** Smart Contract Abstraction Build. *[Status: Announced]*
- ***Go*** Smart Contract Abstraction Build. *[Status: Announced]*

### Year-By-Year
2022
- Finish building Java Abstraction *[Status: [In-Development](https://github.com/jeyakatsa/Ethereum-Smart-Contract-Java-Abstraction)]*
- Open blog to reflect on discoveries and to also offer discussions. *[Status: Announced]*
- Open aggregate Repo to arbitrate all language abstractions. *[Status: Announced]*
- Open aggregate EIP. *[Status: Announced]*

## Solidity-Keywords to Java-Dependency Conversion Problem Solving Process

*Problems & Solutions ordered top-down from recent-to-oldest*

### Problem:
This Solidity Keyword needs to be converted into a Java Dependency:
```solidity 
Address
``` 

#### Hypothesis:
1. Refactor Dependency.

##### Findings:
- In Solidity, address type comes with two flavors, `Address` and `Address Payable`. Both address and address payable store the ***20-byte*** values.
- Adding a byte type reference to Address class within Java Dependencies seems plausible.
```java
byte[] byteArray;
byte byteArray[];
```
- `Address` needs to be either a `public class Address<>{}` or a `public interface Address<>{}`.
##### Test Case/s:
```java
public class Address implements ByteValue {

    @Override
    public byte value() {
        return 0;
    }

    @Override
    public boolean booleanValue() {
        return false;
    }

    @Override
    public byte byteValue() {
        return 0;
    }

    @Override
    public char charValue() {
        return 0;
    }

    @Override
    public short shortValue() {
        return 0;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public Type type() {
        return null;
    }

    @Override
    public VirtualMachine virtualMachine() {
        return null;
    }

    @Override
    public int compareTo(ByteValue o) {
        return 0;
    }
}
```
##### Findings:

### Solution:
```java
//TBD (To Be Determined)
```

--------------------------------
*Problems & Solutions ordered top-down from recent-to-oldest*

-----------------------------------------------------------------------
## Function Problem Solving Process

*Problems & Solutions ordered top-down from recent-to-oldest*

### Problem:
This function in Solidity needs to be converted into Java:
```solidity 
 revert InsufficientBalance({
    requested: amount,
    available: balances[msg.sender]
});
``` 

#### Hypothesis:
1. Refactor function.

##### Findings:
REVERT will undo all state changes, but it will be handled differently than an “invalid opcode” in two ways:
*1. It will allow you to return a value.*
*2. It will refund any remaining gas to the caller.*
1. It will allow you to return a value
Most smart contract developers are quite familiar with the notoriously unhelpful invalid opcode error. Fortunately, we’ll soon be able to return an error message, or a number corresponding to an error type. That, will look something like this: `revert(‘Something bad happened’);`or `require(condition, ‘Something bad happened’);`
2. Refund the remaining gas to the caller
Currently, when your contract throws, it uses up any remaining gas. This can result in a very generous donation to miners, and often ends up costing users a lot of money.
- Essentially, `revert` is like an error...
##### Test Case/s:
Quite possibly:
```java
InsufficientBalance(requested = amount, available = balances.get(msg.sender));
```
could work...
##### Findings:
Reminder that `:` operand is essentially "If Condition is true? Then value X : Otherwise value Y"

### Solution:
```java
InsufficientBalance(amount = requested, balances.get(msg.sender) = available);
```
*Will refactor if necessary after test against dependency importing is completed*

--------------------------------

### Problem:
This function in Solidity needs to be converted into Java:
```solidity 
error InsufficientBalance(uint requested, uint available);
``` 

#### Hypothesis:
1. Refactor function.

##### Findings:
- `error` within Solidity is essentially a 'dependency' within Java
##### Test Case/s:
Function:
```java
private Uint256 requested;
private Uint256 available;
public void InsufficientBalance() {
    if (requested != available){
        throw new IllegalCallerException("Insufficient Balance");
    }
}
```
is sufficient.

### Solution:
```java
private Uint256 requested;
private Uint256 available;
public void InsufficientBalance() {
    if (requested != available){
        throw new IllegalCallerException("Insufficient Balance");
    }
}
```
*Will refactor if necessary after test against dependency importing is completed*

--------------------------------

### Problem:
This function in Solidity needs to be converted into Java:
```solidity 
balances[receiver] += amount;
``` 

#### Hypothesis:
1. Refactor function.

##### Findings:
- `balances[receiver] += amount;` insufficient for Java as it receives the `[receiver]` function as an Array when it is currated as a Map within the original `balances` function.
- `Mapping` is a reference type as array.
##### Test Case/s:
- Implementing `private Arrays balances = new List<Address, Uint256>();` as reference insufficient.
- Implementing `private ArrayType balances = new List<Address, Uint256>();` as reference insufficient.
- Implementing `private ArrayType balances = new ArrayDeque<Address, Uint256>();` as reference insufficient.
- Implementing `balances.get(receiver) += amount;` and `private ArrayList balances = new List<Address, Uint256>();` as reference sufficient.

### Solution:
```java
private ArrayList balances = new List<Address, Uint256>();
// balances function below reflects function within overall "public" function
balances.get(receiver) += amount;
```
*Will refactor if necessary after test against dependency importing is completed*

--------------------------------

### Problem:
This function in Solidity needs to be converted into Java:
```solidity 
require(msg.sender == minter);
``` 

#### Hypothesis:
1. Refactor function.

##### Findings:
- `msg.sender` contains the address that has originated the call of a smart contract as spoken within this medium article (https://medium.com/coinmonks/solidity-who-the-heck-is-msg-sender-de68d3e98454)
- Solidity `require` is a convenience function that checks invariants, conditions, and throws exceptions.
- The `require` Solidity function guarantees validity of conditions that cannot be detected before execution. It checks inputs, contract state variables and return values from calls to external contracts.
- In the following cases, Solidity triggers a require-type of exception: 
- - When you call require with arguments that result in false. 
- - When a function called through a message does not end properly.
- - When you create a contract with new keyword and the process does not end properly.
- - When you target a codeless contract with an external function.
- - When your contract gets Ether through a public getter function.
- - When `.transfer()` ends in failure.
##### Test Case/s:
- `require` needs to be a possible dependency in Java.

### Solution:
```java
Require(msg.sender == minter);
```
*Will refactor if necessary after test against dependency importing is completed*

--------------------------------

### Problem:
This function in Solidity needs to be converted into Java:
```solidity 
msg.sender;
``` 

#### Hypothesis:
1. Refactor function.

##### Findings:
- The `msg.sender` global variable — likely the most commonly used special variable — is always the address where a current function call came from. For instance, if a function call came from a user or smart contract with the address `0xdfad6918408496be36eaf400ed886d93d8a6c180` then `msg.sender` equals `0xdfad6918408496be36eaf400ed886d93d8a6c180`.
- `msg.sender` is most likely a hex, or a `Uint256`

### Solution:
```java
// msg almost always returns a Uint function (Uint256 in the case of Java)
public Subcurrency(){
    minter = msg.sender;
}
```
*Will refactor if necessary after test against dependency importing is completed*

-----------------------------------------------------------------------

### Problem:
This function in Solidity needs to be converted into Java:
```solidity 
event Sent(address from, address to, uint amount);
``` 

#### Hypothesis:
1. Refactor function.

##### Findings:
- A basic syntax function in Java is as follows:
```java
 private Event sent(Address from, Address to, Uint256 ammount) {
     return null;
 }
```
needs to *not* return null.
##### Test Case/s:
- Implementing `return from;` insufficient.
- Implementing
```java
    Address from;
    Address to;
    Uint256 amount;
```
and returning each within function insufficient.
- Implementing `Address from = null;` and returning `from` insufficient.
##### Findings:
- Is `event` within Solidity an object? https://www.tutorialspoint.com/solidity/solidity_events.htm
- "Event is an inheritable member of a contract. An event is emitted, it stores the arguments passed in transaction logs. These logs are stored on blockchain and are accessible using address of the contract till the contract is present on the blockchain. An event generated is not accessible from within contracts, not even the one which have created and emitted them."
- `event` within Solidity is not an object but acts rather like a "Dependency" in Java

### Solution:
Calling dependencies within sent function and returning function as is ie:
```java
private Event sent() {
    Address from;
    Address to;
    Uint256 amount;
    return sent;
}
```
*Will refactor if necessary after test against dependency importing is completed*

-----------------------------------------------------------------------

### Problem:
This function in Solidity needs to be converted into Java:
```solidity 
mapping (address => uint) public balances;
``` 

#### Hypothesis:
1. Refactor function.

##### Findings:
- A basic syntax function for Solidity is as follows:
```solidity
function function-name(parameter-list) scope returns() {
   //statements
}
```
Question is, how do we implement the `(address => uint)` in Java?
- The function `mapping (address => uint) public balances;` in Solidity is the similar to `var mydictionary = new Dictionary(key,value);` in Java with the `=>` simply indicating an arrow.

##### Test Case/s:
- Function in Java as possibility.
```java
public Map balances = new Map<Adress, Uint256>();
```

### Solution:
```java
public Map balances = new Map<Adress, Uint256>();
```
*Will refactor if necessary after test against dependency importing is completed*

-----------------------------------------------------------------------

## General Notes/References:
### [Intro-To-Smart-Contracts-in-Solidity](https://docs.soliditylang.org/en/v0.8.10/introduction-to-smart-contracts.html)
### [Layer-2](https://github.com/ethereum/ethereum-org-website/blob/dev/src/content/developers/docs/scaling/layer-2-rollups/index.md)

---------------------------------------------------

### Abstraction:

#### *While building the [Light Client Infrastructure for Teku](https://github.com/jeyakatsa/teku/tree/master/light-client), these are the said discoveries:*

- Clients serve as arbiters or "bridges" to the Ethereum main chain.
- Such clients offer differing languages that connect with the transactions offered on Ethereum, thus concluding if said clients can offer a base layer capable of inferring transactions from Ethereum's base layer, can smart contracts in said languages also offer the same results?
