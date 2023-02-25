package json_serializer.element;

import json_serializer.element.json_object.JsonObject;
import json_serializer.element.test_classes.SimpleClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class JsonElementTest {

    @Test
    @DisplayName("Checking what type will be after parsing null value")
    void parseNull() {
        assertEquals(JsonNull.class.getSimpleName(), JsonElement.parse(null).getClass().getSimpleName());
    }

    @Test
    @DisplayName("Checking what type will be after parsing primitive type")
    void parsePrimitive() {
        int val = 10;
        char s = '1';
        Boolean b = false;

        assertAll(() -> assertEquals(JsonPrimitive.class.getSimpleName(), JsonElement.parse(val).getClass().getSimpleName()),
                () -> assertEquals(JsonPrimitive.class.getSimpleName(), JsonElement.parse(s).getClass().getSimpleName()),
                () -> assertEquals(JsonPrimitive.class.getSimpleName(), JsonElement.parse(b).getClass().getSimpleName())
        );
    }

    @Test
    @DisplayName("Checking what type will be after parsing array type")
    void parseArray() {
        List<Object> arr = new ArrayList<>();
        Object[] arr2 = {};

        assertAll(() -> assertEquals(JsonArray.class.getSimpleName(), JsonElement.parse(arr).getClass().getSimpleName()),
                () -> assertEquals(JsonArray.class.getSimpleName(), JsonElement.parse(arr2).getClass().getSimpleName())
        );
    }

    @Test
    @DisplayName("Checking what type will be after parsing remaining objects type")
    void parseRemainingObjects() {
        SimpleClass dr = new SimpleClass("wdwd", 1, 2);
        Object obj = new Object();
        Scanner sc = new Scanner(System.in);
        String s = "wrfref";

        assertAll(() -> assertEquals(JsonObject.class.getSimpleName(), JsonElement.parse(dr).getClass().getSimpleName()),
                () -> assertEquals(JsonObject.class.getSimpleName(), JsonElement.parse(obj).getClass().getSimpleName()),
                () -> assertEquals(JsonObject.class.getSimpleName(), JsonElement.parse(sc).getClass().getSimpleName()),
                () -> assertEquals(JsonObject.class.getSimpleName(), JsonElement.parse(s).getClass().getSimpleName())
        );
    }
}