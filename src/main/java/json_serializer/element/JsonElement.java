package json_serializer.element;

import json_serializer.element.json_object.JsonObject;

import java.util.Arrays;
import java.util.List;

public interface JsonElement {
    static JsonElement parse(Object obj) {
        if (obj == null) {
            return new JsonNull();
        }

        List<String> javaPrimitiveTypes = Arrays.asList("Byte", "Short", "Integer", "Long", "Character", "Float",
                "Double", "Boolean");
        if (obj.getClass().isPrimitive() || javaPrimitiveTypes.contains(obj.getClass().getSimpleName())) {
            return new JsonPrimitive(obj);
        }

        if (obj.getClass().isArray() || obj instanceof List<?>) {
            return new JsonArray(obj);
        }

        JsonObject jo = new JsonObject();
        jo.addProperty(obj);
        return jo;
    }
    Object getValue();
}
