package persistence;

import model.Sneaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class JsonTest {
    protected void checkSneaker(double price, double size, String name, String colorway, Sneaker sneaker) {
        assertEquals(name, sneaker.getName());
        assertEquals(size, sneaker.getSize());
        assertEquals(name, sneaker.getName());
        assertEquals(colorway, sneaker.getColorway());
        assertFalse(sneaker.isBoughtYet());
    }
}
