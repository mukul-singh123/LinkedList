public class occurence_in_dll {
        static Node deleteAllOccurOfX(Node head, int x) {
            // Write your code here
            if(head == null){
                return null;
            }
            
            while( head != null && head.data == x){
                head = head.next;
                if(head.next != null){
                    head.prev = null;
                }
            }
            Node temp = head;
            while(temp != null){
                if(temp.data == x){
                    if(temp.next != null){
                        temp.next.prev = temp.prev;
                    }
                    if(temp.prev != null){
                        temp.prev.next = temp.next;
                    }
                    
                }
                temp = temp.next;
                
            }
            return head;
        }
    
}
