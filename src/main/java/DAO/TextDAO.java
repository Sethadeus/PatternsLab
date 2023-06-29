package DAO;

import Exceptions.DuplicateModelNameException;
import Interface.Vehicle;
import Models.Vehicles;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextDAO implements IDAO {

    private final String fileName;

    public TextDAO(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(Vehicle t) {
        try (FileWriter fw = new FileWriter(fileName);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.printf("%s\n", t.getMake());
            int modelsCount = t.getLength();
            pw.printf("%d\n", modelsCount);

            String[] names = t.getModels();
            double[] prices = t.getPrices();
            String str;
            for (int i = 0; i < modelsCount; i++) {
                str = Double.toString(prices[i]);
                pw.printf("%s\n%s\n", names[i], str);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Vehicle read() {
        Vehicle t = null;
        try (FileReader fR = new FileReader(fileName);
             Scanner scan = new Scanner(fR)) {

            String mark = scan.nextLine();
            int modelsCount = Integer.parseInt(scan.nextLine());
            t = Vehicles.createInstance(mark, 0);

            String name;
            double price;
            for (int i = 0; i < modelsCount; i++) {
                name = scan.nextLine();
                price = Double.parseDouble(scan.nextLine());
                t.addModel(name, price);
            }
        } catch (IOException | DuplicateModelNameException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
    }

}
