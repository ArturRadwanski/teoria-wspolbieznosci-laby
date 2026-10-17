package lab2;

public class Semaphore {
    private int counter = 0;

    public synchronized void increment(){
        counter++;
        notifyAll();
    }

    public synchronized void decrement(){
        while(counter==0){
            try {
                wait();
            }
            catch (Exception e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
                
            }
        }
        counter--;
    }
}
