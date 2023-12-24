import java.util.*;
public class LinkedList {

    //* CREATING 1 NODE
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    // LIKE THIS WE CREATE MULTIPLE NODE WHICH RESULT IN LINKED LIST

    public static Node head;
    public static Node tail;
    public static int size;

    //* ADDING      1.  ADD FIRST     O(1)
    public void addFirst(int data){
       
        // STEP 1    Creating new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail= newNode;
            return;
        }
        // STEP 2    New node next = head
        newNode.next = head;  // LINKED 

        // STEP 3     head = new node
        head = newNode;
    }
    
    //* A          2.  ADD LAST        O(1)
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head ==null){
            head = tail = newNode;
            return;  
        }
        tail.next = newNode;
        tail = newNode;
    }

    //*  P R I N T I N G     L L   O(n)
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

    //*   A D D
    public void add(int idx, int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        
        // i = idx-1   ,   temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //*   R E M O V E     F I R S T
    public int removeFirst(){
        if(size == 0){
            System.out.print("Linked list is empty");
            return Integer.MIN_VALUE;

        }else if(size ==1){
             int val = head.data;
             head = tail= null;
             size = 0;
             return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    //*   R E M O V E     L A S T
    public int removeLast(){
        if(size == 0){
            System.out.print("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size ==1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev : i = size -2
        Node prev = head;
        for(int i = 0;i<size-2;i++){
            prev = prev.next;
        }

        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    //*   I T E R A T I V E      S E A R C H
    public int searchIter(int key){    //        O (n)
        Node temp = head;
        int i = 0;

        while(temp!=null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;

        }

        return -1;
    }

    //*   R E C U R S I V E     S E A R C H       
    public int helperFunc(Node head, int key){ //   O (n)
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
       int idx = (helperFunc(head.next, key));
        if(idx ==-1){
            return -1;
        }
        return idx+1;
    }
    public int searchRec(int key){
        return helperFunc(head, key);
    }

    //*   R E V E R S E   A     L L 
    public void reverseLL(){     //      O (n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //*   FIND AND REMOVE Nth NODE FROM END
    public void deleteNthback(int n){
        //calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if(n==sz){
            head = head.next; // remove furst
            return;
        }
        // sz-n
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i<iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    //*  FIND IF PALLINDROME or NOT
    //s1    finding midnode using slow fast approach
    private Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next; // +2

        }
        return slow; // midNode

    }
    //s2    2nd half reverse krdo
    public boolean checkPallindrome(){
        if(head == null || head.next == null ){
           return true;
        }
        // s1 - check mid
        Node mid = findMid(head);

        // s2 - reverse 2nd half
        Node prev= null;
        Node next;
        Node curr = mid;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // right half head 
        Node left = head; // ledft half head 

        // s3 - cehck left and right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }



      //^       C H A P T E R   2      <   26 Linekd List 2    >


    //*    D E T E C T I N G     L O O P / C Y C L E   I N     L L
    //*    F L O Y D  s   C Y C L E   F I N D I N G    A L G O
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;     // +1
            fast = fast.next.next;// +2
            if(slow == fast){
                return true;     // Cycle exist
            }
        }
        return false;
    }



    //*  R E M O V E     C Y C L E

    // detect cycle
    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        //find meeting point
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // rmeove cycle -> last.next = null
        prev.next = null;
    }


    //*    M E R G E D    S O R T     O N     L L
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


    //* Z I G    Z A G    M E R G E
    public void ZigZag(){
        //find mid
        Node slow = head;
        Node fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL; Node nextR;

        // Alt merge - zig zag merge
        while(left!= null && right!= null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }
    public static void main(String args[]){
        // LinkedList ll = new LinkedList();
        // ll.printLL();
        // ll.addFirst(2);
        // ll.printLL();
        // ll.addFirst(1);
        // ll.addLast(3);
        // ll.printLL();
        // ll.addLast(4);
        // ll.printLL();
        // ll.addLast(5);
        // ll.printLL();


        // ll.add(2, 3);

        // ll.printLL();
        // System.out.println(ll.size);

        // ll.removeFirst();
        // ll.printLL();
        // System.out.println(ll.size);


        // ll.removeLast();
        // ll.printLL();
        // System.out.println(ll.size);

        // System.out.println("Search results");
        // System.out.println(ll.searchIter(4));
        // System.out.println(ll.searchIter(10));

        // System.out.println(ll.searchRec(4));

        // ll.reverseLL();
        // ll.printLL();

        // ll.deleteNthback(2);
        // ll.printLL();

        // ll.addLast(2);
        // ll.addLast(4);
        // ll.printLL();

        // System.out.print(ll.checkPallindrome());




        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // //  1 -> 2 -> 3 -> 2

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());




        LinkedList ll = new LinkedList();


        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(5);
        // 5 -> 4 -> 3 -> 2 -> 1
        //ll.printLL();
        // ll.head = ll.mergeSortLL(ll.head);
        // ll.printLL();


        
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        // 1 -> 2 -> 3 -> 4 -> 5
        ll.printLL();
        ll.ZigZag();
        ll.printLL();


 
    }
}
