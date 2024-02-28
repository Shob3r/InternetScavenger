package org.shob3r;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        ScraperUtils utils = new ScraperUtils();
        String testWebsiteData = utils.webGetRequest("https://cdn.lemon-studios.ca");
        Document document = Jsoup.parse(testWebsiteData);
        System.out.println(document.title());
        Elements paragraphs = document.getAllElements();
        for (Element paragraph : paragraphs)
        {
            System.out.println(paragraph.text());
        }
    }
}