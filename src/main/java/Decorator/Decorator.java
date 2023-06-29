package Decorator;


import Exceptions.DuplicateModelNameException;
import Exceptions.NoSuchModelNameException;
import Interface.Vehicle;
import Visitor.Visitor;

public class Decorator implements Vehicle {

    private Vehicle vehicleInterface;

    public Decorator(Vehicle vehicleInterface) {
        this.vehicleInterface = vehicleInterface;
    }

    @Override
    public synchronized String getMake() {
        return vehicleInterface.getMake();
    }

    @Override
    public synchronized void setMake(String mark) {
        vehicleInterface.setMake(mark);
    }

    @Override
    public synchronized void setModel(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        vehicleInterface.setModel(oldName, newName);
    }

    @Override
    public synchronized String[] getModels() {
        return vehicleInterface.getModels();
    }

    @Override
    public synchronized double[] getPrices() {
        return vehicleInterface.getPrices();
    }

    @Override
    public synchronized int getLength() {
        return vehicleInterface.getLength();
    }

    @Override
    public void accept(Visitor visitor) {

    }

    @Override
    public synchronized double getPrice(String name) throws NoSuchModelNameException {
        return vehicleInterface.getPrice(name);
    }

    @Override
    public synchronized void setPrice(double price, String name) throws NoSuchModelNameException {
        vehicleInterface.setPrice(price, name);
    }

    @Override
    public synchronized void addModel(String name, double price) throws DuplicateModelNameException {
        vehicleInterface.addModel(name, price);
    }

    @Override
    public synchronized void delModel(String name) throws NoSuchModelNameException {
        vehicleInterface.delModel(name);
    }

}
