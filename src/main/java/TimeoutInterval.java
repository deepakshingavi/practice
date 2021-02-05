import java.util.Scanner;
import java.util.concurrent.*;

public class TimeoutInterval {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor(); // Start Single thread executor
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Future future = executor.submit(new Primes(n)); // Find prime no.
        try {
            future.get(5, TimeUnit.SECONDS); // Set the time out of the prime no. search task
            executor.shutdown();
        } catch (TimeoutException e) {
            executor.shutdown();
            System.out.println("Terminated!");
        }

        executor.shutdownNow();


    }
}

class Primes  implements Runnable {
    private final int number;

    Primes(int number) {
        this.number = number;
    }
    @Override
    public void run() {
        System.out.println("Started..");
        printPrimesAndOperationTime(number);
        System.out.println("Finished!");
    }

    private static boolean checkIfPrime(int x) {
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(x) + 1;
        for (int i = 3; i < sqrt; i = i + 2) if (x % i == 0) return false;
        return true;
    }

    private static void printPrimesAndOperationTime(int n) {
        long start = System.nanoTime();
        for (int i = 2; i <= n && !Thread.interrupted(); i++) if (checkIfPrime(i)) {
            System.out.println(i);
        }
        long end = System.nanoTime();

        long timeResult = end - start;
        System.out.println("Printing time = " + timeResult + " [ns] => "
                + Math.round(timeResult * 100.0 / 1000000) / 100.0 + " [ms]");
    }

}
