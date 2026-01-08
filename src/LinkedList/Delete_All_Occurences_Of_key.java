package LinkedList;

public class Delete_All_Occurences_Of_key {
        // static + public so other class can use it
        static class Node {
            int data;
            Node next;
            Node prev;

            public Node (int data) {
                this.data = data;
            }
        }
        private Node head;
        private Node tail;


        //create doubly LL from array
        public Node createDoubly(int[] arr) {
            if (arr.length == 0) return null;

            head = new Node(arr[0]);
            tail = head; // tails points to the head

            for (int i=1; i<arr.length; i++) {
                Node temp = new Node(arr[i]);

                tail.next = temp; // new node connected to the cur
                temp.prev = tail; // newNode prev pointing to the prev node

                tail = temp;      // tail moves to point to the new node
            }
            return head;
        }
        void print(Node head) {
            while (head != null) {
                System.out.print(head.data + " <-> ");
                head = head.next;
            }
            System.out.println("null");
        }


    public  static Node deleteALlOccurences(Node head, int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                if (head == temp) {
                    head = head.next;
                }
                Node nextNode = temp.next;
                Node prevNode = temp.prev;
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }
                temp = nextNode;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {10 , 10 , 10, 5};
        Delete_All_Occurences_Of_key d = new Delete_All_Occurences_Of_key();

        d.head = d.createDoubly(arr);
        d.print(d.head);
        d.head = Delete_All_Occurences_Of_key.deleteALlOccurences(d.head , 10);
        d.print(d.head);



    }
}
