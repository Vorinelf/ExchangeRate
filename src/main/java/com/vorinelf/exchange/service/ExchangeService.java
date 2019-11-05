package com.vorinelf.exchange.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ExchangeService {
    private ArrayList<String> regionList = new ArrayList<>();
    private ArrayList<String> citiesList = new ArrayList<>();
    private ArrayList<String> currencyList;

    private String oblast = " область";

    private static final String MinskRegion = "Минская область";
    private static final String GomelRegion = "Гомельская область";
    private static final String VitebskRegion = "Витебская область";
    private static final String GrodnoRegion = "Гродненская область";
    private static final String BrestRegion = "Бресткая область";
    private static final String MogilevRegion = "Могилевская область";

    private String TrueRegionAfterTranslate;

    private String trueRegion;
    private String falseRegion;

    private String trueCity;
    private String falseCity;


    public ExchangeService() {
    }

    public String getAndCheckRegion(String region) throws IOException {

        Document htmlRegionsFromSite = Jsoup.connect("https://myfin.by/currency/minsk").get();

        Elements elementsRegions = htmlRegionsFromSite.getElementsByAttributeValue("class", "item-list col-md-2 col-sm-3 col-xs-12");
        elementsRegions.forEach(elementRegion -> {
            String existingRegion = elementRegion.child(0).text();
            regionList.add(existingRegion);
        });

        if (regionList.contains(region + getOblast())) {
            trueRegion = region + getOblast();
            return trueRegion;
        } else {
            falseRegion = "There is not " + region + getOblast();
            return falseRegion;
        }
    }

    public void translateRegion() {
        switch (getTrueRegion()) {
            case MinskRegion:
                setTrueRegionAfterTranslate("region-5");
                break;
            case GomelRegion:
                setTrueRegionAfterTranslate("region-3");
                break;
            case BrestRegion:
                setTrueRegionAfterTranslate("region-1");
                break;
            case GrodnoRegion:
                setTrueRegionAfterTranslate("region-4");
                break;
            case VitebskRegion:
                setTrueRegionAfterTranslate("region-2");
                break;
            case MogilevRegion:
                setTrueRegionAfterTranslate("region-6");
                break;
        }
    }

    public String getAndCheckCity(String city) throws IOException {
        translateRegion();

        Document htmlCitiesFromSite = Jsoup.connect("https://myfin.by/currency/" + getTrueRegionAfterTranslate()).get();

        Elements elementsCities = htmlCitiesFromSite.getElementsByAttributeValue("id", getTrueRegionAfterTranslate());
        elementsCities.forEach(elementCity -> {
            for (Element existingCity : elementCity.select("a")) {
                citiesList.add(existingCity.text());
            }
        });

        if (citiesList.contains(city)) {
            trueCity = city;
            return trueCity;
        } else {
            falseCity = "There is not " + city;
            return falseCity;
        }

    }


    public ArrayList<String> getRegionList() {
        return regionList;
    }

    public void setRegionList(ArrayList<String> regionList) {
        this.regionList = regionList;
    }

    public ArrayList<String> getCitiesList() {
        return citiesList;
    }

    public void setCitiesList(ArrayList<String> citiesList) {
        this.citiesList = citiesList;
    }

    public ArrayList<String> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(ArrayList<String> currencyList) {
        this.currencyList = currencyList;
    }

    public String getOblast() {
        return oblast;
    }

    public void setOblast(String oblast) {
        this.oblast = oblast;
    }

    public String getTrueRegion() {
        return trueRegion;
    }

    public void setTrueRegion(String trueRegion) {
        this.trueRegion = trueRegion;
    }

    public String getFalseRegion() {
        return falseRegion;
    }

    public void setFalseRegion(String falseRegion) {
        this.falseRegion = falseRegion;
    }

    public String getMinskRegion() {
        return MinskRegion;
    }

    public String getTrueRegionAfterTranslate() {
        return TrueRegionAfterTranslate;
    }

    public void setTrueRegionAfterTranslate(String trueRegionAfterTranslate) {
        TrueRegionAfterTranslate = trueRegionAfterTranslate;
    }
}


