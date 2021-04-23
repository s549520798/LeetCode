package leetcode21_30;

import common.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class LeetCode025 {
    public static void main(String[] args) {
        String s = "123456789";
        ListNode test = new ListNode(0);
        ListNode t = test;
        for (int i = 0; i < s.length(); i++) {
            t.next = new ListNode(s.charAt(i));
            t = t.next;
        }
        System.out.println(getLength(test.next));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || getLength(head) < k || k == 1) return head;


        return null;
    }

    static int getLength(ListNode listNode) {
        int mResult = 0;
        while (listNode != null) {
            mResult += 1;
            listNode = listNode.next;

        }
        return mResult;
    }
}
