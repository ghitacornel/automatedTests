package junit.cases.files;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestTemporaryFolder {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void testWrite() throws IOException {

        // Create a temporary file.
        File temporaryFile = temporaryFolder.newFile("temporaryFile.txt");

        // Write something to it.
        new ServiceUsingAFile().writeToFile(temporaryFile);

        // Read it from temp file
        String content = new String(Files.readAllBytes(Paths.get(temporaryFile.getPath())));

        // Verify the content
        Assert.assertEquals("hello world", content);

        //Note: File is guaranteed to be deleted after the test finishes.
    }
}
