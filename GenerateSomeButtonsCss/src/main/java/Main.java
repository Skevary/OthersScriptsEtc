import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {
    /* Bad algorithm, bad code, but it works for my */
    public static void main(String[] args) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(args[0])))    {
            File file = new File("file.txt");
            file.createNewFile();

            for (Path pathFile : stream) {
                if (!pathFile.toFile().isDirectory()) {
                    String str = pathFile.getFileName().toString();
                    System.out.println(str.substring(0, str.indexOf('.')));
                    write("\n");
                    write("\n#" + str.substring(0, str.indexOf('.')) + ".button{");
                    write("\n     -fx-background-image: url(\"file:content/gui/" + str + "\");");
                    write("\n}");
                }
            }
        } catch (IOException | DirectoryIteratorException x) {
            System.err.println(x);
        }
    }

    public static void write(String data) {
        try {
            Files.write(Paths.get("file.txt"), data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
