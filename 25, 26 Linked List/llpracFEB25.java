import java.util.*;
public class llpracFEB25 {
    
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

    // Add First
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Add Last
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Print LL
    public void printLL(){
        if(head == null){
            System.out.println("LL IS EMPTY : ( ");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+ " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Remove First
    public void removeFirst(){
        if(head==null){
            System.out.println("LL is Empty.");
            return;
        }
        head = head.next;
    }

    // Remove Last
    public void removeLast(){
        if(head==null){
            System.out.println("LL is Empty. ");
            return;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }

    // Search in LL
    public int searchItr(int val){
        Node temp = head;
        int i = 0;

        while(temp!=null){
            if(temp.data == val){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    // public int searchRec(int val){
    //     if(head==null){
    //         return -1;
    //     }

    // }

    // Reverse a linked list
    public void reverseLL(){
        if(head==null){
            System.out.println("LL s empty. ");
            return;
        }
        Node curr = tail = head ;
        Node prev = null;
        Node next ;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String args[]){
        llpracFEB25 ll1 = new llpracFEB25();
        ll1.addFirst(1);
        ll1.addLast(2);
        ll1.addFirst(0);
        ll1.addLast(4);
        ll1.printLL();
        ll1.removeFirst();
        ll1.printLL();
        ll1.removeFirst();
        ll1.printLL();
        ll1.addFirst(1);
        ll1.addFirst(0);
        ll1.printLL();
        ll1.removeLast();
        ll1.printLL();
        ll1.removeLast();
        ll1.printLL();
        ll1.addLast(2);
        ll1.addLast(4);
        ll1.printLL();
        System.out.println(ll1.searchItr(3));
        ll1.reverseLL();
        ll1.printLL();
    
    }
}
