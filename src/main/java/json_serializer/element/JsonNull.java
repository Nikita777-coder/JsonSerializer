package json_serializer.element;

public class JsonNull implements JsonElement {
    @Override
    public String toString() {
        return "null";
    }

    @Override
    public Object getValue() {
        return null;
    }
}
