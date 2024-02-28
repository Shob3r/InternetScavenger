package org.shob3r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

public class ScraperUtils
{


    public String webGetRequest(String url) throws IOException
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
}
