package com.acem.jobscrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) {


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://merojob.com/search/?q=");
        String searchPhrase = "java";
        stringBuilder.append(searchPhrase);

        String url = stringBuilder.toString();

        try{
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("div.search_jobs.r > div.text-primary.font-weight-bold.media-heading.h4");
            System.out.println(elements);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}
