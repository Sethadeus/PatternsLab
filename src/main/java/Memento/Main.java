package Memento;

import Exceptions.DuplicateModelNameException;
import Exceptions.NoSuchModelNameException;
import Models.Auto;
import Models.Vehicles;

public class Main {

    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException {

        Auto auto = new Auto("Test", 5);
        Vehicles.printModelsAndPrices(auto);
        auto.createMemento(auto);


        System.out.println("==========================");
        auto.setModel("name1","name666");
        Vehicles.printModelsAndPrices(auto);


        System.out.println("==========================");
        auto = auto.setMemento(auto);
        Vehicles.printModelsAndPrices(auto);

    }


}
