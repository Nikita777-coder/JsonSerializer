package json_serializer.element;

import json_serializer.element.annotation.MustBeArrayOrList;

import java.util.ArrayList;
import java.util.List;

public class JsonArray implements JsonElement {
    private final List<Object> elements;

    @MustBeArrayOrList
    public JsonArray(Object obj) {
        elements = new ArrayList<>();

        if (!(obj instanceof List<?>)) {
            Object[] arr;
            arr = (Object[]) obj;
            for (Object val : arr) {
                elements.add(JsonElement.parse(val));
            }

        } else {
            List<Object> l = (List<Object>) obj;

            for (var v : l) {
                elements.add(JsonElement.parse(v).getValue());
            }
        }
    }

    @Override
    public String toString() {
        return elements.toString();
    }

    @Override
    public Object getValue() {
        return elements;
    }
}
