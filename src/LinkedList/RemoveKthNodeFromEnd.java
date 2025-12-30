package LinkedList;

public class RemoveKthNodeFromEnd {
    public static Node removeNthFromEnd(Node head, int n) {
        Node fast = head;
        Node slow = head;
        for (int i=0; i<n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addLast(1);
        list.addLast(0);
        list.addLast(2);
        list.addLast(0);
        list.printList();
        list.head = removeNthFromEnd(list.head, 2);
        list.printList();
    }
}
// public ListNode removeNthFromEnd(ListNode head, int n) {

//     // lets cnt the length
//     int cnt = 0;
//     ListNode temp = head;

//     while (temp != null) {
//         cnt++;
//         temp = temp.next;
//     }

//     //if head needs to be removed , the head will point to its next node
//     if (cnt == n) {
//         return head.next;
//     }
//     temp = head;
//     // lets jump to cnt - n node
//     for (int i=1; i< cnt - n; i++) {
//         temp = temp.next;
//     }

//     if (temp.next != null) {
//             // remove the nth node from the end
//     temp.next = temp.next.next;
//     }
//     return head;
// }