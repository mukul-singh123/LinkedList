class Solution {
    public Node deleteNode(Node head, int x) {
        if (head == null) {
            return null; 
        }
        if (x == 1) {
            head = head.next; 
            if (head != null) {
                head.prev = null; 
            }
            return head;
        }

        Node temp = head;
        int i = 1;
        while (temp != null && i < x) {
           temp = temp.next;
           i++;
        }

        if (temp == null) {
            return head;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }

        return head; 
    }
}
