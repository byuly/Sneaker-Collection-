package persistence;

import model.Sneaker;
import model.SneakerList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            SneakerList wr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            SneakerList wr = reader.read();
            assertEquals(0, wr.getSneakers().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            SneakerList wr = reader.read();

            List<Sneaker> sneakers = wr.getSneakers();
            assertEquals(2, sneakers.size());
            checkSneaker(1000, 9, "Nikes", "White", sneakers.get(0));
            checkSneaker(140, 9, "Jordans", "Black", sneakers.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
