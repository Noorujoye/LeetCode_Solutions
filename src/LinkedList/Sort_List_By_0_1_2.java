package LinkedList;

public class Sort_List_By_0_1_2 {
//    naive approach
    /*
    public static Node sortList(Node head) {
        int cnt_0 = 0, cnt_1 = 0, cnt_2 = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) cnt_0++;
            else if (temp.data == 1) cnt_1++;
            else cnt_2++;
            temp = temp.next;
        }
        temp = head;
        while (cnt_0 > 0) {
            temp.data = 0;
            temp = temp.next;
            cnt_0--;
        }

        while (cnt_1 > 0) {
            temp.data = 1;
            temp = temp.next;
            cnt_1--;
        }
        while (cnt_2 > 0) {
            temp.data = 2;
            temp = temp.next;
            cnt_2--;
        }
        return head;
    }
     */
//Dummy node approach
    public static Node sortList(Node head) {
        Node temp = head;

        Node list0 = new Node(-1);
        Node zero = list0;

        Node list1 = new Node(-1);
        Node one = list1;

        Node list2 = new Node(-1);
        Node two = list2;

        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (list1.next != null)? (list1.next) : list2.next;
        one.next = list2.next;
        two.next = null;


        return list0.next;
    }
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addLast(1);
        list.addLast(0);
        list.addLast(2);
        list.addLast(0);
        list.printList();
        list.head = sortList(list.head);
        list.printList();
    }
}
