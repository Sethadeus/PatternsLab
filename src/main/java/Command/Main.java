package Command;

import Models.Auto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        Auto auto = new Auto("Test", 5);

        ICommand command = new Column();
        auto.setCommand(command);

        auto.print(new PrintWriter(new FileWriter("src/main/resources/command.txt")));

    }

}
