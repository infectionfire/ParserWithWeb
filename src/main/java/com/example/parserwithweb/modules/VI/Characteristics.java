package com.example.parserwithweb.modules.VI;

import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static com.example.parserwithweb.modules.VI.methods.StringCharacterFormatter.characteristicsFormatter;

/**
 * Формирование поля "технические характеристики" для описания товарной карточки
 */

public class Characteristics{//технические характеристики
    private Characteristics() {
        throw new IllegalStateException("Utility class");
    }

    @NotNull
    public static StringBuilder createCharacteristics(Document document) throws IOException {
        StringBuilder charact = new StringBuilder("<strong>Технические характеристики:</strong>\n\n");
        Element element = document
                .select("div.features.spoiler")
                .first();
        if (element!=null) {
            Elements names = element.select("ul");//вытаскиваем инфу из маркированного списка
            Elements values = names.select("li");

            for (Element value : values) {//цикл добавляет значения к строке, попутно форматируя ее
                String text = value.select("span.text").text();
                String valueInf = value.select("span.value").text();
                charact.append(characteristicsFormatter(text, valueInf));
            }
        }
        if (charact.toString().endsWith(";\n")){
            charact.replace(charact.length()-2,charact.length()-1,".");
        }
        return charact.append("\n");
    }
}