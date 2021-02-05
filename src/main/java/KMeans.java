import scala.collection.JavaConversions;
import scala.collection.Seq;
import scala.collection.immutable.Set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class KMeans {
    public static void main(String[] args) {
        /*System.out.println("\n" + "----------" + "\n" + "Cluster K" + "\n" + "----------");
        System.out.println();
        Map<String,List<Float>> clusterMeanInfo = new HashMap<>();
        clusterMeanInfo.put("Cluster K",new ArrayList<>());
        clusterMeanInfo.put("Cluster M",new ArrayList<>());
        for (int i = 0; i < Datos.length; i++) {
            distanciaK = (float) Math.sqrt(Math.pow(Datos[i][0] - Datos[10][0], 2) + Math.pow(Datos[i][1] - Datos[10][1], 2) + Math.pow(Datos[i][2] - Datos[10][2], 2) + Math.pow(Datos[i][3] - Datos[10][3], 2) + Math.pow(Datos[i][4] - Datos[10][4], 2));
            System.out.println(distanciaK);
            clusterMeanInfo.get("Cluster K").add(distanciaK);

        }

        System.out.println("\n" + "----------" + "\n" + "Cluster M" + "\n" + "----------");
        System.out.println();
        for (int i = 0; i < Datos.length; i++) {
            distanciaM = (float) Math.sqrt(Math.pow(Datos[i][0] - Datos[12][0], 2) + Math.pow(Datos[i][1] - Datos[12][1], 2) + Math.pow(Datos[i][2] - Datos[12][2], 2) + Math.pow(Datos[i][3] - Datos[12][3], 2) + Math.pow(Datos[i][4] - Datos[12][4], 2));
            System.out.println(distanciaM);
            kMeans.add(distanciaM);
            clusterMeanInfo.get("Cluster K").add(distanciaM);
        }

        System.out.println(clusterMeanInfo);

        for (String key :clusterMeanInfo.keySet()) {
            System.out.print(key + ' ');
            clusterMeanInfo.get(key).forEach( value -> {
                System.out.print(value + ' ');
            });
            System.out.println();
        }*/



        Future<String> f = new FutureTask<String>(null);
    }
}
