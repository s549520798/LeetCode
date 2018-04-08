package leetcode11_20;

import java.util.List;

/**
 * Given a linked list, remove the Nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class LeetCode019 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(8);
        ListNode result = removeNthFromEnd(listNode, 1);
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
        System.out.println(result.next.next.next.val);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = listLength(head);
        if ( length == n) return head.next;
        ListNode temp = head;
        int i = 1;
        while (i < length - n) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return head;
    }

    private static int listLength(ListNode listNode) {
        if (listNode == null) return 0;
        int length = 1;
        ListNode temp = listNode;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
