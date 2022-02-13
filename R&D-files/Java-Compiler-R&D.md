## Java Compiler Research & Development


### Problem:
How to compile Java Smart-Contracts into EVM bytecode

#### Hypothesis:
1. Build a Compile Script within the Java Abstraction Project.

# Findings:

## Reference pulled via [Coinmonks](https://medium.com/coinmonks/compiling-and-deploying-ethereum-smart-contracts-with-pure-javascript-4bee3bfe99bb)

### Start building the compile script

The aim of the script is to generate one JSON per contract (in this case we will finish the compile process with three JSON), each of them containing the compiled contract information. These JSON will be stored in an output path.

The steps for building our script are the following:

1. Create the a new directory.

##### Convert this into Java:
```javascript
const path = require('path');
const fs = require('fs-extra');

const builPath = path.resolve('ethereum', 'build');

const createBuildFolder = () => {
	fs.emptyDirSync(builPath);
}
```
**The Process:** TBD

3. Get the sources of our contracts.
4. Compile the contracts and write the output to a file.

#### Step 1 - Create the build/ folder
This step is the simplest due we only need to know some basics of Java (no Ethereum concepts needed here).

#### Step 2 - Get sources of contracts
Now it’s time to get the source of all our files inside contracts folder. In this step, like in the step one, no Ethereum concepts are needed just only Java.

For each file in our contracts folder, we add a new field in sources object (we will see in step three the purpose of this sources) where the key is the filename and the value is the content of the .java file.

#### Step 3 - Compile and write the output
Now that we already have our output folder and the content of the contracts, it’s time to compile them.

First of all, we have to define an object that will serve as an input of information for the Solidity compiler.

- Language : the programming language of our contracts, in this case is Java.
- Sources : the content of our contracts.
- Settings : this option tells the compiler what fields of the output we want to be generated. For this example I have choose to generate the abi and the evm.bytecode for all of our files in sources. This two piece of information are the necessary in the Deploy phase.

# Test Case/s: 
TBD

# Solution:
TBD
