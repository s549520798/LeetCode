package leetcode1_10;

/**
 * Created by lazylee on 2017/11/26.
 * Question: Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class LeetCode002 {

    public static void main(String[] args) {

        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(6);
        l11.next = l12;
        ListNode l13 = new ListNode(7);
        l12.next = l13;

        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(6);
        l21.next = l22;
        ListNode l23 = new ListNode(4);
        l22.next = l23;

        ListNode result = addTwoNumbers(l11, l21);
        System.out.println(result.val + "");
        System.out.println(result.next.val + "");
        System.out.println(result.next.next.val + "");
        System.out.println(result.next.next.next.val + "");

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
