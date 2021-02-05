import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GsonParsing {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        GsonObj gsonObj = gson.fromJson(new FileReader("src/main/resources/sampleGson.json"),GsonObj.class);
        System.out.println(gsonObj);
    }

    /*void processObj(){
        JsonObject json = new JsonObject();
        json.addProperty("user_name", currentUserName);
        Product product = productEntry.getProduct();
        json.addProperty("product", GsonUtil.gson.toJson(product));
        json.addProperty("quantity", productEntry.getQuantity());
        logger.info("addProductToCart: json = " + json);
    }*/
}

//@Expose
class Product {
}

class GsonObj {
    List<InnerClass> Product;
}
class InnerClass {
    @SerializedName(value = "emailId")
    public String attr1;
    public Integer attr2;
}
