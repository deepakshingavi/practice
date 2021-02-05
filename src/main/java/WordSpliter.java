import scala.Tuple2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordSpliter {

    public static void main(String[] args) {
        Stream<String> lines= Stream.of("100-1","100-2","100-3",
                "120-1",
                "333-1","333-2");

        Stream<List<String>> map = lines.map((String str) ->
                new Tuple2<>(str.substring(0, str.indexOf("-")), str)
        ).collect(Collectors.groupingBy(Tuple2::_1, Collectors.mapping(Tuple2::_2, Collectors.toList())))
                .values().stream();

        map.forEach(System.out::println);


    }
}
