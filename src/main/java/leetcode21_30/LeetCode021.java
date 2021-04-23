package leetcode21_30;

import common.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * e.g
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class LeetCode021 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(8);
        ListNode result = mergeTwoLists(l1,l2);

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode mResult = new ListNode(0);
        ListNode temp = mResult;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val == l2.val) {
                    temp.next = new ListNode(l1.val);
                    temp = temp.next;
                    l1 = l1.next;
                    temp.next = new ListNode(l2.val);
                    temp = temp.next;
                    l2 = l2.next;
                } else if (l1.val < l2.val) {
                    temp.next = new ListNode(l1.val);
                    l1 = l1.next;
                    temp = temp.next;
                } else {
                    temp.next = new ListNode(l2.val);
                    l2 = l2.next;
                    temp = temp.next;
                }
            } else {
                if (l1 == null) {
                    temp.next = l2;
                    break;
                }else {
                    temp.next = l1;
                    break;
                }
            }

        }
        return mResult.next;
    }

}


