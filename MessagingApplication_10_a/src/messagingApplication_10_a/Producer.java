package messagingApplication_10_a;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<String> sharedBuffer;

    public Producer(BlockingQueue<String> sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                String message = "Message " + i;
                sharedBuffer.put(message);
                System.out.println("Produced: " + message);
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        try {
            sharedBuffer.put("DONE"); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
