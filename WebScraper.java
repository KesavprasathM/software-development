import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.bbc.com/news").get();
            Elements headlines = doc.select("h3");

            System.out.println("BBC News Headlines:");
            int count = 1;
            for (Element headline : headlines) {
                System.out.println(count++ + ". " + headline.text());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}