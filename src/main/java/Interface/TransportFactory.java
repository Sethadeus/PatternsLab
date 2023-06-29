package Interface;

import Exceptions.DuplicateModelNameException;

public interface TransportFactory {

    Vehicle createInstance(String make,int numberOfMode);

}
