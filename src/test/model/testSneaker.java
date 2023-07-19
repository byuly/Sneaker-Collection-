package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testSneaker {
    private Sneaker testSneaker;
    private DateForSneaker date;

    @BeforeEach
    void runBefore() {
        testSneaker = new Sneaker(99.99, 9.5, "Nike", "Yellow");
        date = new DateForSneaker();
        date.setDate(2005, 5, 15);
        testSneaker.setDate(date);
    }

    @Test
    void testConstructor() {
        assertEquals(99.99, testSneaker.getPrice());
        assertEquals(9.5, testSneaker.getSize());
        assertEquals("Nike", testSneaker.getName());
        assertEquals("Yellow", testSneaker.getColorway());
        assertEquals("2005/5/15", testSneaker.getDate());
    }

    @Test
    void testIncreasePriceOne() {
        testSneaker.increasePrice(50.00);
        assertEquals(149.99, testSneaker.getPrice());
        testSneaker.increasePrice(50.01);
        assertEquals(200.00, testSneaker.getPrice());
    }

    @Test
    void testDecreasePrice() {
        testSneaker.decreasePrice(50.00);
        assertTrue(Math.abs(49.99 - testSneaker.getPrice()) < 0.0001);
        testSneaker.decreasePrice(testSneaker.getPrice());
        assertEquals(0, testSneaker.getPrice());
    }


}
