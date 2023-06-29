package Interface;

import Exceptions.DuplicateModelNameException;
import Exceptions.NoSuchModelNameException;
import Visitor.Visitor;

import java.io.Serializable;

public interface Vehicle extends Serializable, Cloneable
{
    String getMake(); // метод для получения марки

    void setMake(String newMake); // метод для модификации марки

    void setModel(String modelName, String newModelName)throws DuplicateModelNameException, NoSuchModelNameException; // метод для замены названия модели

    String[] getModels(); // метод, возвращающий массив названий всех моделей

    double getPrice(String modelName) throws NoSuchModelNameException; // метод для получения значения цены модели по её названию

    void setPrice(double newPrice, String modelName) throws NoSuchModelNameException; // метод для модификации значения цены модели по её названию

    double[] getPrices(); // метод, возвращающий массив значений цен моделей

    void addModel(String modelName, double modelPrice) throws DuplicateModelNameException; //метод добавления новой модели

    void delModel(String modelName) throws NoSuchModelNameException; // метод для удаления модели по названию

    int getLength(); // метод для получения длины массива моделей

    void accept(Visitor visitor);
}
