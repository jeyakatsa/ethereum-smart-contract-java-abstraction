public interface Sender extends Address {
    Sender head = (Sender) new Address();

    public static class Address {
        //Byte[] function needs to call Data dependency in place (To Be Refactored)
        Data data;
        Sender sender;
        Sender next;

        void Sender(Data d) {
            data = d;
        }

        public void Sender() {

        }
    }
}
