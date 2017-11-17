package ZOffer;

import java.util.ArrayList;
import java.util.LinkedList;

import ZOffer.MergeList.ListNode;

public class QuikSortList {
	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	ListNode node1;
	ListNode node2;
	ListNode node3;
	ListNode node4;
	ListNode node5;

	QuikSortList() {
		node1 = new ListNode(3);
		node2 = new ListNode(9);
		node3 = new ListNode(7);
		node4 = new ListNode(4);
		node5 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
	}

	// 单链表快速排序
	public void QuikSortList(ListNode head, ListNode end) {
		if (head == null || head == end) {
			
			return;
		}
		int val = head.val;
		ListNode p = head;
		ListNode q = head.next;

		while (q.next != null) {
			if (q.val < val) {
				p = p.next;
				int temp = q.val;
				q.val = p.val;
				p.val = temp;
			}
			q = q.next;
		}
		head.val = p.val;
		p.val = val;
		QuikSortList(head, p);
		QuikSortList(p.next, end);
		
	}

	public static void main(String[] args) {
		QuikSortList qs = new QuikSortList();
		qs.QuikSortList(qs.node1, qs.node5);
		ListNode temp = qs.node1;
		for (int i = 0; i < 5; i++) {
			System.out.print(temp.val);
			temp = temp.next;
		}
	}

	// public static void QuikSortList(ArrayList<Integer> list) {
	// if (list == null) {
	// return;
	// }
	// int i = 0;
	// int j = i + 1;
	//
	// while (i < list.size() - 1) {
	// int val = list.get(0);
	// while (j < list.size()) {
	// if (list.get(j) < val) {
	// int temp1 = list.get(i + 1);
	// int temp2 = list.get(j);
	// // System.out.println(i + "," + j);
	// i++;
	// list.add(i, temp2);
	// list.remove(i + 1);
	// list.remove(j);
	// list.add(j, temp1);
	// }
	// j++;
	// }
	// for (int e : list) {
	// System.out.print(e + ",");
	// }
	// System.out.println();
	// System.out.println(i + "," + j);
	// j--;
	// list.add(0, list.get(j));
	// list.remove(j + 1);
	// i++;
	// }
	//
	// for (int e : list) {
	// System.out.print(e + ",");
	// }
	// }

}
