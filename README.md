## Java Abstraction layer for the New-ERC Token proposed for the Ethereum 2 protocol.

### Important Readings/Notes:

#### [The EIP](https://github.com/jeyakatsa/EIPs/blob/master/EIPS/eip-XXXX.md)
#### [Work-Aggregator](https://github.com/jeyakatsa/New-ERC-Token)
#### [The Original Proposal](https://ethresear.ch/t/a-new-erc-token-proposal/11540)

## *Step-By-Step Guide for build*

*Brief Description:* This process is ever so evolving as need be but should provide a straight forward methodical approach into building it (open to more efficient methods).

### Step 1: Download/Install Necessities

| Language Needed   | Links                   |
| ------------------|:----------------------- |
| Java 11           | https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html |

| Build/Test Tool Needed   | Links                   |
| -------------------------|:----------------------- |
| Gradle             | https://gradle.org/install/ |

| Coding Tool Needed   | Links                   |
| -----------------------|:----------------------- |
| IntelliJ         | https://www.jetbrains.com/idea/ |

### Step 2: Fork this repo & clone.

Java Abstraction repo: https://github.com/jeyakatsa/New-ERC-Token-Java-Abstraction

```shell script
git clone https://github.com/ConsenSys/teku.git
```

### Step 3: Build

Before building, run `./gradlew spotlessApply`. Then run,`./gradlew`. Then run, `./gradlew distTar installDist`.



