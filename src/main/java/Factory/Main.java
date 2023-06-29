package Factory;


import Interface.TransportFactory;
import Interface.Vehicle;
import Models.Vehicles;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("-------------------Задание 1.2: Factory--------------------");

        TransportFactory motoFactory = new MotorcycleFactory();
        TransportFactory autoFactory = new AutoFactory();

        Vehicle auto = Vehicles.createInstance("Audi", 2);
        System.out.println(auto.getClass());

        Vehicles.setTransportFactory(motoFactory);

        Vehicle moto = Vehicles.createInstance("SUZUKI", 2);
        System.out.println(moto.getClass());

        Vehicles.setTransportFactory(autoFactory);
        Vehicle auto2 = Vehicles.createInstance("BMW", 2);
        System.out.println(auto2.getClass());
    }
}
