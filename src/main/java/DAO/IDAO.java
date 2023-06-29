package DAO;

import Interface.Vehicle;

public interface IDAO {
    void write(Vehicle t);
    Vehicle read();
}