package HashMaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueCharacterTest {

    @Test
    public void testUniqueSimple() {
        assertEquals(1, FirstUniqueCharacter.firstUniqueCharacter("test"));
    }

    @Test
    public void testUniqueNoResult() {
        assertEquals(-1, FirstUniqueCharacter.firstUniqueCharacter("lool"));
    }
}