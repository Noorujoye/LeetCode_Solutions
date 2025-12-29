package LinkedList;

public class OddAndEvenNodes {
    public static Node oddEvenList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        // loop till
        while (even != null && even.next != null) {
            // Link the current odd node to the next odd node
            odd.next = even.next;
            // Move the odd pointer forward
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.printList();
        list.head = oddEvenList(list.head);
        list.printList();
    }
}
