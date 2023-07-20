package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class testSneaker {
    private Sneaker testSneaker;


    @BeforeEach
    void runBefore() {
        testSneaker = new Sneaker(99.99, 9.5, "Nike", "Yellow");
    }

    @Test
    void testConstructor() {
        assertEquals(99.99, testSneaker.getPrice());
        assertEquals(9.5, testSneaker.getSize());
        assertEquals("Nike", testSneaker.getName());
        assertEquals("Yellow", testSneaker.getColorway());
    }

    @Test
    void testSetSize() {
        testSneaker.setSize(6.0);
        assertEquals(6.0, testSneaker.getSize());
    }

    @Test
    void testSetName() {
        testSneaker.setName("adidas");
        assertEquals("adidas", testSneaker.getName());
    }

    @Test
    void testSetPrice() {
        testSneaker.setPrice(100.00);
        assertEquals(100.00, testSneaker.getPrice());
    }

    @Test
    void testSetOwn() {
        testSneaker.setOwned(true);
        assertTrue(testSneaker.isBoughtYet());
    }


    @Test
    void testSetColorWay() {
        testSneaker.setColorway("Blue");
        assertEquals("Blue", testSneaker.getColorway());
    }

    @Test
    void testBoughtStatus() {
        testSneaker.boughtWanted();
        assertTrue(testSneaker.isBoughtYet());
        testSneaker.soldOwned();
        assertFalse(testSneaker.isBoughtYet());
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
