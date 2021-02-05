import java.util.ArrayList;

public class Main3 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(4);
        list.add(0);
        list.add(0);
        list.add(9);
        System.out.println(list);
        zerosBack(list);
        System.out.println(list);
    }

    static ArrayList<Integer> zerosBack(ArrayList<Integer> arr) {
        int firstCounter = 0;
        int lastCounter = arr.size() - 1;
        while (lastCounter > firstCounter) {
            if (0 == arr.get(lastCounter)) {
                lastCounter--;
                continue;
            }
            if (0 != arr.get(firstCounter)) {
                firstCounter++;
                continue;
            }
            arr.set(firstCounter, arr.get(lastCounter));
            arr.set(lastCounter, 0);
        }
        return arr;
    }
}
