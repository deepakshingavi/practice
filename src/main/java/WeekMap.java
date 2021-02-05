public class WeekMap {

    public static void main(String[] args) {
        System.out.println(isWorkDay("SUNDAY",WeekDays.SUNDAY));
        System.out.println(isWorkDay("sunday",WeekDays.SUNDAY));
        System.out.println(isWorkDay("sunday",WeekDays.SATURDAY));
        System.out.println(isWorkDay("ABS",WeekDays.SATURDAY));
    }

    private static boolean isWorkDay(String day, WeekDays pgMasterTaskList) {
        WeekDays day1 = WeekDays.valueOf(day.toUpperCase()); // Fetch the mapped day for the string
        try{
            day1 = WeekDays.valueOf(day.toUpperCase());
        } catch (IllegalArgumentException iex) {
            iex.printStackTrace(); // this can be suppress
        }
        return day1 == pgMasterTaskList;
    }
}

enum WeekDays{ // Create enum for week day names
    SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY;
}
