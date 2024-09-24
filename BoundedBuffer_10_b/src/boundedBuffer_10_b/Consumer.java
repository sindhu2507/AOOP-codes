package boundedBuffer_10_b;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Integer> buffer;

    public Consumer(BlockingQueue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer item = buffer.take();
                if (item == -1) {
                    buffer.put(-1); 
                    break;
                }
                System.out.println("Consumed: " + item);
                Thread.sleep(150); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
