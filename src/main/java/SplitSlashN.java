public class SplitSlashN {

    public static void main(String[] args) {
        String str = "deviceName (string:1) -> TEST\\nintValue (int:1) -> 123\ndoubleValue (double:1) -> 12.345\nacquisitionStamp (long:1) -> 1592468678231250944\nintArrayValue (int[]:10) -> [1,2,3,4,5,6,7,8,9,10]";

         String[] splits = null;

        if (str.contains("\\n")) {
            splits = str.split("\\\\n");
        } else {
            splits = str.split("\n");
        }

        for (String split :splits) {
            System.out.println(split);

        }
    }
}
