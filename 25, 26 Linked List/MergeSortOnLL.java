import java.util.*;
public class MergeSortOnLL{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    
    public static Node head;
    public static Node tail;
    public static int size;
    // LIKE THIS WE CREATE MULTIPLE NODE WHICH RESULT IN LINKED LIST

    // public static Node head;
    // public static Node tail;

    public void printLL(){
        if(head == null){
            System.out.println("LL is empty.");
            return;
        }
        Node temp = head;
        while(temp!=null){ 
            System.out.print(" "+temp.data+" ->");
            temp= temp.next;
        }
        System.out.println("null");
    }





    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid node
    }

    public Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1!=null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2!= null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSortLL(Node head){
        //BC   ie   ll khaali or single node
        if(head == null || head.next == null){
            return head;
        }

        // find mid
        Node mid = getMid(head);

        //left and rigt MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSortLL(head);
        Node newRight = mergeSortLL(rightHead);

        //merge
        return merge(newLeft, newRight);
    }
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        // 5 -> 4 -> 3 -> 2 -> 1

        ll.printLL();
        ll.head = ll.mergeSortLL(ll.head);
        ll.printLL();
    }
        

    
}
}

