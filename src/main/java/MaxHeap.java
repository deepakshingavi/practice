import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Student1> pq = new PriorityQueue<Student1>(4, new Comparator<Student1>() {
            @Override
            public int compare(Student1 o1, Student1 o2) {
                return o2.compareTo(o1);
            }
        });


        pq.add(new Student1(35, "Shafaet", 3.7));
        pq.add(new Student1(42, "Ashley", 3.9));
        pq.add(new Student1(46, "Maria", 3.6));
        pq.add(new Student1(49, "Anik", 3.95));

    }

}

class Student1 implements Comparable<Student1> {
    int id;
    String name;
    double cgpa;

    public Student1(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "id= " + id + " name= " + name + " cgpa= " + cgpa;
    }

    @Override
    public int compareTo(Student1 second) {
        if (getCgpa() == second.getCgpa()) {
            if (getName().equals(second.getName())) {
                return Integer.compare(getId(), second.getId());
            } else {
                return getName().compareTo(second.getName());
            }
        } else {
            return Double.compare(getCgpa(), second.getCgpa());
        }
    }
}
