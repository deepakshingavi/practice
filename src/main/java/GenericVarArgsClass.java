import scala.Tuple22;
import scala.Tuple3;

abstract class GenericRunnable<T> {
    abstract public void callback(T result);
}

class MyRunnable3Param extends GenericRunnable<Tuple3<String,Integer,String>> { // Class with 3 Parameters

    @Override
    public void callback(Tuple3<String,Integer,String> tuple) {

    }
}
