package configReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.util.HashMap;

public class JsonFilerReader {


    /**
     * @Author Rim Gammoudi
     */


    //Method useful for reading jsonFile
    //converting json file into hashmap
    public static HashMap<String, String> readingTheJsonFile(String jsonFilePath) {

        try {
            // 1. Use the ClassLoader to stream the file safely from the resources root
            InputStream inputStream = JsonFilerReader.class.getClassLoader().getResourceAsStream(jsonFilePath);

            if (inputStream == null) {
                throw new IllegalArgumentException("Target JSON file not found at path: " + jsonFilePath);
            }

            // 2. Instantiate Jackson's ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Parse the JSON stream directly into a standard mutable HashMap
            return mapper.readValue(inputStream, new TypeReference<HashMap<String, String>>() {
            });

        } catch (Exception e) {
            throw new RuntimeException("Failed to read or parse JSON file at: " + jsonFilePath, e);


        }

    }
}
