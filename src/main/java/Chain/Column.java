package Chain;

import Interface.Vehicle;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Column implements IChain {

    private IChain next;

    @Override
    public void write(Vehicle transport) {

        if (transport.getLength() > 3) {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(transport.getMake()).append("\n");
            stringBuilder.append(transport.getLength()).append("\n");

            for (int i = 0; i < transport.getLength(); i++) {
                stringBuilder.append(transport.getModels()[i]).append("\n");
                stringBuilder.append(transport.getPrices()[i]).append("\n");
            }

            try (PrintWriter pw = new PrintWriter(new FileWriter("src/main/resources/chain.txt"))) {

                pw.write(stringBuilder.toString());
                pw.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {

            if (next != null) {
                next.write(transport);
            }

        }

    }

    @Override
    public void setNext(IChain c) {
        this.next = c;
    }
}
