import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

public class Greg {

    public static void main(String[] args) {
    }

    static XMLGregorianCalendar getCalendar() {
        final GregorianCalendar calendar = new GregorianCalendar();
        final XMLGregorianCalendar dt;
        try {
            dt = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e) {
            throw new IllegalArgumentException(e);
        }
        return dt;
    }
}
