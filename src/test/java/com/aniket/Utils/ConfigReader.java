package com.aniket.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;
    public static void loadConfig(String env){
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/Config/"+env+".properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String get(String key){
        if(prop==null){
            loadConfig("config");
        }
        return prop.getProperty(key);
    }
}
