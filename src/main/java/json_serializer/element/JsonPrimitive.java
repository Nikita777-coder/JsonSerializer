package json_serializer.element;

import json_serializer.element.annotation.MustBePrimitive;
import json_serializer.element.primitive.Primitive;

public class JsonPrimitive implements JsonElement {
    private final Primitive value;

    @MustBePrimitive
    public JsonPrimitive(Object obj) {
        value = Primitive.parse(obj);
    }
    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public Object getValue() {
        return value.getValue();
    }
}
