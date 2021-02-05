import org.apache.spark.api.java.JavaRDD;

import java.util.ArrayList;
import java.util.List;


class CloneExample {

    public static void main(String[] args) throws CloneNotSupportedException {
        List<JavaBean> list = new ArrayList<>();
        int i = 1;
        JavaBean localBean =  ((JavaBean) list.get(i).clone()); // Clone the object
        localBean.setValue("somvALUE"); // Change that object and the input list is not tampered
    }
}

class JavaBean implements Cloneable {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    protected Object clone() {
        JavaBean clone;
        try {
            clone = (JavaBean) super.clone();

            //Copy new date object to cloned method
            clone.setValue(this.getValue());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clone;
    }
}
