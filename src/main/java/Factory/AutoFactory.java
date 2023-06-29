package Factory;

import Interface.TransportFactory;
import Interface.Vehicle;
import Models.Auto;

public class AutoFactory implements TransportFactory {
    @Override
    public Vehicle createInstance(String mark, int size) {
        return new Auto(mark, size);
    }
}
