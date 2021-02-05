import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Value
@AllArgsConstructor
@Getter
class ImmutableBean {

    @Singular
    private final List<String> props;

    @Singular("bean1")
    private final ImmutableBean1 bean1;



    public static void main(String[] args) {
        List<String> props = new ArrayList<>();
        props.add("abc");
        ImmutableBean1 bean1 = new ImmutableBean1(10);
        ImmutableBean immutableBean = new ImmutableBean(props,bean1);
        System.out.println(immutableBean.getProps()); // abc
        props.add("pqr");
        System.out.println(immutableBean.getProps()); // abc pqr
    }
}

@Getter
@Setter
@AllArgsConstructor
class ImmutableBean1{

    @Singular
    int num;

}

