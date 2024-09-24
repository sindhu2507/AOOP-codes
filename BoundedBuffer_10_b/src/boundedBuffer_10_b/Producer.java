package boundedBuffer_10_b;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Integer> buffer;

    public Producer(BlockingQueue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                buffer.put(i);
                System.out.println("Produced: " + i);
                Thread.sleep(100); 
            }
            buffer.put(-1); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

