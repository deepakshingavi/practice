
import shaded.parquet.org.codehaus.jackson.JsonGenerator;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Entry {
    /*public static void main(String[] args) {
        JsonGenerator jsonGenerator = new JsonGenerator();
        Jsons jsons = new Jsons();
        Socket socket = new Socket("localhost", 7777);
        System.out.println("connected!");
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        int i=0;
        for (;;){
            dataOutputStream.writeUTF(jsons.generate().toJSONString());
            i++;
            System.out.println(jsons.generate());
            System.out.println(jsons.generate().toJSONString());
            System.out.println(i);
        }
    }*/
}
