package Singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Singleton {

    private static volatile Singleton instance;

    private final Properties prop = new Properties();

    private Singleton(){
        FileInputStream fis;
        try {
            fis = new FileInputStream("D:\\PattLab1\\src\\main\\resources\\config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getData(){
        return this.prop;
    }

    public static Singleton getInstance(){
        if (instance == null) {
            synchronized(Singleton.class){
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
