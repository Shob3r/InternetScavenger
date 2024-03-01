package org.shob3r;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URISyntaxException;


public class Main
{
    public static void main(String[] args)
    {
        ScraperUtils utils = new ScraperUtils();
        try
        {
            utils.getWeather();
        }
        catch(IOException | URISyntaxException e)
        {
            System.out.println(e);
        }

    }
}