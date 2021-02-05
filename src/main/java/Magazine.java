import java.nio.file.Path;

public class Magazine extends AdMedia {
    private int area;
    private String position;
    private String topic;

    public Magazine() {
        super(100);

    }

    public Magazine(String name, int price, String position, String topic) {

        super(price);
        this.position = position;
        this.topic = topic;

    }
}

 class AdMedia {
    private String name;
    private final int price;

    public AdMedia(int price) {
        this.price = price;
    }

    public AdMedia(String name, int price) {
        this.name = name;
        this.price = price;
    }

     public void setName(String name) {
         this.name = name;
     }

     public int getPrice() {
         return price;
     }

     public String getName() {
         return name;
     }
 }
