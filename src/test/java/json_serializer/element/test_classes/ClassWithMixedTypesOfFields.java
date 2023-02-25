package json_serializer.element.test_classes;

import java.util.*;

public class ClassWithMixedTypesOfFields {
    private final Map<String, Object> values;
    private final List<Object> objectList;
    private final Integer val;
    private final String v;

    public ClassWithMixedTypesOfFields() {
        values = new HashMap<>();
        values.put("kwdw", 2334);
        values.put("kefjerf", new ArrayList<>());
        values.put("kferf", 233L);

        objectList = Arrays.asList(243, "lkefjkel");
        val = 10;

        v = "kerferf";
    }
}
