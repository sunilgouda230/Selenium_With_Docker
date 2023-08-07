package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static String data = null;

    public static String readConfigProp(String key) {
        File file = new File(System.getProperty("user.dir")+"/config/config.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(fileInputStream);
            data =prop.getProperty(key);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
}
