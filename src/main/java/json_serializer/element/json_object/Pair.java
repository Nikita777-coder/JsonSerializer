package json_serializer.element.json_object;

public class Pair<T1, T2> {
    private final T1 fieldName;
    private final T2 value;

    public Pair(T1 fieldName, T2 value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    public T1 getFieldName() {
        return fieldName;
    }

    public T2 getValue() {
        return value;
    }
}
