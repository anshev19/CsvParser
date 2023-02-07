import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public String listToJson(List<Employee> objectList) {
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        Gson gson = builder.create();
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        return gson.toJson(objectList, listType);
    }

    public List<Employee> jsonToList(String json) {
        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        var res = parser.parse(json).getAsJsonArray();
        List<Employee> staff = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            staff.add(gson.fromJson(res.get(i), Employee.class));
        }
        return staff;
    }
}
