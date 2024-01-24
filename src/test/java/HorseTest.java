import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class HorseTest {

    @Test
    public void nullNameException() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1));
        assertEquals("Name cannot be null.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   ", "\t\t", "\n\n\n\n"})
    public void blankNameException(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Horse(name, 1));
        assertEquals("Name cannot be blank.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, 0, -99})
    public void negativeSpeed(int speed) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Horse("Zeus", speed));
        assertEquals("Speed cannot be negative.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Zeus", "Mustang", "Fara"})
    public void getNameTest(String name) {
        assertEquals(name, new Horse(name, 1).getName());
    }

    @Test
    public void zeroDistance() {
        assertEquals(0, new Horse("Zeus", 5).getDistance());
    }
}
