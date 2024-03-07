package org.shob3r;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main
{
    public static void main(String[] args)
    {
        ScraperUtils utils = new ScraperUtils();
        try
        {
            System.out.println(utils.getWeather());
            System.out.println(utils.getStockPrice());
        }
        catch(IOException|URISyntaxException exception)
        {
            System.out.println("An Error Occurred: " + exception);
        }
    }
}
