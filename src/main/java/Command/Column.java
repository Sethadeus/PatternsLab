package Command;

import Interface.Vehicle;

import java.io.PrintWriter;

public class Column implements ICommand{

    @Override
    public void print(Vehicle v, PrintWriter pw) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(v.getMake()).append("\n");
        stringBuilder.append(v.getLength()).append("\n");

        for (int i = 0; i < v.getLength(); i++) {
            stringBuilder.append(v.getModels()[i]).append("\n");
            stringBuilder.append(v.getPrices()[i]).append("\n");
        }

        pw.write(stringBuilder.toString());
        pw.flush();

    }

}
