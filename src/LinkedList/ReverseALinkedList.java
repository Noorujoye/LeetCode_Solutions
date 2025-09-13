package LinkedList;
import java.util.LinkedList;


public class ReverseALinkedList {
    public class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
        private Node head;
        private Node tail;
        public int size;


        public  void addFirst(int data) {

            Node newNode = new Node(data);
            size++;

            if (head == null) {
                head=tail=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
        public void reverseList() {


        }




    public static void main(String[] args) {
        ReverseALinkedList node = new ReverseALinkedList();
        node.addFirst(1);
        node.addFirst(2);
        node.addFirst(3);
        node.addFirst(4);
        node.addFirst(5);




    }
}
