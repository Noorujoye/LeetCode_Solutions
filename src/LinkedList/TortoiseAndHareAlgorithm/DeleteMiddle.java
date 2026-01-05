package LinkedList.TortoiseAndHareAlgorithm;

public class DeleteMiddle {
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
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


public static Node deleteMiddle(Node head) {
            if (head == null || head.next == null) {
                return null;
            }
            Node slow = head;
            Node fast = head.next;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            slow.next = slow.next.next;
            return head;
        }

        public static void main(String[] args) {
        DeleteMiddle d = new DeleteMiddle();
            d.addLast(1);
            d.addLast(2);
            d.addLast(3);
            d.addLast(4);
            d.addLast(5);
            d.printList();
            d.head = DeleteMiddle.deleteMiddle(d.head);
            d.printList();
        }
    }