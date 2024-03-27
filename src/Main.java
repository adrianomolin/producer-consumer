public class Main {
    public static void main(String[] args) {
        Shared sharedThread = new Shared();

        Consumer consumer = new Consumer(sharedThread);
        Consumer consumer2 = new Consumer(sharedThread);

        consumer.setTime(750);
        consumer2.setTime(1000);

        Producer producer = new Producer(sharedThread);
        producer.setTime(1000);

        Thread consumerThread = new Thread(consumer);
        Thread consumer2Thread = new Thread(consumer2);
        Thread producerThread = new Thread(producer);

        System.out.println(consumerThread);

        consumerThread.start();
        consumer2Thread.start();
        producerThread.start();
    }
}