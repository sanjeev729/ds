package linkedlist;

public class Loop {

	public boolean checkLoop(Node head) {

		if (head == null || head.link == null)
			return false;

		Node fast = head;
		Node slow = head;

		while (fast.link != null && fast.link.link != null) {
			fast = fast.link.link;
			slow = slow.link;
			if (fast == slow) {
				System.out.println("Loop exists");
				return true;
			}

		}
		System.out.println("Loop doesn't exists");
		return false;

	}

	public Node findStartLoop(Node head) {
		if (head == null || head.link == null)
			return null;
	
		Node fast = head;
		Node slow = head;
		Node entry = head;
	
		while (fast.link != null && fast.link.link != null) {
			fast = fast.link.link;
			slow = slow.link;
			if (fast == slow) {
				while (slow != entry) {
					slow = slow.link;
					entry = entry.link;
				}
				return entry;
			}
	
		}
		System.out.println("Loop doesn't exists");
		return null;
	}

	public void removeLoop(Node head) {
		
		if (head == null || head.link == null)
			return;
	
		Node slow = head;
		Node fast = head;
	
		while (fast.link != null && fast.link.link != null) {
			slow = slow.link;
			fast = fast.link.link;
			if (slow == fast) {
				break;
			}
		}
	
		if (slow == head) {
			while (fast.link != slow) {
				fast = fast.link;
			}
			fast.link = null;
		} else if (slow == fast) {
			slow = head;
			while (fast.link != slow.link) {
				fast = fast.link;
				slow = slow.link;
	
			}
	
			fast.link = null;
	
		}
	}

	public int loopLength(Node head) {

		Node slow = head;
		Node fast = head;

		while (slow != null && fast != null && fast.link != null) {
			slow = slow.link;
			fast = fast.link.link;
			if (slow == fast) {
				System.out.println("Loop exists going to get Loop length");
				return countNodes(slow);
			}

		}
		return 0;

	}

	public int countNodes(Node n) {
		int res = 1;
		Node temp = n;
		while (temp.link != n) {
			res++;
			temp = temp.link;
		}
		return res;
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.info + " ");
			node = node.link;
		}
	}

	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();
		list.head = new Node(50);
		list.head.link = new Node(20);
		list.head.link.link = new Node(15);
		list.head.link.link.link = new Node(4);
		list.head.link.link.link.link = new Node(10);

		// Creating a loop for testing
		list.head.link.link.link.link.link = list.head.link.link;
		Loop l = new Loop();
		// System.out.println(l.checkLoop(list.head));

		System.out.println(l.checkLoop(list.head));
		System.out.println(l.loopLength(list.head));
		l.removeLoop(list.head);
		System.out.println(l.checkLoop(list.head));
		l.printList(list.head);
		// l.printList(list.head);
	}

}
