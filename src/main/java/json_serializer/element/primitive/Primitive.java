package json_serializer.element.primitive;

public interface Primitive {
    static Primitive parse(Object obj) {
        switch (obj.getClass().getSimpleName()) {
            case "Character":
                return new CharPrimitive(obj);
            case "Boolean":
                return new BoolPrimitive(obj);
            default:
                return new NumberPrimitives(obj);
        }
    }

    Object getValue();
}
