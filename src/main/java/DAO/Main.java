package DAO;

import Factory.MotorcycleFactory;
import Interface.Vehicle;
import Models.Vehicles;

public class Main {

    static void testSerializationDao() {
        String filename = "src/main/resources/serialfile";
        SerialDAO serialDao = new SerialDAO(filename);

        Vehicle t1 = Vehicles.createInstance("Lamborghini", 2);
        System.out.println(t1);
        serialDao.write(t1);

        Vehicle t2 = serialDao.read();
        System.out.println(t2);
    }

    static void testTextDao() {
        String filename = "src/main/resources/textfile";
        TextDAO textDao = new TextDAO(filename);

        Vehicles.setTransportFactory(new MotorcycleFactory());

        Vehicle t1 = Vehicles.createInstance("Suzuki", 3);
        System.out.println(t1);
        textDao.write(t1);

        Vehicle t2 = textDao.read();
        System.out.println(t2);
    }

    public static void main(String[] args)
    {
        System.out.println("=======================");
        testSerializationDao();
        System.out.println("=======================");
        testTextDao();
        System.out.println("=======================");
    }


}
