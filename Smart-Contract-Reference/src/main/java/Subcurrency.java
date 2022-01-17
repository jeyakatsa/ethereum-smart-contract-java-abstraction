import java.util.*;

public class Subcurrency {

    //Address (long), Uint256, Event, msg, Require dependencies to be imported
    public Address minter;
    private ArrayList balances = new List<Address, Uint256>();

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
    public void Mint(Address receiver, Uint256 amount) {
        //Code to be added.
        Require(msg.sender == minter);
        balances.get(receiver) += amount;
    }

    // Errors allow you to provide information about
    // why an operation failed. They are returned
    // to the caller of the function.
    private Uint256 requested;
    private Uint256 available;
    public void InsufficientBalance() {
        if (requested != available){
            throw new IllegalCallerException("Insufficient Balance");
        }
    }

    // Sends an amount of existing coins
    // from any caller to an address
    public void Send(Address receiver, Uint256 amount){
        if (amount > balances.get(msg.sender)){

        }

    }



}
