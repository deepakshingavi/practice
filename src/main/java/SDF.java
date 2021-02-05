import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class SDF {

    public static void main(String[] args) {
        final TemporalAccessor parse = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSxxx")
                .parse("2020-06-13T16:21:15.239920+02:00");

        int dayOfMonth = MonthDay.from(parse).getDayOfMonth();
        System.out.println(dayOfMonth);
    }
}
