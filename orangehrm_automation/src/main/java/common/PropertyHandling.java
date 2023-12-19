package common;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyHandling {

    Properties properties;

    public PropertyHandling(){

        String filePath = System.getProperty("user.dir")+"\\config.properties";
        System.out.println(filePath);
        try {
            FileInputStream inputStream = new FileInputStream(filePath);

            properties = new Properties();

            properties.load(inputStream);

        }catch (Exception ignored){

        }
    }

    /*public static void main(String[] args) {
        PropertyHandling propertyHandling = new PropertyHandling();
       String value = propertyHandling.properties.getProperty("browser");
        System.out.println(value);
    }*/

    public String getProperty(String key){

        return properties.getProperty(key);

    }





}
