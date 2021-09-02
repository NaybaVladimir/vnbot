package org.example.vnbot.workingWithFiles;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class FileRead {
    public FileRead() {
    }

    //Метод считывает значение из файла .properties, по переданному ключу
    public String propertiesRead(String key, String fileName) {
        InputStream in = getClass().getClassLoader().getResourceAsStream("properti/" + fileName);
        Properties properties = new Properties();
        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);

    }

    //Метод считывает txt-файл
    public String txtRead(String fileName) {
        Scanner sc;
        String text = "";
        try {
            sc = new Scanner(ResourceUtils.getFile("classpath:text/" + fileName));
            while (sc.hasNext())
                text += sc.nextLine() + "\n";
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return text;
    }
}
