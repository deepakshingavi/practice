import java.lang.reflect.Modifier;

public class AbstractClassId {

    public static void main(String[] args) {
        boolean b = Modifier.isAbstract( A.class.getModifiers() );
    }
}

abstract class ABC {

}
