package com.example.parserwithweb.modules.VI.config;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Записывает информацию о товаре в текстовый файл testFile.txt
 * актуально для единичной выборки
 */

public class WriteToFile {


    static File file = new File("testFile.txt");

    public static void main(String[] args) throws IOException {
        try(PrintWriter pw = new PrintWriter(file)) {
            StructureCardBuilder.BuildDescriptions();
            pw.println(StructureCardBuilder.getTtx());
            pw.println("Successfully!");
        }
    }
}



