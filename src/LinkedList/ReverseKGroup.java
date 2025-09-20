package LinkedList;

public class ReverseKGroup {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Function to reverse nodes in k-group
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail = dummy;
        ListNode temp = head;

        while (true) {
            ListNode kth = temp;
            int cnt = 1;
            while (cnt < k && kth != null) {
                kth = kth.next;
                cnt++;
            }

            if (kth == null) break;

            ListNode nextGroupStart = kth.next;
            kth.next = null;

            ListNode reversedHead = reverse(temp);

            prevGroupTail.next = reversedHead;
            temp.next = nextGroupStart;

            prevGroupTail = temp;
            temp = nextGroupStart;
        }

        return dummy.next;
    }

    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Create linked list: 1->2->3->4->5->6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        int k = 2; // group size

        ReverseKGroup sol = new ReverseKGroup(); // instantiate the class
        System.out.println("Original list:");
        printList(head);

        ListNode newHead = sol.reverseKGroup(head, k);

        System.out.println("Reversed in groups of " + k + ":");
        printList(newHead);
    }
}
