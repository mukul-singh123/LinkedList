package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public  class Solutions {
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode righthead = mid.next;
        mid.next = null;
        ListNode left =  sortList(head);
        ListNode right =  sortList(righthead);
        return merge(left, right);
    }

    public static ListNode merge(ListNode head1, ListNode head2){
       ListNode mergedll = new ListNode(-1);
       ListNode temp = mergedll;

        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                temp.next = head1;
                head1 = head1.next;
               
            }else{
                temp.next = head2;
                head2 = head2.next;
                
            }
            temp = temp.next;
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedll.next;

    }

    public static ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
       return slow;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        printList(head);

        head =sortList(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}