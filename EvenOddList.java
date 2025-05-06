class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class EvenOddList {

    public static ListNode evenOddList(ListNode head) {
        if (head == null) return null;

        ListNode evenHead = new ListNode(0), evenTail = evenHead;
        ListNode oddHead = new ListNode(0), oddTail = oddHead;

        while (head != null) {
            if (head.val % 2 == 0) {
                evenTail.next = head;
                evenTail = evenTail.next;
            } else {
                oddTail.next = head;
                oddTail = oddTail.next;
            }
            head = head.next;
        }

        evenTail.next = oddHead.next;
        oddTail.next = null;

        return evenHead.next;
    }

    // Helper to print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        ListNode result = evenOddList(head);

        System.out.println("Even First, Then Odd:");
        printList(result);
    }
}
