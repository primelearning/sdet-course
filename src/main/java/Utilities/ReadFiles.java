package Utilities;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import  java.util.Properties;

public final class ReadFiles {
    private ReadFiles(){

    }

    public static Properties readProperties(String filepath){
        Properties prop =new Properties();
        FileReader reader;
        try {
            reader = new FileReader(filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader=new BufferedReader(reader);
        try {
            prop.load(bufferedReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }






}
