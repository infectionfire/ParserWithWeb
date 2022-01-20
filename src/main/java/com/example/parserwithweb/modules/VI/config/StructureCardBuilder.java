package com.example.parserwithweb.modules.VI.config;


import com.example.parserwithweb.modules.VI.ManualCrawler;
import com.example.parserwithweb.modules.VI.PhotoCrawler;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.example.parserwithweb.modules.VI.Advantages.createAdvantages;
import static com.example.parserwithweb.modules.VI.Characteristics.createCharacteristics;
import static com.example.parserwithweb.modules.VI.Equipment.createComplectation;
import static com.example.parserwithweb.modules.VI.Features.createFeatures;
import static com.example.parserwithweb.modules.VI.Weight.createWeight;
import static com.example.parserwithweb.modules.VI.page_processing.GetPageVI.getPage;
import static com.example.parserwithweb.modules.VI.page_processing.GetPageVI.getPageFromUrl;


/**
 * Файл для составления конфигурации описания
 */
public class StructureCardBuilder {
    private static List<String> ttx = new ArrayList<>(100);//если товаров больше сотки поменять тоже
    private static List<String> photos = new ArrayList<>(100);//если товаров больше сотки поменять тоже
    private static List<String> instr = new ArrayList<>(100);//если товаров больше сотки поменять тоже
    private static String oneCard = new String("");
    public static List<String> getTtx() {
        return ttx;
    }

    public static void setTtx(List<String> ttx) {
        StructureCardBuilder.ttx = ttx;
    }

    public static String getOneCard() {
        return oneCard;
    }

    public static void setOneCard(String oneCard) {
        StructureCardBuilder.oneCard = oneCard;
    }

    public static List<String> getPhotos() {
        return photos;
    }

    public static void setPhotos(List<String> photos) {
        StructureCardBuilder.photos = photos;
    }

    public static List<String> getInstr() {
        return instr;
    }

    public static void setInstr(List<String> instr) {
        StructureCardBuilder.instr = instr;
    }

    private StructureCardBuilder() {
        throw new IllegalStateException("Utility class");
    }

    //функции для заполнения ттх
    public static void BuildDescriptions() throws IOException {
        List<String> productCards = new LinkedList<>();
        List<Document> documentList = new ArrayList<>(getPage());
        List<String> photoListBuilder = new LinkedList<>();
        List<String> instrListBuilder = new LinkedList<>();
        for(Document document:documentList) {

            StringBuilder oneProductCard = new StringBuilder();

            oneProductCard.append(createFeatures(document))
                    .append(createCharacteristics(document))
                    .append(createAdvantages(document))
                    .append(createComplectation(document))
                    .append(createWeight(document));
            productCards.add(oneProductCard.toString()
                    .replaceAll(";;",";")
                    .replaceAll("\\.;", ";")
                    .replaceAll("\\.\\.","."));
            photoListBuilder.add(PhotoCrawler.getPhoto(document));
            instrListBuilder.add(ManualCrawler.getManual(document));
            }
        setPhotos(photoListBuilder);
        setInstr(instrListBuilder);
        setTtx(productCards) ;
    }

    public static String BuildDescription(String search) throws IOException {

        Document document = getPageFromUrl(search);

        StringBuilder oneProductCard = new StringBuilder(createFeatures(document)
                .append(createCharacteristics(document))
                .append(createAdvantages(document))
                .append(createComplectation(document))
                .append(createWeight(document)));

        String resultParseLink =  oneProductCard.toString()
                .replaceAll(";;", ";")
                .replaceAll(";;", ";")
                .replaceAll("\\.;", ";")
                .replaceAll("\\.;", ";")
                .replaceAll("\\.\\.", ".")
                .replaceAll("\\.\\.", ".");

        return resultParseLink;
    }
}
