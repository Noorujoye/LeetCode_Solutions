package LinkedList.DummyNodeApproach;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0); // dummy node
        ListNode ptr = res;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry; // always include carry

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;   // next carry
            sum = sum % 10;     // digit to store

            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }

        if (carry > 0) {
            ptr.next = new ListNode(carry);
        }

        return res.next; // skip dummy node
    }
}

class Main {
    public static void main(String[] args) {
        // Create first number: 342 -> stored as 2 -> 4 -> 3
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        // Create second number: 465 -> stored as 5 -> 6 -> 4
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(l1, l2);

        // Print result: should be 807 -> stored as 7 -> 0 -> 8
        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print(" -> ");
            result = result.next;
        }
    }
}

