package lab1;

public class DecrementThread implements Runnable{
    private Counter counter = null;

    public void set_counter(Counter counter){
        this.counter = counter;
    }

    public void run(){
        System.out.println("Runnable Decrement Running");
        for(int i=0;i<1e3;i++){
            counter.decrement();
        }
        counter.print_count();
    }
}
