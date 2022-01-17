package com.example.parserwithweb.modules.VI.config;
/*
this file can be added element of the massive to
 */

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.parserwithweb.modules.VI.config.StructureCardBuilder.*;

public class ApachePOIExcelWrite {

    private static final String FILE_NAME = "ParserFile.xlsx";

    public static void main(String[] args) throws IOException {
        final long startTime = System.currentTimeMillis();
        BuildDescriptions();
        //создание книги
        try (XSSFWorkbook workbook = new XSSFWorkbook()){
        XSSFSheet sheet = workbook.createSheet("ParserFile");
        //массивы для записи в эксель
        List<String> productCards = new ArrayList(getTtx());
        List<String> photoList = new ArrayList(getPhotos());
        List<String> instrList = new ArrayList(getInstr());

        int rowNum = 0;//счетчик строк
        int index = 0;

        for (String crm : productCards) {//цикл создания параметризированного списка

            Row row = sheet.createRow(rowNum++);

            Cell cell = row.createCell(0);//первый столбец, описание товаров
            Cell cellPhoto = row.createCell(1);//второй столбец, ссылки на фото
            Cell cellInstr = row.createCell(2);//третий столбец, ссылки на инструкции (если есть)

            cell.setCellValue(crm);
            cellInstr.setCellValue(instrList.get(index));
            cellPhoto.setCellValue(photoList.get(index).replace("68x60", "800x800"));
            System.out.println("Product card"+index+++" has been successfully created");
            }
        FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
        workbook.write(outputStream);
        }

        final long elapsedTimeMillis = System.currentTimeMillis() - startTime;
        System.out.printf("Сборка завершена за %.3f секунд", elapsedTimeMillis/1000f);
        }
}