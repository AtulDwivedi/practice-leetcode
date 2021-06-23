package com.atuldwivedi.practice.leetcode.linkedlist.medium;

import java.math.BigInteger;

/**
 * See <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers</a>
 * Difficulty: Medium
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = null;
        ListNode rl1 = revers(l1);
        ListNode rl2 = revers(l2);

        ListNode rl1Curr = rl1;
        String firstNumber = "";
        while (rl1Curr != null) {
            firstNumber = firstNumber + rl1Curr.val;
            rl1Curr = rl1Curr.next;
        }
        BigInteger first = new BigInteger(firstNumber);

        ListNode rl2Curr = rl2;
        String secondNumber = "";
        while (rl2Curr != null) {
            secondNumber = secondNumber + rl2Curr.val;
            rl2Curr = rl2Curr.next;
        }
        BigInteger second = new BigInteger(secondNumber);
        String sum = first.add(second) + "";
        ListNode curr = null;
        for (int i = 0; i < sum.length(); i++) {
            ListNode newNode = new ListNode(Integer.parseInt(sum.charAt(i) + ""), null);
            if (i == 0) {
                sumList = newNode;
                curr = sumList;
            } else {
                curr.next = newNode;
                curr = curr.next;
            }
        }

        return revers(sumList);
    }

    private ListNode revers(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }

    public static void main(String[] args) {
        ListNode list1Node1 = new ListNode(2);
        ListNode list1Node2 = new ListNode(4);
        ListNode list1Node3 = new ListNode(3);
        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;

        ListNode list2Node1 = new ListNode(5);
        ListNode list2Node2 = new ListNode(6);
        ListNode list2Node3 = new ListNode(4);
        list2Node1.next = list2Node2;
        list2Node2.next = list2Node3;

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode resultListHead = addTwoNumbers.addTwoNumbers(list1Node1, list2Node1);

        ListNode next = resultListHead;
        while (next != null) {
            System.out.print(next.val);
            next = next.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
