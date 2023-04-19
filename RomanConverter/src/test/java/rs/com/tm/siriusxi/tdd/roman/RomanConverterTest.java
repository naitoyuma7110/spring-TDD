package rs.com.tm.siriusxi.tdd.roman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static rs.com.tm.siriusxi.tdd.roman.RomanConverter.convertRomanToArabicNumber;

class RomanConverterTest {
    @Test
    void convertI() {
        assertEquals(1, convertRomanToArabicNumber("I"),
                "Roman I should equal to 1");
    }

    @Test
    void convertII() {
        assertEquals(2, convertRomanToArabicNumber("II"),
                "Roman II should equal to 2");
    }

    @Test
    void convertIII() {
        assertEquals(3, convertRomanToArabicNumber("III"),
                "Roman III should equal to 3");
    }


    @Test
    void convertV() {
        assertEquals(5, convertRomanToArabicNumber("V"),
                "Roman V should equal to 5");
    }

    @Test
    void convertIV() {
        assertEquals(4, convertRomanToArabicNumber("IV"),
                "Roman V should equal to 4");
    }

    @Test
    void convertVI() {
        assertEquals(6, convertRomanToArabicNumber("VI"),
                "Roman V should equal to 6");
    }



}
