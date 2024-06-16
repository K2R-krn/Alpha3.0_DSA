public class LinkedLL {
        // NODE CREATION
        public class Node{
            int data;
            Node next;

            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }
        public static Node head;
        public static Node tail;
        public static int size;

        //Adding First
        public void addFirst(int data){
            //1
            Node newNode = new Node(data);
            if(head ==null){
                head = tail = newNode;
                return;
            }
            //2
            newNode.next = head; //linked one node to another   
            //3
            head = newNode;
        }
        
        public void addLast(int data){
            Node newNode = new Node(data);
            if(head ==null){
                head = newNode = tail;
                return;
            }   
            tail.next = newNode;
            tail = newNode;
        }
        public static void main(String args[]){
            LinkedLL ll = new LinkedLL();
            ll.addFirst(2);
            ll.addFirst(4);
            ll.addLast(3);
            ll.addLast(8);
        }
}
