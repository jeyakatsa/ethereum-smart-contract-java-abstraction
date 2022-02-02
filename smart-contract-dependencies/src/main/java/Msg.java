import java.util.*;

public class Msg {

    Address head;

    public static class Address {
        byte[] data;
        Address sender;
        Address next;

        Address(byte[] d) {
            data = d;
        }

        public Address() {

        }
    }

}
