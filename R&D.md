# Java Smart Contract Abstraction Research & Development

### To allow the building of smart contracts in Java on Ethereum (with Rust, Python, and Go as the next focus).

#### Note: *This project started as a focused version of the [New ERC Token](https://github.com/jeyakatsa/New-ERC-Token) with an overall goal of bringing more developers into the Ethereum ecosystem.*

## Estimated Roadmap:

### Month-By-Month *(2022)*
January:
- Begin building Java Abstraction. *[Status: [In-Development](https://github.com/jeyakatsa/Ethereum-Smart-Contract-Java-Abstraction)]*

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

-----------------------------------------------------------------------
## Problem Solving Process

*Problems & Solutions ordered top-down from recent-to-oldest*

### Problem:
This function in Solidity needs to be converted into Java:
```solidity 
balances[receiver] += amount;
``` 

#### Hypothesis:
1. Refactor function.

##### Findings:
- `balances[receiver] += amount;` insufficient for Java as it receives the `[receiver]` function as an Array when it is currated as a Map within the original `balances` function.
##### Test Case/s:
- TBD (To Be Determined)

### Solution:
TBD(To Be Determined)

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
