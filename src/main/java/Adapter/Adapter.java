package Adapter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Adapter {

    public OutputStream convert (String[] inpArr) throws IOException {

        OutputStream os = new ByteArrayOutputStream(inpArr.length);
        for (String s: inpArr) {
            byte[] tmp = s.getBytes(StandardCharsets.UTF_8);
            os.write(tmp);
        }
        return os;
    }

}
