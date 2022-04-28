import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class NIOFileApiTest {

    @Test
    public void givenPath_WhenCheck_thenConfirm() throws IOException {
        //check file exist
        Path filePath = Paths.get("D:\\bridgelab\\java_io_operations\\FileTest");
        Assertions.assertTrue(Files.exists(filePath));

        //delete file  and check file not exist
        Path newFilePath = Paths.get("D:\\bridgelab\\java_io_operations\\FileTest"+"\\"+"testDirectory");
        if(Files.exists(newFilePath)) Files.delete(newFilePath);
        Assertions.assertTrue(Files.notExists(newFilePath));

        //create Directory
        Files.createDirectory(newFilePath);
        Assertions.assertTrue(Files.exists(newFilePath));

        //create Files
        IntStream.range(1,10).forEach(cnt->{
            Path tempFile = Paths.get(newFilePath+"/temp"+cnt);
            Assertions.assertTrue(Files.notExists(tempFile));
            try{
                Files.createFile(tempFile);
            }catch (IOException e) {
                e.printStackTrace();
            }
            Assertions.assertTrue(Files.exists(tempFile));
        });

        Files.list(newFilePath).filter(Files::isRegularFile).forEach(System.out::println);
        System.out.println("----------------");
        Files.newDirectoryStream(newFilePath).forEach(System.out::println);
        System.out.println("----------------");
        Files.newDirectoryStream(newFilePath,path-> path.toFile().isFile() && path.startsWith("temp")).forEach(System.out::println);
    }
}
