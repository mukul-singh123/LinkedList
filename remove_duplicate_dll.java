
class Solution{
    Node removeDuplicates(Node head){
        Node curr = head;
        while(curr != null && curr.next != null){
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
                if(curr.next != null){
                    curr.next.prev = curr;
                }
            }else{
              curr = curr.next;
           }
        }
        return head;
    }
}
