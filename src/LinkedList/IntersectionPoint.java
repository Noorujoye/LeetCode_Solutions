package LinkedList;

public class IntersectionPoint {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //Linked List class
    static class MyLinkedList {
        Node head;
        Node tail;

        void addLast(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    // -------- Intersection logic (BEST APPROACH) --------
    public static Node intersectionPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;

        Node p1 = head1;
        Node p2 = head2;

        while (p1 != p2) {
            p1 = (p1 == null) ? head2 : p1.next;
            p2 = (p2 == null) ? head1 : p2.next;
        }
        return p1; // intersection node OR null
    }
    public static void main(String[] args) {

        // List A
        MyLinkedList listA = new MyLinkedList();
        listA.addLast(1);
        listA.addLast(2);
        listA.addLast(3);

        // List B
        MyLinkedList listB = new MyLinkedList();
        listB.addLast(7);
        listB.addLast(8);
        listB.addLast(9);

        // Creating REAL intersection (same memory node)
        Node common = new Node(4);
        common.next = new Node(5);

        listA.tail.next = common;
        listB.tail.next = common;

        // Print lists
        System.out.print("List A: ");
        listA.printList();

        System.out.print("List B: ");
        listB.printList();

        // Find intersection
        Node ans = intersectionPoint(listA.head, listB.head);

        if (ans != null)
            System.out.println("Intersection at node with value: " + ans.data);
        else
            System.out.println("No Intersection");
    }
}
