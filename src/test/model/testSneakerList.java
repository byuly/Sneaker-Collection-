package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testSneakerList {
    private SneakerList testSneakerList;
    private Sneaker s1;
    private Sneaker s2;
    private Sneaker s3;
    private Sneaker s4;
    private DateForSneaker d1;
    private DateForSneaker d2;


    @BeforeEach
    void runBefore() {
        s1 = new Sneaker(99.99, 9.5, "Nike Jordan 1s", "Yellow");
        d1 = new DateForSneaker();
        d1.setDate(2005, 5, 15);
        s1.setDateSneaker(d1);
        s2 = new Sneaker(200.00, 9.5, "Adidas Superstars", "White");
        d2 = new DateForSneaker();
        d2.setDate(2013, 6, 18);
        s2.setDateSneaker(d2);
        s3 = new Sneaker(10.00, 9.0, "New Balance 550", "Grey");
        d2 = new DateForSneaker();
        d2.setDate(2013, 6, 18);
        s3.boughtWanted();
        s3.setDateSneaker(d2);
        testSneakerList = new SneakerList();

    }

    @Test
    void testAddSneaker() {
        testSneakerList.addSneaker(s1);
        assertEquals(1, testSneakerList.getSneakerList().size());
        testSneakerList.addSneaker(s2);
        testSneakerList.addSneaker(s3);
        assertEquals(3, testSneakerList.getSneakerList().size());
    }

    @Test
    void testRemoveSneaker() {
        testSneakerList.addSneaker(s1);
        testSneakerList.addSneaker(s2);
        testSneakerList.addSneaker(s3);
        testSneakerList.refreshCollections();
        assertEquals(1, testSneakerList.getSneakerOwnList().size());
        assertEquals(2, testSneakerList.getSneakerWantList().size());
        testSneakerList.removeSneaker(s1);
        assertEquals(2, testSneakerList.getSneakerList().size());
        assertEquals(1, testSneakerList.getSneakerWantList().size());
        testSneakerList.removeSneaker(s3);
        assertEquals(1, testSneakerList.getSneakerList().size());
        assertEquals(0, testSneakerList.getSneakerOwnList().size());
        testSneakerList.removeSneaker(s2);
        assertEquals(0, testSneakerList.getSneakerList().size());
        assertEquals(0, testSneakerList.getSneakerOwnList().size());
        assertEquals(0, testSneakerList.getSneakerWantList().size());
    }

    @Test
    void testClearSneaker() {
        testSneakerList.addSneaker(s1);
        testSneakerList.addSneaker(s2);
        testSneakerList.addSneaker(s3);
        testSneakerList.refreshCollections();
        testSneakerList.clearSneakerList();
        assertEquals(0, testSneakerList.getSneakerList().size());
        assertEquals(0, testSneakerList.getSneakerOwnList().size());
        assertEquals(0, testSneakerList.getSneakerWantList().size());
    }

    @Test
    void testSneakerSearch() {
        testSneakerList.addSneaker(s1);
        testSneakerList.addSneaker(s2);
        testSneakerList.addSneaker(s3);
        testSneakerList.refreshCollections();
        ArrayList<Sneaker> s1list = new ArrayList<>();
        s1list.add(s1);
        assertEquals(s1list, testSneakerList.getSneakerSearch("Nike"));
        s4 = new Sneaker(100.00, 9.5, "Nike Jordan 700s", "black");
        s1list.add(s4);
        testSneakerList.addSneaker(s4);
        assertEquals(s1list, testSneakerList.getSneakerSearch("Nike"));
    }

    @Test
    void testNamesSneaker() {
        testSneakerList.addSneaker(s1);
        testSneakerList.addSneaker(s2);
        testSneakerList.addSneaker(s3);
        s4 = new Sneaker(100.00, 9.5, "Nike Jordan 700s", "black");
        testSneakerList.addSneaker(s4);
        ArrayList<String> names = new ArrayList<>();
        names.add(s1.getName());
        names.add(s2.getName());
        names.add(s3.getName());
        names.add(s4.getName());
        assertEquals(names, testSneakerList.listOfNames());
    }


}
