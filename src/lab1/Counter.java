package lab1;

public class Counter {
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public synchronized void decrement(){
        count--;
    }

    public void print_count(){
        System.out.println(count);
    }
}