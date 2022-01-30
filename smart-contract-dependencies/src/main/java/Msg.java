import java.util.*;

public class Msg {

    Address head;

    class Address {
        byte[] data;
        Address sender;
        Address next;

        Address(byte[] d) {
            data = d;
        }
    }

    //Code to be added

}
