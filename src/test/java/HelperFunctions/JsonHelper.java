package HelperFunctions;

import POJO.UserDataPOJO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonHelper {
    private final ObjectMapper mapper;

    // Constructor
    public JsonHelper() {
        this.mapper = new ObjectMapper();
    }

    public List<UserDataPOJO> getUserList(String filePath) {
        try {
            return mapper.readValue(new File(filePath), new TypeReference<List<UserDataPOJO>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON list: " + filePath, e);
        }
    }


}
