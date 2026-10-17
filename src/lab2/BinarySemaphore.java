package lab2;

public class BinarySemaphore {
    private boolean semaphore = false;

    public synchronized void increment(){
        semaphore = true;
        notifyAll();
    }

    public synchronized void decrement(){
        while(!semaphore){
            try{
                wait();
            }
            catch (Exception e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        semaphore = false;
    }


}
