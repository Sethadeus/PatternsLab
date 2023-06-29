package Factory;

import Interface.TransportFactory;
import Interface.Vehicle;
import Models.Motorcycle;

public class MotorcycleFactory implements TransportFactory {
    @Override
    public Vehicle createInstance(String mark, int size) {
        return new Motorcycle(mark, size);
    }
}
