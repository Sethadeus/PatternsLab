package Visitor;

import Models.Auto;
import Models.Motorcycle;

public class PrintVisitor implements Visitor{

    @Override
    public void visit(Auto v) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(v.getMake()).append("\n");
        stringBuilder.append(v.getLength()).append("\n");

        for (int i = 0; i < v.getLength(); i++) {
            stringBuilder.append(v.getModels()[i]).append("\n");
            stringBuilder.append(v.getPrices()[i]).append("\n");
        }
        System.out.println(stringBuilder);
    }

    @Override
    public void visit(Motorcycle v) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(v.getMake()).append(" ");
        stringBuilder.append(v.getLength()).append(" ");

        for (int i = 0; i < v.getLength(); i++) {
            stringBuilder.append(v.getModels()[i]);
            stringBuilder.append(" - ");
            stringBuilder.append(v.getPrices()[i]).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
