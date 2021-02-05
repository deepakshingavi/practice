

public class SingletonObj {

    private SingletonObj() {
    }

    private static class SingletonObjInitClass {
        public static SingletonObj singletonObj = new SingletonObj();
    }

    public static SingletonObj initSingletonObj() {
        return SingletonObjInitClass.singletonObj;
    }

}

/*class Main {
    public static void main(String[] args) {
    }
}*/

// Singleton object can be used as Connection object in Spark Executor code and
// can be shared across multiple thread in same JVM
// e.g. Conn object of Cassandra DB which needs to update multiple tables from executor
