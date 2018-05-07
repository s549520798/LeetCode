package leetcode21_30;

import common.ListNode;
/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * Your algorithm should use only constant extra space.   //应该使用的变量数量为常数量个
 * You may not modify the values in the list's nodes, only nodes itself may be changed. //不能通过改变node的值来实现
 */
public class LeetCode024 {
    public static void main(String[] args) {
        String s = "123456789";
        ListNode test = new ListNode(0);
        ListNode temp = test;
        for (int i = 0; i < s.length() ; i++) {
            temp.next = new ListNode(s.charAt(i));
            temp = temp.next;
        }

        ListNode result = swapPairs(test.next);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode first;
        while (pre.next != null && pre.next.next != null){
            first  = pre.next;
            //change pre to 0.2.3... change first to 1.3.4
            pre.next = first.next;
            first.next = pre.next.next;
            //change pre to 0.2.1.3....
            pre.next.next = first;
            //change pre to 1.3.4....
            pre = pre.next.next;
        }
        return dummy.next;
    }

}
