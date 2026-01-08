package LinkedList.TortoiseAndHareAlgorithm;

public class LengthOfLoop {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
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

    // Utility: print list (VERY IMPORTANT for debugging)
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static int lengthOfLoop(Node head) {
        if (head == null || head.next == null) {
            return 0;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return countLoopLength(slow);
            }
        }

        return 0;
    }

    private static int countLoopLength(Node meetingNode) {
        int count = 1;
        Node temp = meetingNode.next;

        while (temp != meetingNode) {
            count++;
            temp = temp.next;
        }

        return count;
    }
    public static void main(String[] args) {
        Node head = new Node(17);
        Node node1 = new Node(12);
        Node node2 = new Node(13);
        Node node3 = new Node(1);
        Node node4= new Node(11);
        Node node5 = new Node(9);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node5.next = node2;


        LengthOfLoop l = new LengthOfLoop();

        int n  = LengthOfLoop.lengthOfLoop(head);
        System.out.println(n);
    }
}
// detect the loop
// then search for starting point by moving slow pointer again from head , both should move with one one