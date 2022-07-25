package com.acem.jobscrapper;

import com.acem.jobscrapper.dto.Company;
import com.acem.jobscrapper.dto.Job;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

//This is a Scrapper class for merojobs.com
public class Scrapper {
    private Document doc;
    private List<Job> jobList;

//    public Scrapper(String url) {
//        try {
//            this.doc = Jsoup.connect(url).get();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//
//
//    }

    //returns the total no of jobs found for that keyword search
    public Integer getTotalNoOfJobsFound(Document doc) {
        //for no. of pages
        Elements elements = doc.select("h1#job-count");
        String temp = elements.text();
        String[] tempList = temp.split(" ");


        int index = tempList.length-1;
        //System.out.println("no of jobs found: " + tempList[index]);
        return Integer.parseInt(tempList[index]);
    }

    //returns the no. of jobs listed on the current page.
    public Integer getNoOfJobsInCurrentPage(Document doc) {
        //for no. of pages
        Elements elements = doc.select("h1#job-count");
        String temp = elements.text();
        String[] tempList = temp.split(" ");
        return Integer.parseInt(tempList[3] )- Integer.parseInt(tempList[1]) + 1;
    }

    //returns the no. of pages of results found for that keyword.
    public Integer getNoOfPages(Document doc) {
        //for no. of pages
        Elements elements = doc.select("div.ajax-paginator.text-center");
        String temp = elements.text();
        String[] tempList = temp.split(" ");
        int index = tempList.length-3;
        return Integer.parseInt(tempList[index]);
    }

    //returns the org.jsoup.select.Elements so that we can scrap jobname, company details and deadline from it.
    private Elements getElementsOfJobsInCurrentPage(Document doc) {
        //for the list of jobs in the page
        return doc.select("div#search_job");
    }

//    private List<String> getJobTitles(Elements elements) {
//        List<String> jobTitleList= getStringListFromElements(elements,"h1.text-primary.font-weight-bold.media-heading.h4");
//        return  jobTitleList;
//    }
//
//    private List<String> getJobCompanyNameList(Elements elements) {
//        List<String> jobCompanyNameList =getStringListFromElements(elements, "h3.h6");
//        return  jobCompanyNameList;
//    }
//
//    private List<String> getCompanyLocationList(Elements elements) {
//        //printTextFromElements(elements,"div.location.font-12");
//        List<String> jobLocationList =getStringListFromElements(elements, "div.location.font-12");
//        return  jobLocationList;
//    }
//
//    private List<String> getStringListFromElements(Elements elements, String select) {
//        elements= elements.select(select);
//        String content;
//        List<String> strings = new ArrayList<>();
//        for (Element element : elements) {
//            content = element.text();
//            strings.add(content);
//        }
//        return strings;
//    }
//
//    private List<String> getJobDeadlineList(Elements elements){
//        elements= elements.select("div.col-sm-6 > p > meta");
//        String content;
//        List<String> strings = new ArrayList<>();
//        //couldn't convert Apr 2, 2000, 11:55 p.m. so used string instead.
//        for (Element metaTag : elements) {
//            content =metaTag.attr("content");
//            strings.add(content);
//        }
//        return strings;
//    }
//
//    private List<String> getImageUrlList(Elements elements) {
//        elements =  elements.select("div.col-4.col-md-3.col-lg-3.p-1.text-center > img");
//        String content;
//        List<String> strings = new ArrayList<>();
//        for (Element element : elements) {
//            content = element.attr("abs:src");
//            strings.add(content);
//        }
//        return strings;
//    }

    private String getAbsoluteUrlForNextPage(Document doc) {
//        elements = doc.select("div.ajax-paginator.text-center > a.pagination-next.page-link");
        Elements elements = doc.select("div.ajax-paginator.text-center > nav > ul > li > a.pagination-next.page-link");
        return elements.attr("abs:href");
    }

    private List<Job> scrapCurrentPage(Document doc) {

        Elements elements = getElementsOfJobsInCurrentPage(doc);
        Integer noOfJobsInCurrentPage = getNoOfJobsInCurrentPage(doc);

        Elements jobNameElements = elements.select("h1.text-primary.font-weight-bold.media-heading.h4");
        Elements jobDeadlineElements = elements.select("div.col-sm-6 > p > meta");
        Elements companyNameElements = elements.select("h3.h6");
        Elements companyLocationElements = elements.select("div.location.font-12");
        Elements companyImageUrlElements = elements.select("div.col-4.col-md-3.col-lg-3.p-1.text-center > img");

        List<Job> jobList = new ArrayList<>();
        for(int i=0; i<noOfJobsInCurrentPage; i++){
            Job job = new Job();
            Company company = new Company();
            String tempString;
            if(companyNameElements.size() > i)
                tempString = companyNameElements.get(i).text();
            else{
                tempString = "NA";
            }
            company.setName(tempString);

            if(companyLocationElements.size() > i) {
                tempString = companyLocationElements.get(i).text();
            }else{
                tempString = "NA";
            }
            company.setLocation(tempString);

//            tempString = companyImageUrlElements.get(i).attr("abs:src");
//            company.setLocation(tempString);

            if(companyImageUrlElements.size() > i)
                tempString = companyImageUrlElements.get(i).attr("abs:src");
            else{
                tempString = "NA";
            }
            company.setLogoUrl(tempString);

            job.setCompany(company);
//            System.out.println(company.toString());;


            if(jobNameElements.size() > i)
                tempString = jobNameElements.get(i).text();
            else{
                tempString = "NA";
            }
            job.setName(tempString);

//            tempString = jobDeadlineElements.get(i).attr("content");
//            job.setDeadline(tempString);

            if(jobDeadlineElements.size() > i)
                tempString = jobDeadlineElements.get(i).attr("content");
            else{
                tempString = "NA";
            }
            job.setDeadline(tempString);

            jobList.add(job);
//            System.out.println(job.toString());;
        }
        return jobList;
    }

    public Document getDoc(String url){
        Document doc = null;
        try {
             doc = Jsoup.connect(url).get();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return doc;
    }

    public List<Job> scrap(String url, Integer noOfPages, Integer noOfJobsInCurrentPage) {
        List<Job> clone_list;
        List<Job> jobList = null;
        for (int i = 0; i < noOfPages; i++) {
            Document doc = getDoc(url);

            if (i == 0) {
                List<Job> page1 = scrapCurrentPage(doc);
                clone_list = new ArrayList<Job>(page1);
                jobList = clone_list;
            }
            if (i != 0)
                jobList.addAll(scrapCurrentPage(doc));


            url = getAbsoluteUrlForNextPage(doc);
        }
        return jobList;
    }
}
