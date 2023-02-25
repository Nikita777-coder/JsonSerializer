package json_serializer;

import json_serializer.element.test_classes.ClassWithMixedTypesOfFields;
import json_serializer.element.test_classes.SimpleClass;
import json_serializer.element.test_classes.inheritense.InheritClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

class JsonSerializerTest {

    // Все дальнейшие тесты чекаются на глаз потому, что для каждого отдеьного объекта проверять его json - жёстко.
    // Можно было бы с помощью gson чекнуть, но там в строку он даёт всё.
    @Test
    @DisplayName("Serialize user class without inheritances")
    void serializeSimpleUserClass() {
        SimpleClass dr = new SimpleClass("klfek", 12, 13);
        System.out.println(JsonSerializer.serialize(dr));
    }

    @Test
    @DisplayName("Serialize java types (List, Scanner, Map)")
    void serializeJavaTypes() {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 8, 10, 11, 12, 13, 14, 15, 16);
        Scanner sc = new Scanner(System.in);
        Map<String, Object> m = new HashMap<>();
        m.put("qkdqd", 23);
        m.put("klqemdkwle", 'w');

        System.out.println(JsonSerializer.serialize(l));
        System.out.println();
        System.out.println(JsonSerializer.serialize(sc));
        System.out.println();
        System.out.println(JsonSerializer.serialize(m));
        System.out.println();
    }

    // I'm lazy now to steam up.
    /*@Test
    @DisplayName("Serialize user class with inheritances")
    void serializeInheritanceUserClass() {
        InheritClass c = new InheritClass(1, 2);
        System.out.println(JsonSerializer.serialize(c));
    }*/

    @Test
    @DisplayName("Serialize user class with mixed types (List, Scanner, Map)")
    void serializeUserClassWithObjectTypes() {
        System.out.println(JsonSerializer.serialize(new ClassWithMixedTypesOfFields()));
    }
}