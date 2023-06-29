package Command;

import Interface.Vehicle;

import java.io.PrintWriter;

public interface ICommand {
    void print(Vehicle v, PrintWriter pw);
}
