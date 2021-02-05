import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeParserr {

    public static void main(String[] args) throws ParseException {

        String dateString = "2020-06-05T13:54:24+03:00";
        String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
        DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
        DateTime dateTime = dtf.parseDateTime(dateString);
        System.out.println(dateTime); // 2010-03-01T04:00:00.000-04:00

    }

}
