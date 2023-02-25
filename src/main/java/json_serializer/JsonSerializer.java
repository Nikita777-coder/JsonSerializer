package json_serializer;

import json_serializer.element.JsonElement;
import json_serializer.element.json_object.JsonObject;

import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;

public class JsonSerializer {
    public static String serialize(Object obj) {
        try {
            JsonObject result = new JsonObject();

            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                var r = field.get(obj);
                result.addProperty(field.getName(), JsonElement.parse(r));
            }

            return result.toString();
        } catch (IllegalAccessException ex) {
            return ex.getMessage();
        } catch (InaccessibleObjectException exc) {
            return obj.toString();
        }
    }
}
