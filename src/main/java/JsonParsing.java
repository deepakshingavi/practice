import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParsing {

    public static void main(String[] args) throws IOException {
        String jsonFilePath = "src/main/resources/source.json"; // JSON File Path
        MySystems mySystems = new ObjectMapper().readValue(new File(jsonFilePath),MySystems.class);


        Map<String,SystemParameter[]> outputMap = new HashMap<>();
        for (Map<String,List<SystemParameter>> map :mySystems.mySystems) {
            for (String key :map.keySet()) {
                outputMap.put(key, map.get(key).toArray(new SystemParameter[0]));
            }
        }
        System.out.println(outputMap);

    }
}

class MySystems {
    @JsonProperty("my-systems")
    List<Map<String,List<SystemParameter>>> mySystems;

    @JsonProperty("statistics")
    Statistics statistics;

}

class SystemParameter {
    @JsonProperty("parameter-name")
    String paramName;

    @JsonProperty("parameter-display-name")
    String paramDispName;

    @JsonProperty("optional")
    String optional;
}

class Statistics {

    @JsonProperty("Shots On Goal")
    Stats ShotsonGoal;

    @JsonProperty("Shots Off Goal")
    Stats ShotsoffGoal;
}
class Stats {

    int home;
    int away;

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getAway() {
        return away;
    }

    public void setAway(int away) {
        this.away = away;
    }
}
