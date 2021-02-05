import java.util.ArrayList;
import java.util.List;

public class CustomStack<T> {

    private List<T> data = new ArrayList<>();

    public void push(T t) {
        data.add(t);
    }

    public T pop() {
        int lastElement =  data.size()-1;
        if(lastElement > -1){
            return data.remove(lastElement);
        }
        return null;
    }

    public static void main(String[] args) {
        final CustomStack<Integer> integerCustomStack = new CustomStack<>();
        integerCustomStack.push(1);
        integerCustomStack.push(2);
        integerCustomStack.push(3);
        integerCustomStack.push(4);
        System.out.println(integerCustomStack.pop());
        System.out.println(integerCustomStack.pop());
        System.out.println(integerCustomStack.pop());
        System.out.println(integerCustomStack.pop());
        System.out.println(integerCustomStack.pop());
    }
}
