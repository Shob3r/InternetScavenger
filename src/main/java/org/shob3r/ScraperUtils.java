package org.shob3r;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class ScraperUtils
{
    public String genericGetRequest(String url) throws IOException
    {
        URL webRequest = new URL(url);
        URLConnection websiteConnection = webRequest.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(websiteConnection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString();
    }


    public String getWeather() throws IOException, URISyntaxException
    {
        // Specifically weather from Surrey, BC. wather.com just directs to the weather in Ottawa for some reason
        URL weatherSite = new URI("https://weather.com/en-CA/weather/today/l/a73833653e7ff893ddf37e18c1df7e700b3985c8fd085f737d95df7d3c0fc6c5").toURL();
        Document unfilteredWebsiteData = Jsoup.parse(weatherSite, 20000);

        Element currentConditions = unfilteredWebsiteData.select("div.CurrentConditions--phraseValue--mZC_p").first();
        Element currentTemp = unfilteredWebsiteData.select("span.CurrentConditions--tempValue--MHmYY").first();

        assert currentConditions != null;
        assert currentTemp != null;
        String content = "It is currently: " + currentConditions.ownText() + " with a temperature of: " +  currentTemp.ownText() + "°C" + "\ntoday's highs/lows are: " + "";
        System.out.println(content);

        return content;
    }
}
