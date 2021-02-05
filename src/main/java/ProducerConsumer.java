import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
    public static void main(String[] args) {

        Processor processor = new Processor();

        Thread producer = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            public void run() {

                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("\t\t\tStarting both producer and consumer Threads.");
        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\t\t\tEnding all the Threads.");
    }
}


 class Processor {
    private List<Integer> list = new ArrayList<>();
    private int value = 0;
    private final int LIMIT = 5;

    public void produce() throws InterruptedException
    {
        synchronized(Processor.class){
            while(true)
            {
                if(list.size() == LIMIT){
                    System.out.println("Waiting for consumer to consume resources");
                    Processor.class.wait();
                }
                else{
                    value++;
                    System.out.println("The produced resource is : "+value);
                    list.add(value);
                    Processor.class.notify();
                }
            }
        }
    }

    public  void consume() throws InterruptedException
    {
        synchronized(Processor.class){
            while(true)
            {
                if(list.isEmpty()){
                    System.out.println("Waiting for producer to produce the resources");
                    Processor.class.wait();
                }
                else{
                    System.out.println("The consumer Consumed Resource is : "+list.remove(0));
                    Processor.class.notifyAll();
                }
            }
        }
    }
}