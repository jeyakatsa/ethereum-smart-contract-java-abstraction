import com.sun.jdi.ByteValue;
import com.sun.jdi.Type;
import com.sun.jdi.VirtualMachine;

public class Address implements ByteValue {

    @Override
    public byte value() {
        return 0;
    }

    @Override
    public boolean booleanValue() {
        return false;
    }

    @Override
    public byte byteValue() {
        return 0;
    }

    @Override
    public char charValue() {
        return 0;
    }

    @Override
    public short shortValue() {
        return 0;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public Type type() {
        return null;
    }

    @Override
    public VirtualMachine virtualMachine() {
        return null;
    }

    @Override
    public int compareTo(ByteValue o) {
        return 0;
    }
}
