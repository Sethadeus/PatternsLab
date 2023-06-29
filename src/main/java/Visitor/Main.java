package Visitor;

import Models.Auto;
import Models.Motorcycle;

public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto("Audi5", 3);
        Motorcycle moto = new Motorcycle("Suzuki", 5);

        Visitor visitor = new PrintVisitor();
        auto.accept(visitor);

        System.out.println("============================================");
        moto.accept(visitor);
    }
}
