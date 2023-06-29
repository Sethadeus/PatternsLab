package Prototype;

import Exceptions.NoSuchModelNameException;
import Models.Auto;
import Models.Motorcycle;
import Models.Vehicles;

public class Main {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) throws NoSuchModelNameException {

        System.out.println("-------------------Задание 1.3: Prototype--------------------" + ANSI_RED);

        Auto auto = new Auto("Audi", 5);

        System.out.println("----------Оригинал:----------");
        Vehicles.printModelsAndPrices(auto);

        Auto autoClone = (Auto) auto.clone();

        autoClone.setPrice( 9999, "name0");

        System.out.println("------------Клон:------------");
        Vehicles.printModelsAndPrices(autoClone);
        System.out.println("----------Оригинал:----------");
        Vehicles.printModelsAndPrices(auto);


        System.out.println(ANSI_BLUE);


        Motorcycle moto = new Motorcycle("Suzuki", 5);

        System.out.println("----------Оригинал:----------");
        Vehicles.printModelsAndPrices(moto);

        Motorcycle motoClone = (Motorcycle) moto.clone();

        motoClone.setPrice( 9999, "name0");

        System.out.println("------------Клон:------------");
        Vehicles.printModelsAndPrices(motoClone);
        System.out.println("----------Оригинал:----------");
        Vehicles.printModelsAndPrices(moto);

    }
}
