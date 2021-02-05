import java.util.HashMap;

interface A {
    public static int varA = 23;
}

class B implements A {
    /*{
        varA = 96;
    }

    public B() {
        varA = 96;
    }

    public void methodB() {
        varA = 93;
    }*/
}

class C implements A {

}

class AMain {
    public static void main(String[] args) {
//        B b = new B();
//        b.methodB();
//        System.out.println(b.varA);


        final HashMap<B, ? super A> aHashMap = new HashMap<>();
        aHashMap.put(new B(),new B());
        aHashMap.put(new B(),new C());
    }

}