package org.shob3r;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class ScraperUtils
{
    public String genericGetRequest(String url) throws IOException
    {
        Document webData = Jsoup.connect(url).get();
        return webData.toString();
    }


    public String getWeather() throws IOException, URISyntaxException
    {
        Document unfilteredWebsiteData = Jsoup.parse(genericGetRequest("https://bit.ly/ISSurreyWeather"));
        Element currentConditions = unfilteredWebsiteData.select("div.CurrentConditions--phraseValue--mZC_p").first();
        Element currentTemp = unfilteredWebsiteData.select("span.CurrentConditions--tempValue--MHmYY").first();

        assert currentConditions != null;
        assert currentTemp != null;
        return "It is currently: " + currentConditions.ownText() + " with a temperature of: " +  currentTemp.ownText() + "°C" ;
    }

    public String getStockPrice() throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which stock price would you like to inspect? (eg. GOOGL for google stock)");
        String stockToSearch = bufferedReader.readLine();


        String link = "https://ca.finance.yahoo.com/quote/" + stockToSearch + "?.tsrc=fin-srch";
        Document googleStockData = Jsoup.parse(genericGetRequest(link));

        Element currentPrice = googleStockData.select("div.kf1m0").first();
        Element priceChangePercentage = googleStockData.select("div.JwB6zf").first();

        assert currentPrice != null;
        assert priceChangePercentage != null;

        return currentPrice.ownText() + " up/down from " + priceChangePercentage.ownText();
    }
}
