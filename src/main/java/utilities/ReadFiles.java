package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFiles {

    private ReadFiles(){}

    public static Properties readProperties(String filepath)  {

        Properties properties = new Properties();
        FileReader fileReader;
        try {
             fileReader = new FileReader(filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader reader = new BufferedReader(fileReader);

        try {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;

    }







}
