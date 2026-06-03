package configReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    static Properties prop;


    public static void readTheFile(String filePathToRead) {

        if (prop!=null) return;

        try {
            prop = new Properties();
            FileInputStream file = new FileInputStream(filePathToRead);
            prop.load(file);

        } catch (IOException e) {
           throw new IllegalArgumentException("file not found");

        }


    }


    public static String getTheProperty(String propertyToRead) {
       return  prop.getProperty(propertyToRead);


    }
}
