import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Reader {
    public static String readString(String filePath) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Stream<String> stream = null;
            if (reader.ready()) {
                stream = reader.lines();
            }
            if (stream == null) {
                return null;
            }
            stream.forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
