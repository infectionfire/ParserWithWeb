package com.example.parserwithweb.modules.VI.config;


import com.example.parserwithweb.modules.VI.page_processing.ManualCrawler;
import com.example.parserwithweb.modules.VI.page_processing.PhotoCrawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.example.parserwithweb.modules.VI.methods.FormatResult.formatCardCharact;
import static com.example.parserwithweb.modules.VI.page_processing.Advantages.createAdvantages;
import static com.example.parserwithweb.modules.VI.page_processing.Characteristics.createCharacteristics;
import static com.example.parserwithweb.modules.VI.page_processing.Equipment.createComplectation;
import static com.example.parserwithweb.modules.VI.page_processing.Features.createFeatures;
import static com.example.parserwithweb.modules.VI.page_processing.Weight.createWeight;
import static com.example.parserwithweb.modules.VI.page_processing.GetPageVI.getPage;


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
    public static void BuildAnyDescriptions() throws IOException {
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

            productCards.add(formatCardCharact(oneProductCard));
            photoListBuilder.add(PhotoCrawler.getPhoto(document));
            instrListBuilder.add(ManualCrawler.getManual(document));
            }
        setPhotos(photoListBuilder);
        setInstr(instrListBuilder);
        setTtx(productCards) ;
    }

    public static String BuildDescriptionForOneCard(String search) throws IOException {

        Document document = Jsoup.parse(new URL(search), 45000);
        StringBuilder oneProductCard = new StringBuilder(createFeatures(document)
                .append(createCharacteristics(document))
                .append(createAdvantages(document))
                .append(createComplectation(document))
                .append(createWeight(document)));
       return formatCardCharact(oneProductCard);
    }
}
