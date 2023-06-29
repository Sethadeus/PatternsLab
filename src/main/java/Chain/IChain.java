package Chain;

import Interface.Vehicle;

public interface IChain {
    void write(Vehicle vehicleInterface);
    void setNext(IChain c);
}
