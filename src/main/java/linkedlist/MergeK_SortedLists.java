package linkedlist;

public class MergeK_SortedLists {

	class ListNode {

		int info;
		ListNode next;

		public ListNode(int info) {
			this.info = info;
			this.next = null;
		}

	}

	ListNode mergeKsortedList(ListNode[] lists, int start, int end) {

		if (start == end)
			return lists[start];

		int mid = start + (end - start) / 2;

		ListNode left = mergeKsortedList(lists, start, mid);
		ListNode right = mergeKsortedList(lists, mid + 1, end);
		return merge(left, right);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(-1);
		ListNode current = result;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				current = l2;
				l2 = l2.next;
			}

			if (l2 == null) {
				current = l1;
				l1 = l1.next;
			}

			if (l1.info < l2.info) {
				current = l1;
				l1 = l1.next;
			} else {
				current = l2;
				l2 = l2.next;
			}
			current = current.next;

		}

		return result.next;
	}

}
