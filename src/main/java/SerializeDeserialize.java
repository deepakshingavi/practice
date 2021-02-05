import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.*;

public class SerializeDeserialize {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/BeanDumb.ser"));
        out.writeObject(new BeanDumb("fielValue"));
        out.close();*/

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/BeanDumb.ser"));
        BeanDumb bean = (BeanDumb) in.readObject();
        System.out.println(bean);
    }
}


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class BeanDumb implements Serializable {
    private String field;
    private static final long serialVersionUID = -43435372485381992L;



    private void readObject(ObjectInputStream input)
            throws IOException, ClassNotFoundException {
        // deserialize the non-transient data members first;
        input.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream output)
            throws IOException, ClassNotFoundException {
        // serialize the non-transient data members first;
        output.defaultWriteObject();
    }
}