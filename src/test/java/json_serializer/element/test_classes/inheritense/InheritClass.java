package json_serializer.element.test_classes.inheritense;

public class InheritClass extends AbstractClass {
    private Integer value;

    public InheritClass(int first, int second) {
        value = first;
        val = second;
    }

    @Override
    void someFunc() {

    }
}
