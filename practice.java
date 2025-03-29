public class practice{

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public static void addL(int data){
        Node n = new Node(data);
        if(head!=null){
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = n;
            
        }else{
            head = n;
        }
    }

    public static void addF(int data){
        Node n = new Node(data);
        if(head!=null){
           n.next = head;
           head = n; 
        }else{
            head.data = data;
        }
    }

    public static void printLL(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
    }

    public static void removeF(){
        if(head==null){
            return;
        }
        if(head.next == null){
            head = null;
        }
        head = head.next;
    }

    public static void removeL(){
        if(head==null){
            return;
        }
        if(head.next==null){
            head = null;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
    }

    public static void revLL(){
        if(head==null){
            return;
        }
        Node curr = head;
        Node prev = null;
        

        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            // temp1 = temp1.next;
            // if(curr.next==null){
            //     head = curr;
            //     head.next = prev;
            //     return curr;
            // }

        }
        head=prev;
        
    }

    public static void main(String args[]){
        practice ll = new practice();
        ll.addL(6);
        ll.addL(7);
        ll.addL(8);
        ll.addL(9);
        ll.addF(5);
        ll.addF(4);
        ll.addF(3);
        // ll.printLL();
        // removeF();
        // System.out.println();
        // ll.printLL();
        // removeL();
        // System.out.println();
        ll.printLL();

        ll.revLL();
        System.out.println();
        ll.printLL();
        
    }
}