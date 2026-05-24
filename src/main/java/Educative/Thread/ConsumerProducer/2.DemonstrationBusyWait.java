package Educative.Thread.ConsumerProducer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DemonstrationBusyWait {
    public static void main( String args[] ) throws InterruptedException {
        final BlockingQueueWithMutex<Integer> q = new BlockingQueueWithMutex<>(5);

        Thread producer1 = new Thread(() -> {
            int i = 1000;
            while (true) {
                q.enqueue(i);
                System.out.println("Producer thread 1 enqueued " + i);
                i++;
            }
        });

        Thread producer2 = new Thread(() -> {
            int i = 5000;
            while (true) {
                q.enqueue(i);
                System.out.println("Producer thread 2 enqueued " + i);
                i++;
            }
        });

        Thread producer3 = new Thread(() -> {
            int i = 100000;
            while (true) {
                q.enqueue(i);
                System.out.println("Producer thread 3 enqueued " + i);
                i++;
            }
        });

        Thread consumer1 = new Thread(() -> {
            while (true) {
                System.out.println("Consumer thread 1 dequeued " + q.dequeue());
            }
        });

        Thread consumer2 = new Thread(() -> {
            while (true) {
                System.out.println("Consumer thread 2 dequeued " + q.dequeue());
            }
        });

        Thread consumer3 = new Thread(() -> {
            while (true) {
                System.out.println("Consumer thread 3 dequeued " + q.dequeue());
            }
        });

        producer1.setDaemon(true);
        producer2.setDaemon(true);
        producer3.setDaemon(true);
        consumer1.setDaemon(true);
        consumer2.setDaemon(true);
        consumer3.setDaemon(true);

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();

        Thread.sleep(1000);
    }
}

class BlockingQueueWithMutex<T> {
    T[] array;
    Lock lock = new ReentrantLock();
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;

    public BlockingQueueWithMutex(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public void enqueue(T item) {
        lock.lock();
        while (size == capacity) {
            // Release the mutex to give other threads
            lock.unlock();
            // Reacquire the mutex before checking the
            // condition
            lock.lock();
        }

        if (tail == capacity) {
            tail = 0;
        }

        array[tail] = item;
        size++;
        tail++;
        lock.unlock();
    }

    public T dequeue() {
        lock.lock();
        while (size == 0) {
            // Release the mutex to give other threads
            lock.unlock();
            // Reacquire the mutex before checking the
            // condition
            lock.lock();
        }

        if (head == capacity) {
            head = 0;
        }

        T item = array[head];
        array[head] = null;
        head++;
        size--;
        lock.unlock();
        return item;
    }
}

