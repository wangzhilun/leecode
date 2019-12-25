package com.wzl.leetcode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(l1.val + l2.val);
        do {
            l1 = l1.next;
            l2 = l2.next;
            listNode.next = new ListNode(l1.val + l2.val);
        } while (l1.next != null & l2.next != null);
        return listNode;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
