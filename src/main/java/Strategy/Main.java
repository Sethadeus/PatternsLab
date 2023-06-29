package Strategy;

import java.io.*;

public class Main {
/*    static void serialInFile(String pth, int[] array) {
        try (FileOutputStream fout = new FileOutputStream(pth);
             ObjectOutputStream out = new ObjectOutputStream(fout)) {
            out.writeObject(array);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }*/

    static int[] deserialFromFile(String pth) {
        int[] array = null;
        try (FileInputStream fIn = new FileInputStream(pth);
             ObjectInputStream in = new ObjectInputStream(fIn)) {
            array = (int[]) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return array;
    }

    public static void main(String[] args) {
        /*int[] array = new int[]{8, 1, 5, 2, 3, 3, 5, 1, 9};
        serialInFile(args[0], array);*/

        int[] arrayFromFile = deserialFromFile(args[0]);

        IStrategy mpstrtg = new MapElementCount();
        mpstrtg.count(arrayFromFile);
        System.out.println("------------------------------------------");

        IStrategy recstrtg = new RecElementCount();
        recstrtg.count(arrayFromFile);
    }
}
