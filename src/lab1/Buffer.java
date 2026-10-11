package lab1;

public class Buffer {
    private boolean messageReady = false;
    private String message = null;

    public synchronized void put(String message) {
        while (messageReady){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                return;
            }
        }
        this.message = message;
        System.out.println(message + " produced");
        messageReady = true;
        notifyAll();
    }
    public synchronized String take() {
        while (!messageReady){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                return null;
            }
        }
        messageReady = false;
        System.out.println(message + " consumed");
        notifyAll();
        return message;
    }
}
