package com.example.parserwithweb.modules.VI.methods;

import org.jsoup.Jsoup;

/**
 * убирает html теги со страницы
 */
public class HtmlToText {
    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }
}
