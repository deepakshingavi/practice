import java.util.ArrayList;

public class OneTest {

    private ArrayList<String> list;

    public OneTest(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.add("Ben");
        array.add("Bob");

        OneTest test = new OneTest(array);

        ArrayList<String> array1 = new ArrayList<>();
        array1.add("111");
        array1.add("222");

        OneTest test1 = new OneTest(array1);

        ArrayList<String> testRecovery = test.getList();
        ArrayList<String> testRecovery1 = test1.getList();

        System.out.println(testRecovery.toString());
        System.out.println(testRecovery1.toString());
    }
}