package ZOffer;

import java.util.Scanner;

public class MergeList {
	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode Merge(ListNode list1, ListNode list2) {

		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}
		ListNode tempNode = null;
		if (list1.val < list2.val) {
			tempNode = new ListNode(list1.val);
			tempNode.next = Merge(list1.next, list2);
		} else {
			tempNode = new ListNode(list2.val);
			tempNode.next = Merge(list1, list2.next);
		}
		return tempNode;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;

		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(7);
		ListNode l6 = new ListNode(8);
		l4.next = l5;
		l5.next = l6;

		ListNode result = Merge(l1, l4);
		Scanner sc = new Scanner(System.in);
		while (result.next != null) {
			System.out.print(result.val + ",");
			sc.nextLine();
			result = result.next;
		}
		System.out.println();
	}

}
