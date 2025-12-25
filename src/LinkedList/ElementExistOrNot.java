package LinkedList;

public class ElementExistOrNot {
    public static int ifPresent(Node head , int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return 1;
            }
            temp = temp.next;
        }
    return 0;
    }
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        int a = ifPresent(list.head , 10);
        System.out.println(a);

    }
}
