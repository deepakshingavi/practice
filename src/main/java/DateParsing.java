import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateParsing {

    public static void main(String[] args) {
        System.out.println(convertDateStringFormat("01 May 2020","dd MMM yyyy", "yyyy-MM-dd'T'HH:mm:ss"));

    }

    static String convertDateStringFormat(String dateString, String originalDateFormat, String outputDateFormat){
        DateFormat inputFormat = new SimpleDateFormat(originalDateFormat, Locale.ENGLISH);
        Date input = null;
        try {
            input = inputFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat outputFormat = new SimpleDateFormat(outputDateFormat, Locale.ENGLISH);
        return outputFormat.format(input);
    }
}
