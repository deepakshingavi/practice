import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;

public class AlphanumericSort {



    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        System.out.println(new java.net.URL("https://hostpath/").toString());

        Class<? extends Throwable> exceptionClass = (Class<? extends Throwable>) Class.forName("java.lang.Exception");
        //Getting this value from Config. Let us assume that config is good and I get only valid classname which extends Throwable
        registerExceptionInExternalLibrary(exceptionClass);
    }

    static void registerExceptionInExternalLibrary(Class<? extends Throwable> exceptionClass){

    }





}

