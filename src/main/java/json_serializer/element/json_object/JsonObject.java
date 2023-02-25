package json_serializer.element.json_object;

import json_serializer.element.JsonElement;

import java.util.ArrayList;
import java.util.List;

public class JsonObject implements JsonElement {
    private List<Pair<String, JsonElement>> clazz;
    private Object obj;

    public JsonObject() {
        clazz = new ArrayList<>();
    }

    public void addProperty(Object obj) {
        this.obj = obj;
    }
    public void addProperty(String fieldName, JsonElement el) {
        clazz.add(new Pair(fieldName, el));
    }
    @Override
    public String toString() {
        if (clazz.isEmpty() && obj != null) {
            return String.format("\"%s\"", obj.toString());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < clazz.size(); ++i) {
            sb.append('\n');
            sb.append(String.format("\t\"%s\":%s", clazz.get(i).getFieldName(), clazz.get(i).getValue().getValue()));

            if (i != clazz.size() - 1) {
                sb.append(",");
            }
        }

        if (!clazz.isEmpty()) {
            sb.append("\n");
        }

        sb.append("}");

        return sb.toString();
    }

    @Override
    public Object getValue() {
        return obj;
    }
}
