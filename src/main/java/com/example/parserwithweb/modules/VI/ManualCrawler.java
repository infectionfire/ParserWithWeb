package com.example.parserwithweb.modules.VI;

import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Парсит страницу и берет ссылку на инструкцию если она есть
 * в случае отсутствия инструкции в формате PDF возвращает пустую строку для заполнения ячейки в эксель
 */

public class ManualCrawler{
    private static String instr = "";


    public static String getManual(Document document) throws IOException {
        CreateInstrUrl(document);
        return instr;
    }
    @NotNull
    public static String CreateInstrUrl(Document document) throws IOException {
        StringBuilder setInstr = new StringBuilder("");
        Document page = document;
        Element imageElement = page.select("ul.unordered-list.-links.spoiler.-download").first();
        if (imageElement != null) {
            instr = imageElement.toString();
            String[] ins = instr.split("<a href=\"//");
            ins = ins[1].split("\"");
            setInstr= new StringBuilder("https://"+ins[0]);
            if (!setInstr.toString().endsWith(".pdf")) {
                setInstr = new StringBuilder("");
            }
        }
        instr=setInstr.toString();

        return instr;
    }
}





