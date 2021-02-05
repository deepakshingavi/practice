public class OverrideStaticClass {

    public static void main(String[] args) {
        new B();
    }

    public static class A {

        String f1 = "300";

        public A(){
            init();
        }

        protected void init(){
            System.out.println(f1);
        }
    }

    public static class B extends A {

        String f1 = "3";

        public B(){
            super();
            init();
        }

        protected void init(){
            System.out.println(f1);
        }
    }
}
