public class LLD {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        public Node(int data){
            this.data = data;
        }
    }
    public Node head;
    public Node prev;

    // Add First
    public void addFirst(int data){
        Node node = new Node(data);
        node.next = head;
        node.prev = null;
        if(head!=null){
            head.prev = node;
        }
        head = node;
    }

    // Print
    public void printDll(){
        if(head == null){
            System.out.println("Dll is empty.");
        }
        Node node = head;
        while(node!=null){
            System.out.print(node.data+" -> ");
            node = node.next;
        }
        System.out.print("END");
    }

    public static void main(String args[]){
        LLD dll = new LLD();
        dll.addFirst(2);
        dll.addFirst(4);
        dll.addFirst(7);
        dll.addFirst(9);
        dll.addFirst(15);
        dll.addFirst(21);
        dll.addFirst(29);
        dll.addFirst(36);

        dll.printDll();
    }
}
