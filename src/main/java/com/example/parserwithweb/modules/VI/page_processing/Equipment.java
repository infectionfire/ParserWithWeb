package com.example.parserwithweb.modules.VI.page_processing;

import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Формирование поля "Комплектация" для описания товарной карточки
 */

public class Equipment implements Create{

    private Equipment() {
        throw new IllegalStateException("Utility class");
    }
    @NotNull
    public static StringBuilder createComplectation(Document document) throws IOException {
        StringBuilder equipment = new StringBuilder("<strong>Комплектация:</strong>\n\n");
        Document page = document;

        Element tableParameter = page.select("div.equipment.spoiler").first();
        if (tableParameter!=null){

            Elements names = tableParameter.select("ul");
            Elements values = names.select("li");

            for (Element value : values) {
                String theme = value.select("li").text();
                equipment.append("- ").append(theme).append(";\n");
                }
            equipment = new StringBuilder(equipment.toString().replace(";;", ";"));

            StringBuilder temp = equipment.replace(equipment.length()-2,equipment.length()-1,".")
                    .append("\n");
            equipment = new StringBuilder(temp.toString()
                    .replace("..", "."));
        }
        return equipment;
    }
}