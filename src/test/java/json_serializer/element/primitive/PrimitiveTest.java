package json_serializer.element.primitive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveTest {
    Character s = '1';
    Integer el = 10;
    Byte el1 = 23;
    Short el2 = -1;
    Long el3 = Long.valueOf(4);
    Float el5 = Float.valueOf(-100);
    Double el6 = 12.2334;
    Boolean el7 = false;

    @Test
    @DisplayName("getValue(), Check what value will be for char type")
    void getCharValue() {
        assertEquals(String.format("\"%s\"", Character.valueOf('2')), (new CharPrimitive('2')).getValue());
    }

    @Test
    void getBooleanValue() {
        assertEquals(Boolean.valueOf(false), (new BoolPrimitive(false)).getValue());
    }

    @Test
    @DisplayName("getValue(), There could be troubles if small int value will be convert to some big type as a check value")
    void getNumberPrimitiveValue() {
        assertEquals(Integer.valueOf(14), (new NumberPrimitives(14).getValue()));
    }

    //
    @Test
    @DisplayName("parse(), Testing primitive types. Parse method don't check object on primitive type")
    void parsePrimitiveTests() {
        char s = '1';
        this.s = Character.valueOf(s);
        int el = 10;
        this.el = Integer.valueOf(el);
        byte el1 = 23;
        this.el1 = Byte.valueOf(el1);
        short el2 = -1;
        this.el2 = Short.valueOf(el2);
        long el3 = 4;
        this.el3 = Long.valueOf(el3);
        float el5 = -100;
        this.el5 = Float.valueOf(el5);
        double el6 = 12.2334;
        this.el6 = Double.valueOf(el6);
        boolean el7 = false;
        this.el7 = Boolean.valueOf(el7);

        assertAll(() -> assertEquals(String.format("\"%s\"", s), Primitive.parse(s).getValue()),
                () -> assertEquals(this.el, Primitive.parse(this.el).getValue()),
                () -> assertEquals(this.el1, Primitive.parse(this.el1).getValue()),
                () -> assertEquals(this.el2, Primitive.parse(this.el2).getValue()),
                () -> assertEquals(this.el3, Primitive.parse(this.el3).getValue()),
                () -> assertEquals(this.el5, Primitive.parse(this.el5).getValue()),
                () -> assertEquals(this.el6, Primitive.parse(this.el6).getValue()),
                () -> assertEquals(this.el7, Primitive.parse(this.el7).getValue())
        );
    }

    @Test
    @DisplayName("parse(), Testing java types primitive (Integer, Character and etc.). Parse method don't check object on primitive type")
    void parseJavaPrimitiveTypes() {
        assertAll(() -> assertEquals(String.format("\"%s\"", s), Primitive.parse(s).getValue()),
                () -> assertEquals(el, Primitive.parse(el).getValue()),
                () -> assertEquals(el1, Primitive.parse(el1).getValue()),
                () -> assertEquals(el2, Primitive.parse(el2).getValue()),
                () -> assertEquals(el3, Primitive.parse(el3).getValue()),
                () -> assertEquals(el5, Primitive.parse(el5).getValue()),
                () -> assertEquals(el6, Primitive.parse(el6).getValue()),
                () -> assertEquals(el7, Primitive.parse(el7).getValue())
        );
    }
}