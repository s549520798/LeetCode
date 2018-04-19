package leetcode21_30;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Example:
 * Input:
 * [ 1->4->5,
 * 1->3->4,
 * 2->6    ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class LeetCode023 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(7);
        ListNode l3 = new ListNode(4);
        l3.next = new ListNode(8);
        l3.next.next = new ListNode(9);
        l3.next.next.next = new ListNode(11);
        ListNode result = mergeKLists(new ListNode[]{l1, l2, l3});
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    /*
    Time Limit Exceeded
     */
//    public static ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0 ) return null;
//        ListNode mResult = lists[0];
//        int i = 1;
//        while (i < lists.length) {
//            mResult = mergeTwoLists(mResult,lists[i]);
//            i++;
//        }
//        return mResult;
//    }
//    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//
//        ListNode mResult = new ListNode(0);
//        ListNode temp = mResult;
//        while (l1 != null || l2 != null) {
//            if (l1 != null && l2 != null) {
//                if (l1.val == l2.val) {
//                    temp.next = new ListNode(l1.val);
//                    temp = temp.next;
//                    l1 = l1.next;
//                    temp.next = new ListNode(l2.val);
//                    temp = temp.next;
//                    l2 = l2.next;
//                } else if (l1.val < l2.val) {
//                    temp.next = new ListNode(l1.val);
//                    l1 = l1.next;
//                    temp = temp.next;
//                } else {
//                    temp.next = new ListNode(l2.val);
//                    l2 = l2.next;
//                    temp = temp.next;
//                }
//            } else {
//                if (l1 == null) {
//                    temp.next = l2;
//                    break;
//                } else {
//                    temp.next = l1;
//                    break;
//                }
//            }
//
//        }
//        return mResult.next;
//    }
    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val < o2.val) {
                return -1;
            } else if (o1.val == o2.val) {
                return 0;
            } else {
                return 1;
            }
        });
        ListNode head = new ListNode(0);
        ListNode temp = head;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (queue.peek() != null){
            temp.next = queue.poll();
            temp = temp.next;
            if (temp.next != null){
                queue.add(temp.next);
            }
        }
        return head.next;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }
}
