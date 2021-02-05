import java.util.ArrayList;
import java.util.List;

public class ListChangedCheck {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        /*if (task.isSuccessful()) {
            int oldhashCode = list.hashCode();
            for (QueryDocumentSnapshot document : task.getResult()) {
                String Group_Names = document.getString("Title");
                System.out.println("Groups: Listen to these - " + document.getString("Title"));
                list.add(Group_Names);
            }
            int newhashCode = list.hashCode();
            if(oldhashCode == newhashCode) {  // hashcode is unique for very object in Java and fastest way to compare two object of same type
                System.out.println("List is unchanged");
            } else {
                System.out.println("List is\changed");
            }
        } else {
            System.out.println("Failed on: " + task.getException());
        }*/
    }
}
