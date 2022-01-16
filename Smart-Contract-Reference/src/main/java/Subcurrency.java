import java.util.*;

public class Subcurrency {

    //Address, Uint256, Event, msg, Require dependencies to be imported
    public Address minter;
    private Map balances = new Map<Address, Uint256>();

    // Events allow clients to react to specific
    // contract changes you declare
    private Event sent() {
        Address from;
        Address to;
        Uint256 amount;
        return sent;
    }

    // Constructor code is only run when the contract
    // is created
    // msg almost always returns a Uint function (Uint256 in the case of Java)
    public Subcurrency(){
        minter = msg.sender;
    }

    // Sends an amount of newly created coins to an address
    // Can only be called by the contract creator
    public Mint(Address receiver, Uint256 amount) {
        //Code to be added.
        Require(msg.sender == minter);
    }


}
