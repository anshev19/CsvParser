import java.util.List;

public class Main {
    public static void main(String args[]) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        CsvParser csvParser = new CsvParser();
        JsonParser jsonParser = new JsonParser();

        List<Employee> list = csvParser.parseCSV(columnMapping, fileName);
        String jsonString = jsonParser.listToJson(list);
        Writer.writeString("data.json", jsonString);

        fileName = "data.xml";
        List<Employee> xmlList = new XmlParser().parseXML(fileName);
        jsonString = jsonParser.listToJson(xmlList);
        Writer.writeString("data2.json", jsonString);

        String json = Reader.readString("data.json");
        List<Employee> jsonList = jsonParser.jsonToList(json);
        jsonList.forEach(System.out::println);
    }
}
