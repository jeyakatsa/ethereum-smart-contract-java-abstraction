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

- [Ethereum networks](https://ethereum.org/en/developers/docs/networks/): Networks are different Ethereum environments you can access for development, testing, or production use cases.  
- - Public networks: Accessible to anyone in the world with an internet connection. Anyone can read or create transactions on a public blockchain and validate the transactions being executed. Agreement on transactions and the state of the network is decided by a consensus of peers. 
- - - Mainnet: The primary public Ethereum production blockchain, where actual-value transactions occur on the distributed ledger. When people and exchanges discuss ETH prices, they're talking about Mainnet ETH.
- - - Testnet: These are networks used by *protocol developers or smart contract developers* to test both protocol upgrades as well as potential smart contracts in a production-like environment before deployment to Mainnet. Think of this as an analog to production versus staging servers. Most testnets use a proof-of-authority consensus mechanism. This means a small number of nodes are chosen to validate transactions and create new blocks – staking their identity in the process. It's hard to incentivise mining on a proof-of-work testnet which can leave it vulnerable.
- - - - Görli: A proof-of-authority testnet that works across clients.
- - - - Kovan: A proof-of-authority testnet for those running OpenEthereum clients.
- - - - Rinkeby: A proof-of-authority testnet for those running Geth client.
- - - - Ropsten: A proof-of-work testnet. This means it's the best like-for-like representation of Ethereum.
- - - - - Testnet Faucets: ETH on testnets has no real value; therefore, there are no markets for testnet ETH. Since you need ETH to actually interact with Ethereum, most people get testnet ETH from faucets. Most faucets are webapps where you can input an address which you request ETH to be sent to. Some examples of this are:
- - - - - - [FaucETH](https://fauceth.komputing.org/)
- - - - - - [Gorli faucet](https://faucet.goerli.mudit.blog/)
- - Private networks: An Ethereum network is a private network if its nodes are not connected to a public network (i.e. Mainnet or a testnet). In this context, private only means reserved or isolated, rather than protected or secure.

- [Transactions](https://ethereum.org/en/developers/docs/transactions/):

- [Anatomy of Smart-cCntracts](https://ethereum.org/en/developers/docs/smart-contracts/anatomy/):.

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
