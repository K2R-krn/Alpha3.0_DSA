public class LL{
    
    //* Node class 
    //* Add First
    //* Add Last
    //* Add Mid
    //* Search in LL
    //* Length of LL
    //* Print LL
    //* Delete Head
    //* Delete Tail
    //* Delete Mid
    //* Array To Linked List Conversion
    
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = next;
        }
    }
    public Node head;
    public Node tail;
    public int size;
    // Add First
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return ;
        }
        newNode.next = head;
        head = newNode;
    }
    // Add Last
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return ;
        }
        tail.next = newNode;
        tail = newNode;
    }
    
    // Add mid
    public void addMid(int data, int position){
        Node temp = head;
        Node newNode = new Node(data);
        if(head == null){
            temp.data = data;
            head = temp;
        }
        int ptr = 1;
        while(ptr<position-1){
            temp = temp.next;
            ptr++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        
    }

    // Search
    public boolean searchLL(int data){
        Node temp = head;
        while(temp!=null){
            if(temp.data == data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    // Length of LL
    public int lengthLL(){
        int len = 1;
        if(head == null){
            return 0;
        }
        Node temp = head;
        while(temp.next!=null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    // Print
    public void printLL(){
        Node temp = head;
        if(head == null){
            System.out.println("LL is empty.");
            return;
        }
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print(" END ");
        System.out.println();

    }

    // Delete head
    public void deleteHead(){
        if(head == null){
            return;
        }
        head = head.next;
    }
    // Delete Tail
    public void deleteTail(){
        if(head == null || head.next == null){
            return;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next  = null;
        tail = temp;
    }
    // Delete Mid
    public void deleteMid(int position){
        int pos = 1;
        Node temp = head;
        if(head == null){
            return;
        }
        while(pos!=position-1){
            temp = temp.next;
            pos++;
        }
        temp.next = temp.next.next;
    }

    // Array to Linked list
    public static LL arrToLL(int arr[]){
        LL newLL = new LL();
        for(int i = 0;i<arr.length;i++){
            newLL.addLast(arr[i]);
        }
        return newLL;
    }
    public static void main(String args[]){
        LL ll = new LL();
        ll.addLast(5);
        ll.addLast(8);
        ll.addLast(13);
        ll.addLast(29);
        ll.addLast(31);
        ll.addLast(49);

        ll.printLL();
        // System.out.println(ll.searchLL(29));
        // System.out.println(ll.searchLL(49));
        // System.out.println(ll.searchLL(88));
        
        ll.addMid(22, 4);
        ll.printLL();
        System.out.println(ll.lengthLL());
        ll.deleteHead();
        ll.printLL();
        ll.deleteTail();
        ll.printLL();
        ll.deleteMid(3);
        ll.printLL();
        
        int arr[] = {1,4,5,7,8,99};
        LL newLL = arrToLL(arr);
        newLL.printLL();

    }
}