package Adapter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] tmpStr = new String[]{"In ", "vino ", "veritas "};
        Adapter adp = new Adapter();
        System.out.println(adp.convert(tmpStr));

    }
}
