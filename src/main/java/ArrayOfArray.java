import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayOfArray {

    public static void main(String[] args) throws IOException {
        Object[] objArr = new Object[0];
        String jsonFilePath = "src/main/resources/arrayOfArray.json"; // JSON File Path
        Object[] mySystems = new ObjectMapper().readValue(new File(jsonFilePath), objArr.getClass());

        for (int i = 0 ; i < mySystems.length;i++) {
            ArrayList<Object> list = (ArrayList<Object>)mySystems[i];
            for (Object obj :list) {
                System.out.print(obj + " ");
            }
            System.out.println();
        }

    }
}



