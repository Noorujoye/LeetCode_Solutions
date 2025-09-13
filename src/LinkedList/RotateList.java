package LinkedList;

class RotateList {

    // Make Node static so it can be used in static methods
    static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Correct method signature to return Node
    public static Node rotateRight(Node head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find the length of the list
        Node curr = head;
        int len = 1;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }

        // Connect the last node to head to form a circular list
        curr.next = head;

        // Compute the final rotation needed
        k = k % len;
        if (k == 0) {
            curr.next = null; // Break the circle and return original head
            return head;
        }

        // Find the new tail at len - k - 1 steps from head
        int stepsToNewTail = len - k - 1;
        Node newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Set the new head and break the circle
        Node newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Helper method to print the list
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        head = rotateRight(head, 6); // Rotating by more than length
        printList(head);
    }
}
