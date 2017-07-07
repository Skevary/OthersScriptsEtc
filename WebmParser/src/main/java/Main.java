import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    /* Very simple console-.webm parser */
    public static void main(String[] args) throws IOException {
        String URL;
        String PATH;
        String SEPARATOR = "\\";

        if (args.length == 2) {
            URL = args[0];
        PATH = args[1];
    } else {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the URL: ");
        URL = sc.nextLine();
        System.out.print("Enter the PATH: ");
        PATH = sc.nextLine();
    }

        Elements links = Jsoup.connect(URL).get().select("a[href$=.webm]");
        for (Element link : links) {
            String fileName = link.text();
            URL absUrl = new URL(link.absUrl("abs:href"));
            File file = new File(PATH + SEPARATOR + fileName);

            if (!file.exists()) {
                FileUtils.copyURLToFile(absUrl, file);
                System.out.println("File " + fileName + " is successfully loaded");
            }
        }
    }
}