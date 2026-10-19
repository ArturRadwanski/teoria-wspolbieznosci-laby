package lab2;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Philosopher implements Runnable {
    Random r;
    BinarySemaphore leftFork;
    BinarySemaphore rightFork;
    boolean prio; //false = take left fork first, true = take right fork first
    boolean eating = false;

    public Philosopher(BinarySemaphore leftFork, BinarySemaphore rightFork, boolean prio) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        r = new Random();
        this.prio = prio;
    }

    public synchronized void eat(){
        while(eating){
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        eating = true;
        if(prio){
            leftFork.decrement();
            rightFork.decrement();
            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            leftFork.increment();
                            rightFork.increment();
                            eating = false;
                        }
                    },
                    r.nextInt(1000, 3000)  //philosopher eats between 1 and 3 seconds
            );
        }
        else {
            rightFork.decrement();
            leftFork.decrement();
            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            leftFork.increment();
                            rightFork.increment();
                            eating = false;
                        }
                    },
                    r.nextInt(1000, 3000)  //philosopher eats between 1 and 3 seconds
            );
        }
    }

    @Override
    public void run() {
        for(int i = 0;  i < 3;  i++) {
            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            eat();
                        }
                    },
                    r.nextInt(i*1000, i*2000)
            );
        }
    }
}
