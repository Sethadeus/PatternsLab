package DAO;

import Interface.Vehicle;

import java.io.*;

public class SerialDAO implements IDAO{

    private final String fileName;

    public SerialDAO(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(Vehicle t) {
        try (FileOutputStream fout = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fout)) {
            out.writeObject(t);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Vehicle read() {
        Vehicle t = null;
        try (FileInputStream fIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fIn)) {
            t = (Vehicle) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
    }

}
