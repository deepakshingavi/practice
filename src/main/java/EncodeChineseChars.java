import java.nio.charset.Charset;

public class EncodeChineseChars {

    public static void main(String[] args) {
        //gb2312
        String encoding = "UTF-8";
        String cp = "U+2E93".substring(2);
        int cpVal=Integer.parseInt(cp,16);
        String tempString = Character.toString((char)cpVal);
        byte[] bytes = tempString.getBytes(Charset.forName(encoding));
        String result = new String(bytes);
    }

}
