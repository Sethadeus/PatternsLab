package Chain;

import Interface.Vehicle;
import Models.Auto;

public class Main {

    public static void main(String[] args) {

        IChain chain = new Row();
        IChain columnChain = new Column();
        chain.setNext(columnChain);

        Vehicle v = new Auto("Audi", 5);
        chain.write(v);

    }

}
