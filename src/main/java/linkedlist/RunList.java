package linkedlist;

public class RunList {

	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();
		list.head = new Node(10);
		list.head.link = new Node(12);
		list.head.link.link = new Node(11);
		list.head.link.link.link = new Node(11);
		list.head.link.link.link.link = new Node(12);
		list.head.link.link.link.link.link = new Node(11);
		list.head.link.link.link.link.link.link = new Node(10);

		System.out.println("Linked List before removing duplicates : \n ");
		list.display();

		list.removeDuplicateUnSorted(list.head);
		System.out.println("");
		System.out.println("Linked List after removing duplicates : \n ");
		list.display();

	}
}
