package persistence;

import model.Sneaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

// CONSTRUCTED FROM:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/test/persistence/JsonTest.java
public class JsonTest {
    protected void checkSneaker(double price, double size, String name, String colorway, Sneaker sneaker) {
        assertEquals(name, sneaker.getName());
        assertEquals(price, sneaker.getPrice());
        assertEquals(size, sneaker.getSize());
        assertEquals(name, sneaker.getName());
        assertEquals(colorway, sneaker.getColorway());
        assertFalse(sneaker.isBoughtYet());
    }
}
