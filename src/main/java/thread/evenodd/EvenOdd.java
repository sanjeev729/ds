package thread.evenodd;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenOdd {

	public static void main(String[] args) {
		AtomicInteger data = new AtomicInteger(1);
		Object lock = new Object();

		Thread producer = new Even(data, lock);
		Thread consumer = new Odd(data, lock);

		producer.start();
		consumer.start();
	}
}

class Even extends Thread {
	AtomicInteger data;
	Object lock;

	public Even(AtomicInteger data, Object lock) {
		super();
		this.data = data;
		this.lock = lock;
	}

	public void run() {
		while (true) {
			synchronized (lock) {

				if (data.get() % 2 != 0) {
					try {
						lock.wait();
						// break;
					} catch (InterruptedException e) {
						throw new RuntimeException("max size reached ", e);
					}

				}

				System.out.println("Even" + data.get());
				data.incrementAndGet();
				lock.notify();
			}

		}
	}
}

class Odd extends Thread {

	AtomicInteger data;
	Object lock;

	public Odd(AtomicInteger data, Object lock) {
		super();
		this.data = data;
		this.lock = lock;
	}

	public void run()

	{
		while (true) {
			synchronized (lock) {

				if (data.get() % 2 == 0) {
					try {
						lock.wait();
						// break;
					} catch (InterruptedException e) {
						throw new RuntimeException("max size reached ", e);
					}

				}

				System.out.println("Odd" + data.get());
				data.incrementAndGet();
				lock.notify();
			}

		}
	}

}
