package Command;

import Interface.Vehicle;

import java.io.PrintWriter;

public class Row implements ICommand{

    @Override
    public void print(Vehicle v, PrintWriter pw) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(v.getMake()).append(" ");
        stringBuilder.append(v.getLength()).append(" ");

        for (int i = 0; i < v.getLength(); i++) {
            stringBuilder.append(v.getModels()[i]);
            stringBuilder.append(" - ");
            stringBuilder.append(v.getPrices()[i]).append(" ");
        }

        pw.write(stringBuilder.toString());
        pw.flush();
    }

}
