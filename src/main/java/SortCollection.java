import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortCollection {
    public static void main(String[] args) {
        List<String> Seats = new ArrayList<String>();

        Random rand = new Random();

        //Creating Alphanumeric seat numbers e.g A1, A2, A3....B1,B2...etc using ASCII values
        for(int i =0;i<100;i++)
        {
            String seatNum = Character.toString((char) (rand.nextInt(35)+65)) + (rand.nextInt(14)+1);

            if(!Seats.contains(seatNum))

                Seats.add(seatNum);

        }

        //Create a filtered list of only seat numbers starting with G
        final Pattern p = Pattern.compile("G[^\\d.]");
        Comparator<String> c = (object1, object2) -> {
            Matcher m = p.matcher(object1);
            Integer number1 = null;
            if (!m.find()) {
                return object1.compareTo(object2);
            }
            else {
                Integer number2 = null;
                number1 = Integer.parseInt(m.group());
                m = p.matcher(object2);
                if (!m.find()) {
                    return object1.compareTo(object2);
                }
                else {
                    number2 = Integer.parseInt(m.group());
                    int comparison = number1.compareTo(number2);
                    if (comparison != 0) {
                        return comparison;
                    }
                    else {
                        return object1.compareTo(object2);
                    }
                }
            }
        };


        //Create a filtered list of only seat numbers starting with G

        List<String> gSeats = new ArrayList<>();


        Seats.forEach(seat->{

            if(seat.startsWith("G")   )
            {
                gSeats.add(seat);
            }
        });
        System.out.println("Original G list");
        gSeats.forEach((String g)-> System.out.println(g));

        gSeats.sort(c);

        System.out.println("\n\nSorted List\n");
        gSeats.forEach((String g)-> System.out.println(g));
    }
}
