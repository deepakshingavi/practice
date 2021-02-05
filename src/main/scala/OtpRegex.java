import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OtpRegex {

    public static void main(String[] args) {
//        String regex = "((is|otp|password|key|code|CODE|KEY|OTP|PASSWORD|Do).[0-9]{4,8}.(is|otp|password|key|code|CODE|KEY|OTP|PASSWORD)?)|(^[0-9]{4,8}.(is|otp|password|key|code|CODE|KEY|OTP|PASSWORD))";
        String text = "To auth... \n\n869256\n\n Do is your login OTP. Treat this as confidential. Sharing it with anyone gives them full access to your Paytm Wallet. Paytm never calls to verify your OTP.";


        Scanner sc = new Scanner(text);

        int otp = -1;
        String line = null;
        while (sc.hasNextLine()) {
            line = sc.nextLine().trim();
            try{
                otp = Integer.parseInt(line);
                break;
            } catch (NumberFormatException nfx) {
                //Ignore the exception
            }
        }
        System.out.println(otp);
    }
}
