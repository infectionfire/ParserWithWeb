package com.example.parserwithweb.modules.VI.page_processing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.example.parserwithweb.modules.VI.methods.ReadingFromFile.readUrlsFromTXTFile;

public class GetPageVI {
    
    public static List<Document> getPage() throws IOException {
            List<Document> documentList = new LinkedList<>();
                        //меняем значение для выбора ссылки, отсчет с нуля
            List<String> urls = new ArrayList<>(readUrlsFromTXTFile());
            for (String url: urls) {
                documentList.add(Jsoup.parse(new URL(url), 45000));
            }
            return documentList;
    }


    public static Document getPageFromUrl(String url)  {
        //меняем значение для выбора ссылки, отсчет с нуля

        try {
            return Jsoup.parse(new URL(url), 45000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Document("Has error");
    }
}
