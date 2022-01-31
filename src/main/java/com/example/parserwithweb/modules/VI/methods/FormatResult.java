package com.example.parserwithweb.modules.VI.methods;

public class FormatResult {

    public static String formatCardCharact(StringBuilder stringBuilder){
        return stringBuilder.toString().replaceAll(";;", ";")
                .replaceAll(";;", ";")
                .replaceAll("\\.;", ";")
                .replaceAll("\\.;", ";")
                .replaceAll("\\.\\.", ".")
                .replaceAll("\\.\\.", ".");
    }
}
