package LinkedList;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next  = null;
    }
}
class MyLinkedList {


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
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

    }
}

