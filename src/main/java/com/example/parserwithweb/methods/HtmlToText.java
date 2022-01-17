package com.example.parserwithweb.methods;

import org.jsoup.Jsoup;

/**
 * убирает html теги со страницы
 */
public class HtmlToText {
    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }
}
