import java.util.List;

public class Main {
    public static void main(String args[]) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        CsvParser csvParser = new CsvParser();
        JsonParser<Employee> jsonParser = new JsonParser<>();

        List<Employee> list = csvParser.parseCSV(columnMapping, fileName);
        String jsonString = jsonParser.listToJson(list);
        Writer.writeString("data.json", jsonString);
    }
}
