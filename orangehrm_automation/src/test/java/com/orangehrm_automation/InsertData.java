package com.orangehrm_automation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class InsertData {
    Workbook workbook;
    public String getFileExtension(String filePath){

        return filePath.substring(filePath.indexOf("."));
    }

    public void insertExcelData(int totalRows, int totalColumns) throws IOException {
        String filePath = "D:\\selenium\\NewTestData.xlsx";

        FileOutputStream outputStream = new FileOutputStream(filePath);

        String fileExtension = getFileExtension(filePath);
        //System.out.println(fileExtension);

        if (fileExtension.equals(".xlsx")){
            workbook = new XSSFWorkbook();
        } else {
            workbook = new HSSFWorkbook();
        }

        Sheet sheet = workbook.createSheet("TestData");

        for (int i = 0; i <totalRows ; i++) {
            Row  row = sheet.createRow(i);

            for (int j = 0; j <totalColumns; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue("Data" + j);
            }

        }

        workbook.write(outputStream);

        workbook.close();

        outputStream.flush();

        outputStream.close();
    }
    public  Object[][] getExcelData() throws IOException {
        String filePath = "D:\\selenium\\Data.xlsx";

        String extension = getFileExtension(filePath);
        System.out.println(extension);

        FileInputStream inputStream = new FileInputStream(filePath);

        if (extension.equals(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else {
            workbook = new HSSFWorkbook(inputStream);
        }

        Sheet sheet = workbook.getSheet("Sheet1");

        int totalRows = sheet.getPhysicalNumberOfRows();


        int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] array = new Object[totalRows-1][totalColumns];


        for (int i = 1; i<totalRows; i++) {

            Row row = sheet.getRow(i);

            for (int j = 0; j<totalColumns; j++) {

                Cell cell = row.getCell(j);
                String value = null;
                if (cell != null) {
                    value = cell.getStringCellValue();
                }
                array[i-1][j] = value;
                //System.out.print(value + " ");
            }
            // System.out.println();
        }
        workbook.close();
        inputStream.close();


        return array;

    }

    @Test
    public void excelVerify() throws IOException {

        Object[][] excelData = getExcelData();

       // insertExcelData(5,5);

        insertExcelData(excelData);
    }

    public void insertExcelData(Object[][] excelData) throws IOException {
        String filePath = "D:\\selenium\\NewTestData.xlsx";

        FileOutputStream outputStream = new FileOutputStream(filePath);

        String fileExtension = getFileExtension(filePath);
        //System.out.println(fileExtension);

        if (fileExtension.equals(".xlsx")){
            workbook = new XSSFWorkbook();
        } else {
            workbook = new HSSFWorkbook();
        }

        Sheet sheet = workbook.createSheet("TestData");

        for (int i = 0; i < excelData.length ; i++) {
            Row  row = sheet.createRow(i);

            for (int j = 0; j < excelData[0].length; j++) {
                Cell cell = row.createCell(j);
                if (excelData[i][j]!=null) {
                    cell.setCellValue(excelData[i][j].toString());
                }else {
                    cell.setCellValue("");
                }
            }

        }

        workbook.write(outputStream);

        workbook.close();

        outputStream.flush();

        outputStream.close();



    }

    public void insertDataInExcel(Object[][] data) throws IOException {
        String filePath = "D:\\selenium\\NewTestData.xlsx";

        FileOutputStream outputStream = new FileOutputStream(filePath);

        String fileExtension = getFileExtension(filePath);
        //System.out.println(fileExtension);

        if (fileExtension.equals(".xlsx")){
            workbook = new XSSFWorkbook();
        } else {
            workbook = new HSSFWorkbook();
        }

        Sheet sheet = workbook.createSheet("TestData");

        for (int i = 0; i < data.length ; i++) {
            Row  row = sheet.createRow(i);

            for (int j = 0; j <1; j++) {
                Object empObj = data[i][j];

                List<String> empData = (List<String>)empObj;

                for (int k = 0; k <empData.size() ; k++) {
                    Cell cell = row.createCell(k);

                    String value = empData.get(k);

                    if (value != null){
                        cell.setCellValue(value);
                    }else {
                        cell.setCellValue("");
                    }
                }

            }
        }

        workbook.write(outputStream);

        workbook.close();

        outputStream.flush();

        outputStream.close();

    }

    public void insertBusData(Object[][] data) throws IOException {
        String filePath = "D:\\selenium\\RedBusData.xlsx";

        FileOutputStream outputStream = new FileOutputStream(filePath);

        String fileExtension = getFileExtension(filePath);
        //System.out.println(fileExtension);

        if (fileExtension.equals(".xlsx")){
            workbook = new XSSFWorkbook();
        } else {
            workbook = new HSSFWorkbook();
        }

        Sheet sheet = workbook.createSheet("TestData");

        for (int i = 0; i < data.length ; i++) {
            Row  row = sheet.createRow(i);

            for (int j = 0; j <1; j++) {
                Object empObj = data[i][j];

                List<String> empData = (List<String>)empObj;

                for (int k = 0; k <empData.size() ; k++) {
                    Cell cell = row.createCell(k);

                    String value = empData.get(k);

                    if (value != null){
                        cell.setCellValue(value);
                    }else {
                        cell.setCellValue("");
                    }
                }

            }
        }

        workbook.write(outputStream);

        workbook.close();

        outputStream.flush();

        outputStream.close();


    }

}
