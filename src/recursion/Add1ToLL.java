package recursion;


public class Add1ToLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data,Node next) {
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

    private static int calCarry(Node temp) {
        if (temp == null) return 1;
        int carry = calCarry(temp.next);
        temp.data += carry;
        if (temp.data < 10) return 0;
        temp.data=0;
        return 1;
    }
    public Node add(Node temp) {
        int carry = calCarry(head);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }


    public static void main(String[] args) {
        Add1ToLL list = new Add1ToLL();
        list.addLast(9);
        list.addLast(1);
        list.addLast(9);
//        list.addLast(15);
//        list.addLast(1);
//        list.addLast(1);
//        list.addLast(1);
//        list.addLast(1);
//        list.addLast(10);
        list.printList();
        list.add(list.head);
        list.printList();
    }
}
