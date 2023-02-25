package json_serializer.element.primitive;

public class CharPrimitive implements Primitive {
    private final char val;

    public CharPrimitive(Object obj) {
        val = (Character) obj;
    }

    @Override
    public Object getValue() {
        return String.format("\"%s\"", val);
    }
}
