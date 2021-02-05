import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfList {

    public static void main(String[] args) {
        List<Integer> listToSplit = new ArrayList<>();
        listToSplit.add(1);
        listToSplit.add(1);
        listToSplit.add(1);
        listToSplit.add(1);
        listToSplit.add(1);
        listToSplit.add(1);
        listToSplit.add(1);
        double batchSize = 3;

        int loops = Math.max(1,(int) Math.ceil(listToSplit.size()/batchSize));
        final List<List<Integer>> collect = IntStream.iterate(-1, i -> (int) (i + batchSize)).limit(loops)
                .mapToObj(id -> {
                    int actualCounter  = id+1;
                    int finalLength = (int) Math.min(listToSplit.size(),actualCounter + batchSize);
                    return listToSplit.subList(actualCounter, finalLength);
                }).collect(Collectors.toList());
        System.out.println(collect);
    }
}
