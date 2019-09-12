package junit.cases.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ServiceUsingAFile {

    public void writeToFile(File file) {
        try {
            String str = "hello world";
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(str);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
