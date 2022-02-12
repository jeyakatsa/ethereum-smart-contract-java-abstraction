## Java Smart Contract Execution Research & Development


### Problem:
How to execute a Smart-Contract in Java

#### Hypothesis:
1. *TBD*

# Findings
### Deploying smart contracts:

You need to deploy your smart contract for it to be available to users of an Ethereum network.

To deploy a smart contract, you merely send an Ethereum transaction containing the compiled code of the smart contract without specifying any recipient.

##### Prerequisites

Understanding...

**[Ethereum networks](https://ethereum.org/en/developers/docs/networks/)**: Networks are different Ethereum environments you can access for development, testing, or production use cases.  
- Public networks: Accessible to anyone in the world with an internet connection. Anyone can read or create transactions on a public blockchain and validate the transactions being executed. Agreement on transactions and the state of the network is decided by a consensus of peers. 
- - Mainnet: The primary public Ethereum production blockchain, where actual-value transactions occur on the distributed ledger. When people and exchanges discuss ETH prices, they're talking about Mainnet ETH.
- - ***Testnet: These are networks used by protocol developers or smart contract developers to test both protocol upgrades as well as potential smart contracts in a production-like environment before deployment to Mainnet. Think of this as an analog to production versus staging servers. Most testnets use a proof-of-authority consensus mechanism. This means a small number of nodes are chosen to validate transactions and create new blocks – staking their identity in the process. It's hard to incentivise mining on a proof-of-work testnet which can leave it vulnerable.***
- - - Görli: A proof-of-authority testnet that works across clients.
- - - Kovan: A proof-of-authority testnet for those running OpenEthereum clients.
- - - Rinkeby: A proof-of-authority testnet for those running Geth client.
- - - Ropsten: A proof-of-work testnet. This means it's the best like-for-like representation of Ethereum.
- - - - Testnet Faucets: ETH on testnets has no real value; therefore, there are no markets for testnet ETH. Since you need ETH to actually interact with Ethereum, most people get testnet ETH from faucets. Most faucets are webapps where you can input an address which you request ETH to be sent to. Some examples of this are:
- - - - - [FaucETH](https://fauceth.komputing.org/)
- - - - - [Gorli faucet](https://faucet.goerli.mudit.blog/)
- Private networks: An Ethereum network is a private network if its nodes are not connected to a public network (i.e. Mainnet or a testnet). In this context, private only means reserved or isolated, rather than protected or secure.

**[Transactions](https://ethereum.org/en/developers/docs/transactions/)**: Transactions are cryptographically signed instructions from accounts. An account will initiate a transaction to update the state of the Ethereum network. The simplest transaction is transferring ETH from one account to another. Transactions require a fee and must be mined to become valid. To make this overview simpler we'll cover gas fees and mining elsewhere. A submitted transaction includes the following information:
- Recipient: The receiving address (if an externally-owned account, the transaction will transfer value. If a contract account, the transaction will execute the contract code)
- Signature: The identifier of the sender. This is generated when the sender's private key signs the transaction and confirms the sender has authorized this transaction
- Value: Amount of ETH to transfer from sender to recipient (in WEI, a denomination of ETH)
- Data: Optional field to include arbitrary data
- GasLimit: The maximum amount of gas units that can be consumed by the transaction. Units of gas represent computational steps
- MaxPriorityFeePerGas: The maximum amount of gas to be included as a tip to the miner
- MaxFeePerGas: The maximum amount of gas willing to be paid for the transaction (inclusive of baseFeePerGas and maxPriorityFeePerGas)
- - Gas is a reference to the computation required to process the transaction by a miner. Users have to pay a fee for this computation. The `gasLimit`, and `maxPriorityFeePerGas` determine the maximum transaction fee paid to the miner.
The transaction object will look a little like this:
```
{ from: "0xEA674fdDe714fd979de3EdF0F56AA9716B898ec8",
  to: "0xac03bb73b6a9e108530aff4df5077c2b3d481e5a",
  gasLimit: "21000",
  maxFeePerGas: "300",
  maxPriorityFeePerGas: "10",
  nonce: "0",
  value: "10000000000" 
}
```
But a transaction object needs to be signed using the sender's private key. This proves that the transaction could only have come from the sender and was not sent fraudulently. 
An Ethereum client like Geth will handle this signing process. JSON Example:
```
{
  "id": 2,
  "jsonrpc": "2.0",
  "method": "account_signTransaction",
  "params": [
    {
      "from": "0x1923f626bb8dc025849e00f99c25fe2b2f7fb0db",
      "gas": "0x55555",
      "maxFeePerGas": "0x1234",
      "maxPriorityFeePerGas": "0x1234",
      "input": "0xabcd",
      "nonce": "0x0",
      "to": "0x07a565b7ed7d7a678680a4c162885bedbb695fe0",
      "value": "0x1234"
    }
  ]
}
```
Email Response:
```
{
  "jsonrpc": "2.0",
  "id": 2,
  "result": {
    "raw": "0xf88380018203339407a565b7ed7d7a678680a4c162885bedbb695fe080a44401a6e4000000000000000000000000000000000000000000000000000000000000001226a0223a7c9bcf5531c99be5ea7082183816eb20cfe0bbc322e97cc5c7f71ab8b20ea02aadee6b34b45bb15bc42d9c09de4a6754e7000908da72d48cc7704971491663",
    "tx": {
      "nonce": "0x0",
      "maxFeePerGas": "0x1234",
      "maxPriorityFeePerGas": "0x1234",
      "gas": "0x55555",
      "to": "0x07a565b7ed7d7a678680a4c162885bedbb695fe0",
      "value": "0x1234",
      "input": "0xabcd",
      "v": "0x26",
      "r": "0x223a7c9bcf5531c99be5ea7082183816eb20cfe0bbc322e97cc5c7f71ab8b20e",
      "s": "0x2aadee6b34b45bb15bc42d9c09de4a6754e7000908da72d48cc7704971491663",
      "hash": "0xeba2df809e7a612a0a0d444ccfa5c839624bdc00dd29e3340d46df3870f8a30e"
    }
  }
}
```
The `raw` is the signed transaction in Recursive Length Prefix (RLP) encoded form. The `tx` is the signed transaction in JSON form

With the signature hash, the transaction can be cryptographically proven that it came from the sender and submitted to the network.

**Types of Transactions:**

On Ethereum there are a few different types of transactions:

1. Regular transactions: a transaction from one wallet to another.
2. **Contract deployment transactions: a transaction without a 'to' address, where the data field is used for the contract code.**

**Transaction Lifecycle:** 

Once the transaction has been submitted the following happens:
1. Once you send a transaction, cryptography generates a transaction hash: `0x97d99bc7729211111a21b12c933c949d4f31684f1d6954ff477d0477538ff017`
2. The transaction is then broadcast to the network and included in a pool with lots of other transactions.
3. A miner must pick your transaction and include it in a block in order to verify the transaction and consider it "successful". 
- You may end up waiting at this stage if the network is busy and miners aren't able to keep up.
4. Your transaction will receive "confirmations". The number of confirmations is the number of blocks created since the block that included your transaction. The higher the number, the greater the certainty that the network processed and recognized the transaction.
- Recent blocks may get re-organized, giving the impression the transaction was unsuccessful; however, the transaction may still be valid but included in a different block.
- The probability of a re-organization diminishes with every subsequent block mined, i.e. the greater the number of confirmations, the more immutable the transaction is.

**[Anatomy of Smart-Contracts](https://ethereum.org/en/developers/docs/smart-contracts/anatomy/)**:.

Deploying a contract also costs ether (ETH), so you should be familiar with [gas and fees](https://ethereum.org/en/developers/docs/gas/) on Ethereum.

Finally, you'll need to compile your contract before deploying it, so make sure you've read about [compiling smart contracts](/developers/docs/smart-contracts/compiling/).

#### How to deploy a smart contract

##### What you'll need

- your contract's bytecode – this is generated through [compilation](https://ethereum.org/en/developers/docs/smart-contracts/compiling/)
- ETH for gas – you'll set your gas limit like other transactions so be aware that contract deployment needs a lot more gas than a simple ETH transfer
- a deployment script or plugin
- access to an [Ethereum node](https://ethereum.org/en/developers/docs/nodes-and-clients/), either by running your own, connecting to a public node, or via an API key using a [node service](https://ethereum.org/en/developers/docs/nodes-and-clients/nodes-as-a-service/) like Infura or Alchemy

#### Steps to deploy a smart contract

The specific steps involved will depend on the tooling you use. For an example, check out the [Hardhat documentation on deploying your contracts](https://hardhat.org/guides/deploying.html) or [Truffle documentation on networks and app deployment](https://www.trufflesuite.com/docs/truffle/advanced/networks-and-app-deployment). These are two of the most popular tools for smart contract deployment, which involve writing a script to handle the deployment steps.

Once deployed, your contract will have an Ethereum address like other [accounts](https://ethereum.org/en/developers/docs/accounts/).

#### Related tools

**Remix - _Remix IDE allows developing, deploying and administering smart contracts for Ethereum like blockchains_**

- [Remix](https://remix.ethereum.org)

**Tenderly - _Simulate, debug and monitor anything on EVM-compatible chains, with real-time data_**

- [tenderly.co](https://tenderly.co/)
- [Docs](https://docs.tenderly.co/)
- [GitHub](https://github.com/Tenderly)
- [Discord](https://discord.gg/eCWjuvt)

**Hardhat - _A development environment to compile, deploy, test, and debug your Ethereum software_**

- [hardhat.org](https://hardhat.org/getting-started/)
- [Docs on deploying your contracts](https://hardhat.org/guides/deploying.html)
- [GitHub](https://github.com/nomiclabs/hardhat)
- [Discord](https://discord.com/invite/TETZs2KK4k)

**Truffle -** **_A development environment, testing framework, build pipeline, and other tools._**

- [trufflesuite.com](https://www.trufflesuite.com/)
- [Docs on networks and app deployment](https://www.trufflesuite.com/docs/truffle/advanced/networks-and-app-deployment)
- [GitHub](https://github.com/trufflesuite/truffle)

#### Related tutorials

- [Deploying your first smart contract](https://ethereum.org/en/developers/tutorials/deploying-your-first-smart-contract/) _– An introduction to deploying your first smart contract on an Ethereum test network._
- [Interact with other contracts from Solidity](https://ethereum.org/en/developers/tutorials/interact-with-other-contracts-from-solidity/) _– How to deploy a smart contract from an existing contract and interact with it._
- [How to downsize your contract size](https://ethereum.org/en/developers/tutorials/downsizing-contracts-to-fight-the-contract-size-limit/) _- How to reduce your contract's size to keep it under the limit and save on gas_

#### Further reading

- [https://docs.openzeppelin.com/learn/deploying-and-interacting](https://docs.openzeppelin.com/learn/deploying-and-interacting) - _OpenZeppelin_
- [Deploying your contracts with Hardhat](https://hardhat.org/guides/deploying.html) - _Nomic Labs_

# Test Case/s:
*TBD*
# Solution/s:
*TBD*

-----------------------------------------------------------------------
