package baidushixi;

public class Solution16 {
	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	// ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode node1 = list1;
		ListNode node2 = list2;
		boolean isend1 = false;
		boolean isend2 = false;
		ListNode result = null;
		int val1 = 0, val2 = 0;
		while (node1 != null || node2 != null) {
			if (!isend1) {
				val1 = node1.val;
			}
			if (!isend2) {
				val2 = node2.val;
			}
			if (node1 == null) {
				isend1 = true;
			}
			if (node2 == null) {
				isend2 = true;
			}
			if (val1 <= val2) {
				result.next = new ListNode(val1);
				node1 = node1.next;
			} else {
				result.next = new ListNode(val2);
				node2 = node2.next;
			}

		}
		return result;
	}
}