import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void writeString(String filePath, String data) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
