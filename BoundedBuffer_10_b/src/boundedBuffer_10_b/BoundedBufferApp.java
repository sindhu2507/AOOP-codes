package boundedBuffer_10_b;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BoundedBufferApp {
    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(10);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread1 = new Thread(new Consumer(buffer));
        Thread consumerThread2 = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();

        try {
            producerThread.join();
            consumerThread1.join();
            consumerThread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

