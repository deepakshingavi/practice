import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupExample {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://example.com").get();
        Elements links = doc.select("a");
    }
}
