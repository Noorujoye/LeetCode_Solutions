package LinkedList.slow_fast;

public class IsPalindrome {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node head;
    Node tail;
    int size;

    // Add at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Print list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Reverse linked list
    private Node reverse(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Palindrome check
    public boolean isPalindrome(Node head) {

        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;

        // find middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        Node secondHead = reverse(slow.next);

        Node first = head;
        Node second = secondHead;

        while (second != null) {
            if (first.data != second.data) {
                slow.next = reverse(secondHead); // restore
                return false;
            }
            first = first.next;
            second = second.next;
        }

        // restore original list
        slow.next = reverse(secondHead);
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome list = new IsPalindrome();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        list.printList();

        System.out.println("Is Palindrome: " + list.isPalindrome(list.head));

        list.printList(); // list restored
    }
}
