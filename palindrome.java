class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
       ListNode mid = isMid(head);

       ListNode curr = mid;
       ListNode prev = null;

       while(curr != null){
          ListNode next = curr.next;
          curr.next = prev;
          prev = curr;
          curr = next;
        }
        ListNode right = prev;
        ListNode left = head;

       while(right != null){
           if(left.val != right.val){
              return false;
           }
           left = left.next;
           right = right.next;
       }
       return true;

    }

    public ListNode isMid(ListNode head){
      ListNode slow = head;
      ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
