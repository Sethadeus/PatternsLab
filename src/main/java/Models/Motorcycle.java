package Models;

import Exceptions.DuplicateModelNameException;
import Exceptions.ModelPriceOutOfBoundsException;
import Exceptions.NoSuchModelNameException;
import Interface.Vehicle;
import Visitor.Visitor;

import java.io.Serializable;
import java.util.Arrays;

public class Motorcycle implements Vehicle
{
    private String make;

    @Override
    public String getMake()
    {
        return make;
    }

    @Override
    public void setMake(String newMake)
    {
        make = newMake;
    }

    private class Model implements Serializable, Cloneable
    {
        String modelName = null;
        double price = Double.NaN;
        Model prev = null;
        Model next = null;

        public Object clone()
        {
            try
            {
                Model clone = (Model) super.clone();
                return clone;

            } catch ( CloneNotSupportedException e)
            {
                System.out.println(e);
                return null;
            }
        }

    }
    private Model head = new Model();
    {
        head.prev = head;
        head.next = head;
    }
    private int size = 0;


    @Override
    public void setModel(String modelName, String newModelName) throws DuplicateModelNameException, NoSuchModelNameException
    {
        Model n = head.next;

        while (n!=head)
        {
            if (n.modelName.equals(newModelName)) throw new DuplicateModelNameException(newModelName);
            n = n.next;
        }

        n = head.next;
        while ((n!=head)&&(!n.modelName.equals(modelName)))
        {
            n = n.next;
        }
        if (n == head)
        {
            throw new NoSuchModelNameException(modelName);
        }
        else
        {n.modelName = newModelName;}
    }


    @Override
    public String[] getModels()
    {
        String[] arrName = new String[size];

        Model n = head.next;

        int i = 0;

        while (n!=head)
        {
            arrName[i] = n.modelName;
            i++;
            n = n.next;
        }
        return arrName;
    }


    @Override
    public double getPrice(String modelName) throws NoSuchModelNameException
    {
        double price = 0;

        Model n = head.next;

        while ((n!=head)&&(!n.modelName.equals(modelName)))
        {
            n = n.next;
        }
        if (n==head)
        {
            throw new NoSuchModelNameException(modelName);

        }
        else {price = n.price;}

        return price;
    }


    @Override
    public void setPrice(double newPrice, String modelName) throws NoSuchModelNameException
    {
        if (newPrice <= 0) throw new ModelPriceOutOfBoundsException(" цена должна быть больше 0");

        Model n = head.next;

        while ((n!=head)&&(!n.modelName.equals(modelName)))
        {
            n = n.next;
        }
        if (n==head)
        {
            throw new NoSuchModelNameException(modelName);
        }
        else  {n.price = newPrice;}
    }


    @Override
    public double[] getPrices()
    {
        double[] arrPrice = new double[size];

        Model n = head.next;

        int i = 0;

        while (n!=head)
        {
            arrPrice[i] = n.price;
            i++;
            n = n.next;
        }
        return arrPrice;
    }


    @Override
    public void addModel(String modelName, double modelPrice) throws DuplicateModelNameException
    {
        if (modelPrice <= 0) throw new ModelPriceOutOfBoundsException(" цена должна быть больше 0");

        Model n = head.next;
        while (n!=head)
        {
            if (n.modelName.equals(modelName)) throw new DuplicateModelNameException(modelName);
            n = n.next;
        }

        size++;
        Model newModel = new Model();
        newModel.price = modelPrice;
        newModel.modelName = modelName;

        newModel.next = head;
        newModel.prev = head.prev;
        head.prev.next = newModel;
        head.prev = newModel;
    }


    @Override
    public void delModel(String modelName) throws NoSuchModelNameException
    {
        Model n = head.next;

        while ((n!=head)&&(!n.modelName.equals(modelName)))
        {
            n = n.next;
        }
        if (n.modelName.equals(modelName))
        {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.prev = null;
            n.next = null;
            size--;
        }
        else throw new NoSuchModelNameException(modelName);
    }


    @Override
    public int getLength()
    {
        return size;
    }


    public Motorcycle(String make,int size)
    {
        this.make = make;

        for (int i=0; i < size; i++) {
            try {
                addModel("name" + i, i + 1);
            }
            catch(DuplicateModelNameException e)
            {

            }
        }
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("Марка: ").append(make);
        sb.append("\n");
        sb.append("Кол-во: ").append(getLength());
        sb.append("\n");

        String[] strarr = getModels();
        double[] doublearr = getPrices();
        for (int i = 0; i < getLength(); i++)
        {
            sb.append("Название: ").append(strarr[i]).append(" ");
            sb.append("Цена: ").append(doublearr[i]);
            sb.append("\n");
        }
        return sb.toString();
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        else {
            if (obj == this)
            {
                return true;
            }
            else {
                if (obj instanceof Vehicle) {
                    String objstr = obj.toString();
                    String thisstr = this.toString();

                    if (objstr.equals(thisstr)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
    }


    @Override
    public int hashCode()
    {
        String[] strarr = getModels();
        double[] doublearr = getPrices();

        int result = getMake() != null ? getMake().hashCode() : 0;

        result = 31 * result + (strarr != null ? Arrays.hashCode(strarr) : 0);
        result = 31 * result + (doublearr != null ? Arrays.hashCode(doublearr) : 0);

        return result;
    }

    @Override
    public Object clone()
    {
        Motorcycle result = null;
        try
        {
            result = (Motorcycle) super.clone();
            result.head = new Model();
            result.head.prev = result.head;
            result.head.next = result.head;
            Model n = head.next;
            while (n != head)
            {
                Model clone = (Model) n.clone();
                clone.next = result.head;
                clone.prev = result.head.prev;
                result.head.prev.next = clone;
                result.head.prev = clone;
                n = n.next;
            }
            return result;

        } catch (CloneNotSupportedException  e)
        {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
