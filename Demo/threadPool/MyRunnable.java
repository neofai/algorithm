package threadPool;

import java.time.LocalDateTime;

public class MyRunnable implements Runnable {
    private String command;

    public MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " === "  + command + "start time = " + LocalDateTime.now());
        justWait((long) (Math.random() * 1000));
        System.out.println(Thread.currentThread().getName() + " === "  + command + "end time = " + LocalDateTime.now());
    }

    private void justWait(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
