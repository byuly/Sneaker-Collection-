package persistence;


import model.Sneaker;
import model.SneakerList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
// CONSTRUCTED FROM :
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonReader.java

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public SneakerList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseSneakerList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private SneakerList parseSneakerList(JSONObject jsonObject) {
        SneakerList wr = new SneakerList();
        addSneakers(wr, jsonObject);
        return wr;
    }

    // MODIFIES: wr
    // EFFECTS: parses sneakers from JSON object and adds them to workroom
    private void addSneakers(SneakerList wr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("sneakers");
        for (Object json : jsonArray) {
            JSONObject nextSneaker = (JSONObject) json;
            addSneaker(wr, nextSneaker);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addSneaker(SneakerList wr, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String colorway = jsonObject.getString("colorway");
        Double price = jsonObject.getDouble("price");
        Double size = jsonObject.getDouble("size");
        Boolean boughtYet = jsonObject.getBoolean("boughtYet");
        Sneaker sneaker = new Sneaker(price, size, name, colorway);
        sneaker.setOwned(boughtYet);
        wr.addSneaker(sneaker);
    }
}
