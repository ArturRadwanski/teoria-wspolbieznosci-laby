package lab1;

public class Main {
    void counterTask(){
        Counter counter = new Counter();
        DecrementThread thread1 = new DecrementThread();
        IncrementThread thread2 = new IncrementThread();

        thread1.set_counter(counter);
        thread2.set_counter(counter);

        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);

        t1.start();
        t2.start();
    }

    void producentTask(){
        Buffer buffer = new Buffer();
        Consumer consumer1  = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);

        Producer producer1 = new Producer(buffer);
        Producer producer2 = new Producer(buffer);

        Thread thread1 = new Thread(producer1);
        Thread thread2 = new Thread(producer2);
        Thread thread3 = new Thread(consumer1);
        Thread thread4 = new Thread(consumer2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
    void main() {
        producentTask();
    }
}
