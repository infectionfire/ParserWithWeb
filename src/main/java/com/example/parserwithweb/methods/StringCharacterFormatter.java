package com.example.parserwithweb.methods;

import java.util.List;

public class StringCharacterFormatter {

    public static StringBuilder characteristicsFormatter(String text, String valueInf){
        StringBuilder characters = new StringBuilder();
        if(!text.equals("")) {
            List<String> stringList = List.of(text.split(", "));
            if (stringList.size() > 1) {//конструктор строки
                characters.append("- ")
                        .append(stringList.get(0))
                        .append(": ")
                        .append(valueInf)
                        .append(" ")
                        .append(stringList.get(1))
                        .append(";\n");
            }else {
                characters.append("- ")
                        .append(text).append(": ")
                        .append(valueInf)
                        .append(";\n");
            }
        }
        return characters;
    }
}
