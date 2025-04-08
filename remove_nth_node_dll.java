class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        if (size == n) {
           return head.next;
        }
        ListNode curr = head;
        for(int i=0; i<size-n-1; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
    
}
