package Singleton;

import java.util.Properties;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("-------------------Задание 1.1: Singleton--------------------");
        Singleton sin = Singleton.getInstance();
        Properties prop = sin.getData();
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));
    }
}
