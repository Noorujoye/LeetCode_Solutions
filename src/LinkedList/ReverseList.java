package LinkedList;

public class ReverseList {
    public static Node reverseList(Node head) {

        // create two pointers
        Node prev = null;
        Node temp = head;

        while (temp != null) {
            Node nextNodes = temp.next; // FIRST BREAK THE LIST AND STORED FROM THE SECOND NODE
            temp.next = prev;           // MAKE FIRST NODE FREE FROM THE LIST
            prev = temp;                // NODE PREV POINTER WILL HOLD THE FREE NODE
            temp = nextNodes;           // TEMP WILL WORK ON NEXT NODES ON BY ONE AT LAST PREV WILL HOLD THE HEAD
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
