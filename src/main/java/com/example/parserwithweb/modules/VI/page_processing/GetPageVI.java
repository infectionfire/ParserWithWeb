package com.example.parserwithweb.modules.VI.page_processing;

import com.example.parserwithweb.entity.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.example.parserwithweb.modules.VI.methods.ReadingFromFile.readUrlsFromTXTFile;

public class GetPageVI {
    
    public static List<Document> getPage() throws IOException {
            List<Document> documentList = new ArrayList<>();
                        //меняем значение для выбора ссылки, отсчет с нуля
            List<String> urls = readUrlsFromTXTFile();
            for (String url: urls) {
                documentList.add(Jsoup.parse(new URL(url), 45000));
            }
            return documentList;
    }


    public static Document getPageFromUrl(String url) throws IOException {
        //меняем значение для выбора ссылки, отсчет с нуля
        return Jsoup.parse(new URL(url), 45000);
    }
}
