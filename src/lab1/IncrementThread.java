package lab1;

public class IncrementThread implements Runnable{
    private Counter counter = null;

    public void set_counter(Counter counter){
        this.counter = counter;
    }

    public void run(){
        System.out.println("Runnable Increment Running");
        for(int i=0;i<1e3;i++){
            counter.increment();
        }
        counter.print_count();
    }
}