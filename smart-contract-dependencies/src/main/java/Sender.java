public interface Sender extends Address {
    Sender head = (Sender) new Address();

    public static class Address {
        byte[] data;
        Sender sender;
        Sender next;

        void Sender(byte[] d) {
            data = d;
        }

        public void Sender() {

        }
    }
}
