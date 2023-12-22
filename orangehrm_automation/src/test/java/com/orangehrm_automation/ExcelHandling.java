package com.orangehrm_automation;

import com.orangehrm_automation.common.InsertData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHandling {




    public String getFileExtension(String filePath) {

        return filePath.substring(filePath.indexOf("."));
    }

    @Test(dataProvider = "getExcelData",dataProviderClass = InsertData.class)
    public void verifyLogin (String username, String password) {

        System.out.println(username + "  " + password);
    }


}
