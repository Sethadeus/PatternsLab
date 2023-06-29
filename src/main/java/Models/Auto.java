package Models;

import Exceptions.DuplicateModelNameException;
import Exceptions.ModelPriceOutOfBoundsException;
import Exceptions.NoSuchModelNameException;
import Interface.Vehicle;
import Command.ICommand;
import Command.Row;
import Visitor.Visitor;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;


public class Auto implements Vehicle
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


    static class Model implements Serializable, Cloneable
    {
        private String modelName;
        private double modelPrice;

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

        public Model(String modelName,double modelPrice)
        {
            this.modelName = modelName;
            this.modelPrice = modelPrice;
        }

        @Override
        public String toString() {
            return modelName +  " - " + modelPrice + "\n";
        }
    }


    private int numberOfModel;
    private Model[] arrModel;



    @Override
    public void setModel(String modelName, String newModelName) throws DuplicateModelNameException, NoSuchModelNameException
    {
        boolean b = false;
        for (Model model : arrModel)
        {
            if (model.modelName.equals(newModelName)) throw new DuplicateModelNameException(newModelName);
        }
        for (Model model : arrModel)
        {
            if (model.modelName.equals(modelName))
            {
                b = true;
                model.modelName = newModelName;
                break;
            }
        }
        if (!b) throw new NoSuchModelNameException(modelName);
    }



    @Override
    public String[] getModels()
    {
        String[] arrName = new String[numberOfModel];

        for (int i=0; i < arrName.length; i++)
        {
            arrName[i]=arrModel[i].modelName;
        }
        return arrName;
    }



    @Override
    public double getPrice(String modelName) throws NoSuchModelNameException
    {
        boolean b = false;
        double price = 0;

        for (Model model : arrModel)
        {
            if (model.modelName.equals(modelName))
            {
                b = true;
                price =  model.modelPrice;
                break;
            }
        }
        if (!b) throw new NoSuchModelNameException(modelName);

        return price;
    }



    @Override
    public void setPrice(double newPrice, String modelName) throws NoSuchModelNameException
    {
        if (newPrice <= 0) throw new ModelPriceOutOfBoundsException(" цена должна быть больше 0");
        boolean b = false;

        for (Model model : arrModel)
        {
            if (model.modelName.equals(modelName))
            {
                b = true;
                model.modelPrice = newPrice;
                break;
            }
        }
        if (!b) throw new NoSuchModelNameException(modelName);
    }



    @Override
    public double[] getPrices()
    {
        double[] arrPrices = new double[numberOfModel];

        for (int i=0; i < arrPrices.length; i++)
        {
            arrPrices[i]=arrModel[i].modelPrice;
        }
        return arrPrices;
    }



    @Override
    public void addModel(String modelName, double modelPrice) throws DuplicateModelNameException
    {
        if (modelPrice <= 0) throw new ModelPriceOutOfBoundsException(" цена должна быть больше 0");

        for (Model model : arrModel)
        {
            if (model.modelName.equals(modelName)) throw new DuplicateModelNameException(modelName);
        }

        arrModel = Arrays.copyOf(arrModel, numberOfModel + 1);

        arrModel[numberOfModel] = new Model(modelName,modelPrice);

        numberOfModel++;

    }



    @Override
    public void delModel(String modelName) throws NoSuchModelNameException
    {
        boolean b = false;
        int num = -1;

        for (int i=0; i < numberOfModel; i++)
        {
            if (arrModel[i].modelName.equals(modelName))
            {
                b = true;
                num = i;
            }
        }
        if (num == -1) throw new NoSuchModelNameException(modelName);
        else
        {
            Model[] newArrModel = Arrays.copyOf(arrModel, numberOfModel - 1);

            System.arraycopy(arrModel, num + 1, newArrModel, num, numberOfModel - num - 1);

            arrModel = newArrModel;
            numberOfModel--;
        }
    }



    @Override
    public int getLength()
    {
        return numberOfModel;
    }



    public Auto(String make,int numberOfModel)
    {
        this.numberOfModel = numberOfModel;
        this.make = make;
        arrModel = new  Model[numberOfModel]; //
        for (int i=0; i < numberOfModel; i++)
        {
            arrModel[i]= new Model("name"+i, i+1);
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
        for (int i = 0; i < getLength(); i++)
        {
            sb.append("Название: ").append(arrModel[i].modelName).append(" ");
            sb.append("Цена: ").append(arrModel[i].modelPrice);
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
        int result = getMake() != null ? getMake().hashCode() : 0;

        result = 31 * result + (arrModel != null ? Arrays.hashCode(arrModel) : 0);

        return result;
    }


    @Override
    public Object clone()
    {
        Auto result = null;
        try
        {
            result = (Auto) super.clone();

            result.arrModel = new Model[numberOfModel];

            for (int i =0; i < numberOfModel;i++ )
            {
                Model clone = (Model) arrModel[i].clone();
                result.arrModel[i] = clone;
            }

            return result;

        } catch (CloneNotSupportedException e)
        {
            System.out.println(e);
            return null;
        }
    }

    private transient ICommand command = new Row();

    public void print(PrintWriter pw) {
        command.print(this, pw);
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }


    public Iterator iterator() {
        return new AutoIterator();
    }

    private class AutoIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < arrModel.length;
        }

        @Override
        public Object next() {
            return arrModel[index++];
        }
    }

    private byte[] getData() {
        return data;
    }

    private void setData(byte[] data) {
        this.data = data;
    }

    private byte[] data = null;

    public static class Memento {

        public void setAuto(Auto auto) {
            byte[] data = null;

            try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                 ObjectOutputStream oos = new ObjectOutputStream(bos)) {
                oos.writeObject(auto);
                data = bos.toByteArray();

            } catch (IOException ignored) {
            }

            auto.setData(data);

        }

        public Auto getAuto(Auto auto) {
            byte[] data = auto.getData();
            try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
                 ObjectInputStream ois = new ObjectInputStream(bis)) {
                return (Auto) ois.readObject();
            } catch (IOException | ClassNotFoundException ignored) {
            }
            return null;
        }
    }

    public void createMemento(Auto auto) {
        new Memento().setAuto(auto);
    }

    public Auto setMemento(Auto auto) {
         return new Memento().getAuto(auto);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
