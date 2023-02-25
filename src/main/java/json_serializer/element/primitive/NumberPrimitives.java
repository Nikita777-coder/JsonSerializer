package json_serializer.element.primitive;

public class NumberPrimitives implements Primitive {
    private final Number val;

    public NumberPrimitives(Object obj) {
        val = (Number) obj;
    }

    @Override
    public Object getValue() {
        return val;
    }
}
