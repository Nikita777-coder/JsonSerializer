package json_serializer.element.primitive;

public class BoolPrimitive implements Primitive {
    private final Boolean val;

    public BoolPrimitive(Object obj) {
        val = (Boolean) obj;
    }


    @Override
    public Object getValue() {
        return val;
    }
}
