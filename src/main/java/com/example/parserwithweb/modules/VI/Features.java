package com.example.parserwithweb.modules.VI;

import com.example.parserwithweb.modules.VI.methods.HtmlToText;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;


/**
 *Формирование начального текста описания товарной карточки
 */

public class Features{

    private Features() {
        throw new IllegalStateException("Utility class");
    }
    //доделать метод
    @NotNull
    public static StringBuilder createFeatures(Document document)  throws IOException {

        Document page = document;
        Element element = page.select("div.content-block").first();
        if (element!=null){
            return new StringBuilder(HtmlToText.html2text(element.toString())+"\n\n");
        }
        return new StringBuilder("\n\n");
        }
}
