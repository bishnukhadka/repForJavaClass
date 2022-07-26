package com.acem.jobscrapper;

import com.acem.jobscrapper.dto.Job;
import com.acem.jobscrapper.dto.Jsonmapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.awt.desktop.ScreenSleepEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://merojob.com/search/?q=");
        String searchPhrase ;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter job title your are looking for: ");
        searchPhrase = scanner.nextLine();
        stringBuilder.append(searchPhrase);

        String url = stringBuilder.toString();
        System.out.println(url);

        Scrapper scrapper = new Scrapper();
        Document doc = scrapper.getDoc(url);
        Integer noOfPages = scrapper.getNoOfPages(doc);
        System.out.println("No. of pages: " + noOfPages);
        Integer totalJobs = scrapper.getTotalNoOfJobsFound(doc);
        System.out.println("Total no. of Jobs found: " + totalJobs);
        Integer noOfJobsInCurrentPage = scrapper.getNoOfJobsInCurrentPage(doc);


        List<Job> jobList = scrapper.scrap(url,noOfPages);

        Jsonmapper jsonmapper = new Jsonmapper();

        //printing the object as JSON
        for(int i=0; i< jobList.size(); i++){
            System.out.println(jsonmapper.mapToJSON(jobList.get(i)));
        }


    }









}
