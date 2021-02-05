import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleStream {

    public static void main(String[] args) {
        /*List<String> description = new ArrayList<>();
        List<String> newLore = new ArrayList<>();
        description.stream().forEach( str -> {
            newLore.add(ChatColor.translateAlternateColorCodes('&', str));
        });
        itemMeta.setLore(newLore);*/

        Map<String, Map<SomeEnum, Long>> map = null;



        List<SomeClass> ss = map.entrySet().stream()
                .flatMap(e -> e.getValue().entrySet().stream().map(innerEntry -> {
                    long bar1 = 0;
                    long bar2 = 0;
                    long bar3 = 0;

                    if(innerEntry.getKey().equals(SomeEnum.BAR1)) bar1 = innerEntry.getValue();
                    if(innerEntry.getKey().equals(SomeEnum.BAR2)) bar2 = innerEntry.getValue();
                    if(innerEntry.getKey().equals(SomeEnum.BAR3)) bar3 = innerEntry.getValue();

                    return new SomeClass();
                })).collect(Collectors.toList());
    }
}

enum SomeEnum{
    BAR1,BAR2,BAR3;
}

class SomeClass {
    String name;
    long bar1Value;
    long bar2Value;
    long bar3Value;
}
