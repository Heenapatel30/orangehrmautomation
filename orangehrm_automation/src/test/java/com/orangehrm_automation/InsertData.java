package com.orangehrm_automation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class InsertData {
    Workbook workbook;
    public String getFileExtension(String filePath){

        return filePath.substring(filePath.indexOf("."));
    }

    public void insertExcelData() throws IOException {
        String filePath = "D:\\selenium\\NewTestData.xlsx";

        FileOutputStream outputStream = new FileOutputStream(filePath);

        String fileExtension = getFileExtension(filePath);
        System.out.println(fileExtension);

        if (fileExtension.equals(".xlsx")){
            workbook = new XSSFWorkbook();
        } else {
            workbook = new HSSFWorkbook();
        }

        Sheet sheet = workbook.createSheet("TestData");

        Row  row = sheet.createRow(0);

        Cell cell = row.createCell(0);

        cell.setCellValue("Sample Data");

        workbook.write(outputStream);

        workbook.close();

        outputStream.flush();

        outputStream.close();
    }

    @Test
    public void excelVerify() throws IOException {
        insertExcelData();
    }

}
