class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    
    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    
    void segregateEvenOdd() {
        if (head == null || head.next == null) return;
        
        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;
        Node current = head;
        
        while (current != null) {
            int value = current.data;
            
            if (value % 2 == 0) {
                if (evenStart == null) {
                    evenStart = evenEnd = current;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = oddEnd = current;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }
        
        if (evenStart == null || oddStart == null) return;
        
        evenEnd.next = oddStart;
        oddEnd.next = null;
        head = evenStart;
    }
    
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(17);
        list.add(15);
        list.add(8);
        list.add(12);
        list.add(10);
        list.add(5);
        list.add(4);
        list.add(1);
        list.add(7);
        
        System.out.println("Original List:");
        list.printList();
        
        list.segregateEvenOdd();
        
        System.out.println("Segregated List:");
        list.printList();
    }
}
