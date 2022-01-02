package heaps;

import java.util.PriorityQueue;

public class TryPQ {

	public static void main(String[] args) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);

		minHeap.add(1);
		minHeap.add(2);
		minHeap.add(5);
		minHeap.add(4);
		minHeap.add(3);
		minHeap.add(2);

		maxHeap.add(1);
		maxHeap.add(2);
		maxHeap.add(5);
		maxHeap.add(4);
		maxHeap.add(3);
		maxHeap.add(2);
		System.out.println("---------MIN HEAP ----------");
		System.out.print(minHeap);
		System.out.println(" " + minHeap.peek());
		minHeap.poll();
		System.out.print(minHeap);
		System.out.println(" " + minHeap.peek());

		minHeap.poll();
		System.out.print(minHeap);
		System.out.println(" " + minHeap.peek());

		minHeap.poll();
		System.out.print(minHeap);

		System.out.println(" " + minHeap.peek());
		System.out.println("-----MAX HEAP --------");
		System.out.print(maxHeap);
		System.out.println(" " + maxHeap.peek());
		maxHeap.poll();
		System.out.print(maxHeap);
		System.out.println(" " + maxHeap.peek());

		maxHeap.poll();
		System.out.print(maxHeap);
		System.out.println(" " + maxHeap.peek());

		maxHeap.poll();
		System.out.print(maxHeap);

		System.out.println(" " + maxHeap.peek());
	}

}
