import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.Date;

public class LocalDateTime1 {

    public static void main(String[] args) {

    }

    LocalDateTime getLocalDateTime(Date date){
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
