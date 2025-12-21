package LinkedList;

public class ReverseList {
    public static Node reverseList(Node head) {

        // create two pointers
        Node prev = null;
        Node temp = head;

        while (temp != null) {
            Node nextNodes = temp.next; //store next , don't break the link b making head.next = null
            temp.next = prev;
            prev = temp;
            temp = nextNodes;
        }
        return prev;
    }
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.printList();
        list.head = reverseList(list.head);
        list.printList();

    }
}
