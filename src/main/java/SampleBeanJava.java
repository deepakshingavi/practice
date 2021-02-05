import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SampleBeanJava implements Serializable {
    private String field2;
    private String field1;

    /*public SampleBeanJava(String field2,String field1) {
        this.field2 = field2;
        this.field1 = field1;
    }
    public SampleBeanJava(){

    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    *//*@Override
    public String toString() {
        return "SampleBeanJava{" +
                "field2='" + field2 + '\'' +
                ", field1='" + field1 + '\'' +
                '}';
    }*/
}
