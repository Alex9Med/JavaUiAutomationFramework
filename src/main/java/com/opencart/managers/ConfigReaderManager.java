package com.opencart.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderManager {
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";
    private static Properties properties;

    private static void initProperties(){
        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    public static String getPropertyValue(String key){
        if (properties == null){
            initProperties();
        }
        return properties.getProperty(key);
    }
}
