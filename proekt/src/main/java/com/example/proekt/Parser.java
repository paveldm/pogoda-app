package com.example.proekt;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class Parser {
    public String[] city = new String[200];// Города
    public int[] temperature = new int[200];// Их температура
    public int[] Humidity = new int[200];//Влажность
    public int[] Pressure = new int[200];//Давление
    public int[] Wind = new int[200];//Ветер(м/с)
    //параметры города располдожены в i ячейке каждого массива(индексы всех массивов совпадаеют с индексом ячейки,где содержится название города
    Parser() throws IOException {
        startParse();
    }
    private Document getPage() throws IOException{
        String url = "https://pogoda.mail.ru/country/russia/";
        Document page = Jsoup.parse(new URL(url),3000);
        return page;
    }
    private void startParse() throws IOException{
        Document page = getPage();
        Elements tableWth = page.select("li[data-logger]");
        Element table;
        int j = 0;
        for(Element i : tableWth)
        {
            String name = i.select("a").text();
            String Temperature = i.select(".city-list__val-temperature").text();
            Temperature = Temperature.substring(0,Temperature.length()-1);
            String humidity = i.select(".city-list__val-humidity").text();
            humidity = humidity.substring(0,humidity.length()-1);
            String pressure = i.select(".city-list__val-pressure").text();
            pressure = pressure.substring(0,pressure.length()-3);
            String wind = i.select(".city-list__val-wind").text();
            int Temp =Integer.parseInt(Temperature);
            int Humidit =Integer.parseInt(humidity);
            int Pressur =Integer.parseInt(pressure);
            int win =Integer.parseInt(wind);
            city[j] = name;
            temperature[j] = Temp;
            Humidity[j] = Humidit;
            Pressure[j] = Pressur;
            Wind[j] = win;
            j++;
        }
    }
    public CityInfo getInfo(String cityName){
        int index = Arrays.asList(city).indexOf(cityName);
        if(index==-1)
            return null;
        else
            return new CityInfo(city[index], temperature[index], Humidity[index],Pressure[index],Wind[index]);
    }
}