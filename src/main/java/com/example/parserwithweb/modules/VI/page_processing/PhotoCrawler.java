package com.example.parserwithweb.modules.VI.page_processing;

import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Парсит страницу и берет первое фото товара
 * можно переделать, сделать сплит через " и вытаскивать ссылки через endWith
 */

public class PhotoCrawler implements Create{

    private static String photo = "";

    public static String getPhoto(Document document) throws IOException {
        PhotoUrlsCreate(document);
        return photo;
    }
    @NotNull
    public static String  PhotoUrlsCreate(Document document) throws IOException {
        Document page = document;
        Element imageElement = page.select("div.item").first();
        photo=imageElement.toString().replaceAll("<div class=\"stage\" data-behavior=\"stage\">","")
                .replaceAll("<div class=\"item -active\" data-behavior=\"item\">","")
                .replaceAll("<img src=\"data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7\" data-src=\"","");
        String[] ph = photo.split("\"");
        photo=ph[0].strip();
        return photo;
        }
}

