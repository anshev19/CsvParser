import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;

public class ParserTest {
    private static List<Employee> expectedEmployeeList;
    private static final String expectedJson = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"firstName\": \"John\",\n" +
            "    \"lastName\": \"Smith\",\n" +
            "    \"country\": \"USA\",\n" +
            "    \"age\": 25\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 2,\n" +
            "    \"firstName\": \"Ivan\",\n" +
            "    \"lastName\": \"Petrov\",\n" +
            "    \"country\": \"RU\",\n" +
            "    \"age\": 23\n" +
            "  }\n" +
            "]";

    private static final String expectedCleanedJson = "[" +
            "  {" +
            "    \"id\": 1," +
            "    \"firstName\": \"John\"," +
            "    \"lastName\": \"Smith\"," +
            "    \"country\": \"USA\"," +
            "    \"age\": 25" +
            "  }," +
            "  {" +
            "    \"id\": 2," +
            "    \"firstName\": \"Ivan\"," +
            "    \"lastName\": \"Petrov\"," +
            "    \"country\": \"RU\"," +
            "    \"age\": 23" +
            "  }" +
            "]";

    @BeforeAll
    public static void BeforeAll() {
        expectedEmployeeList = new ArrayList<>();
        expectedEmployeeList.add(new Employee(1, "John", "Smith", "USA", 25));
        expectedEmployeeList.add(new Employee(2, "Ivan", "Petrov", "RU", 23));
    }

    @Test
    public void CsvParserTest() {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        CsvParser csvParser = new CsvParser();

        List<Employee> employeeList = csvParser.parseCSV(columnMapping, "data.csv");
        assertThat(employeeList, contains(expectedEmployeeList.get(0), expectedEmployeeList.get(1)));
    }

    @Test
    public void XmlParserTest() {
        XmlParser xmlParser = new XmlParser();
        List<Employee> employeeList = xmlParser.parseXML("data.xml");
        assertThat(employeeList, contains(expectedEmployeeList.get(0), expectedEmployeeList.get(1)));
    }

    @Test
    public void jsonParserTest() {
        JsonParser jsonParser = new JsonParser();
        String json = Reader.readString("data.json");
        List<Employee> employeeList = jsonParser.jsonToList(json);
        assertThat(employeeList, contains(expectedEmployeeList.get(0), expectedEmployeeList.get(1)));
    }

    @Test
    public void listToJsonTest() {
        JsonParser jsonParser = new JsonParser();
        String json = jsonParser.listToJson(expectedEmployeeList);
        assertThat(json, equalToIgnoringWhiteSpace(expectedJson));
    }

    @Test
    public void fileReadingTest() {
        String data = Reader.readString("data.json");
        assertThat(data, equalToIgnoringWhiteSpace(expectedCleanedJson));
    }

    @Test
    public void fileWritingTest() {
        Writer.writeString("data.json", expectedJson);
        String data = Reader.readString("data.json");

        assertThat(data, equalToIgnoringWhiteSpace(expectedCleanedJson));
    }
}
