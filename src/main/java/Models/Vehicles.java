package Models;

import Factory.AutoFactory;
import Interface.TransportFactory;
import Interface.Vehicle;
import Decorator.Decorator;

public class Vehicles
{
    public static double getAveragePrice(Vehicle v) // среднее ар. значение цен моделей
    {
        double lth = v.getLength();
        double sum = 0;
        for (int i = 0; i < lth; i++)
        {
            sum+=v.getPrices()[i];
        }
        sum = sum / lth;
        return sum;
    }

    public static void printModelsAndPrices (Vehicle v)
    {
        int lth = v.getLength();
        for (int i = 0; i < lth; i++)
        {
            System.out.println(v.getModels()[i] + " - " + v.getPrices()[i]);
        }
    }

    public static void printModelNames (Vehicle v)
    {
        int lth = v.getLength();
        for (int i = 0; i < lth; i++)
        {
            System.out.println(v.getModels()[i]);
        }
    }

    public static void printModelPrices (Vehicle v)
    {
        int lth = v.getLength();
        for (int i = 0; i < lth; i++)
        {
            System.out.println(v.getPrices()[i]);
        }
    }

    /*public static void outputVehicles (Vehicle v, OutputStream out) throws IOException
    {
        DataOutputStream DOStream = new DataOutputStream(out);

        DOStream.writeInt(getType(v));

        byte[] bytes = v.getMake().getBytes();
        DOStream.writeInt(bytes.length);
        for (byte b : bytes)
        {
            DOStream.writeByte(b);
        }

        DOStream.writeInt(v.getLength());

        String[] strModelsArr = v.getModels();
        double[] strPricesArr = v.getPrices();

        for (int i = 0; i < v.getLength(); i++)
        {

            bytes = strModelsArr[i].getBytes();
            DOStream.writeInt(bytes.length);
            for (byte b : bytes)
            {
                DOStream.writeByte(b);
            }

            DOStream.writeDouble(strPricesArr[i]);
        }
    }

    public static Vehicle inputVehicle (InputStream in) throws IOException, DuplicateModelNameException
    {
        DataInputStream stream = new DataInputStream(in);

        int type = stream.readInt();

        int lth = stream.readInt();
        byte[] bytes = new byte[lth];
        for (int i = 0; i < lth; i++)
        {
            bytes[i] = stream.readByte();
        }
        String make = new String(bytes);
        int size = stream.readInt();

        Vehicle v = FactoryMethod(make, 0, type);

        for (int i = 0; i < size; i++)
        {
            lth = stream.readInt();
            bytes = new byte[lth];
            for (int j = 0; j < lth; j++)
            {
                bytes[j] = stream.readByte();
            }
            String model = new String(bytes);
            double price = stream.readDouble();

            v.addModel(model,price);
        }
        return v;
    }

    public static void writeVehicles (Vehicle v)
    {
        int type = getType(v);
        System.out.printf("%d%n", type);

        System.out.printf("%s%n%s%n", v.getMake(), v.getLength());

        String[] strModelsArr = v.getModels();
        double[] strPricesArr = v.getPrices();

        for (int i = 0; i < v.getLength(); i++)
        {
            System.out.printf("%s %f%n", strModelsArr[i], strPricesArr[i]);
        }
    }

    public static Vehicle readVehicles () throws IOException, DuplicateModelNameException
    {
        int m ;
        Vehicle v;
        Scanner sc = new Scanner(System.in);

        System.out.print("Type: 1-Auto 0-motorcycle: ");
        int type = sc.nextInt();

        System.out.print("Make: ");
        String make = sc.next();

        System.out.print("Size: ");
        int size = sc.nextInt();

        v = FactoryMethod(make, 0, type);

        for (int i = 0; i < size; i++)

        {
            System.out.print("ModelName:" );
            String name = sc.next();

            System.out.print("Price:");
            double price = sc.nextDouble();

            v.addModel(name, price);
        }
        return v;
    }

    public static Vehicle FactoryMethod (String make, int size, int type)
    {
        Vehicle v = null;
        switch (type)
        {
            case 1:
                v = new Auto(make, size);
                break;
            case 0:
                v = new Motorcycle(make, size);
                break;
        }
        return v;
    }

    public static int getType (Vehicle v)
    {
        if (v instanceof Auto)
        {return 1;}
        else
        if (v instanceof Motorcycle)
        {return 0;}
        else
        {return 4;}
    }

    public static Vehicle createVehicle (String make, int size, Vehicle vehicle)
    {
        try {
            Class<?> reflClass = vehicle.getClass();
            Class[] params = {String.class, Integer.TYPE};
            Vehicle obj = (Vehicle) reflClass.getConstructor(params).newInstance(make, size);
            return obj;
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e)
        {
            return null;
        }
    }

    public static double getAvePrice (Vehicle... vehicles)
    {
        double price = 0;
        int num = 0;
        for (Vehicle v : vehicles)
        {
            double [] arrpr = v.getPrices();
            for (int i = 0; i < arrpr.length;i++)
            {
                price += arrpr[i];
                num++;
            }
        }

        return (price / num);

    }*/

    private static TransportFactory factory = new AutoFactory();

    public static void setTransportFactory(TransportFactory factory) {
        Vehicles.factory = factory;
    }

    public static Vehicle createInstance(String name, int size) {
        return factory.createInstance(name, size);
    }

    public Vehicle synchronizedTransport (Vehicle vehInterface) {
        return new Decorator(vehInterface);
    }

}
