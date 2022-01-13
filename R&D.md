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
mapping (address => uint) public balances;
``` 

#### Hypothesis:
1. Refactor function.

##### Findings
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
*Will refactor if necessary after test against dependency importing is completed*
```java
public Map balances = new Map<Adress, Uint256>();
```

-----------------------------------------------------------------------

## General Notes/References:
### [Intro-To-Smart-Contracts-in-Solidity](https://docs.soliditylang.org/en/v0.8.10/introduction-to-smart-contracts.html)
### [Layer-2](https://github.com/ethereum/ethereum-org-website/blob/dev/src/content/developers/docs/scaling/layer-2-rollups/index.md)

---------------------------------------------------

### Abstraction:

#### *While building the [Light Client Infrastructure for Teku](https://github.com/jeyakatsa/teku/tree/master/light-client), these are the said discoveries:*

- Clients serve as arbiters or "bridges" to the Ethereum main chain.
- Such clients offer differing languages that connect with the transactions offered on Ethereum, thus concluding if said clients can offer a base layer capable of inferring transactions from Ethereum's base layer, can smart contracts in said languages also offer the same results?
