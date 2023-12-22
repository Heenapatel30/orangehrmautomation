package com.orangehrm_automation;

import com.orangehrm_automation.common.InsertData;
import org.testng.annotations.Test;

public class ExcelHandlingTest {




    public String getFileExtension(String filePath) {

        return filePath.substring(filePath.indexOf("."));
    }

    @Test(dataProvider = "getExcelData",dataProviderClass = InsertData.class)
    public void verifyLogin (String username, String password) {

        System.out.println(username + "  " + password);
    }


}
