package TestNG;

import common.CommonFunction;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelHandling {

    WebDriver driver;

    public String getFileExtension(String filePath){

        return filePath.substring(filePath.indexOf("."));
    }

/*   */

    @DataProvider
    public Object[][] getExcelData() throws IOException {
        Workbook workbook;
        String filePath = "D:\\selenium\\data.xlsx";

        String extension = getFileExtension(filePath);
        System.out.println(extension);

        FileInputStream inputStream = new FileInputStream(filePath);

        if (extension.equals(".xlsx")){
            workbook = new XSSFWorkbook(inputStream);
        } else {
            workbook = new HSSFWorkbook(inputStream);
        }

        Sheet sheet = workbook.getSheet("Sheet1");

        int totalRows = sheet.getPhysicalNumberOfRows();

        int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] array = new Object[totalRows-1][totalColumns];



            for (int i = 1; i < totalRows; i++) {

                Row row = sheet.getRow(i);

                for (int j = 0; j < totalColumns; j++) {

                    Cell cell = row.getCell(j);
                    String value = null;
                    if (cell != null) {
                        value = cell.getStringCellValue();
                    }
                    array[i - 1][j] = value;
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            workbook.close();
            inputStream.close();


        return array;

    }

}
