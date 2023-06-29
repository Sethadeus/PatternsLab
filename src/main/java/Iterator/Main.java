package Iterator;

import Models.Auto;

import java.util.Iterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();

        ont test = rnd.n
        Auto auto = new Auto("Audi", 5);

        Iterator iterator = auto.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

}
