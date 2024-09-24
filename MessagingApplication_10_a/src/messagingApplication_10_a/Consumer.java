package messagingApplication_10_a;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<String> sharedBuffer;

    public Consumer(BlockingQueue<String> sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = sharedBuffer.take();
                if (message.equals("DONE")) {
                    break;
                }
                System.out.println("Consumed: " + message);
                Thread.sleep(150); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

