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

        public void printLL(){
            Node temp = head;
            if(head ==null){
                System.out.println("LL is empty.");
            }
            while(temp !=null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }
        public void addM(int data, int idx){
            if(idx ==0){
                addFirst(data);
                return;
            }
            Node newNode = new Node(data);
            Node temp = head;
            int i = 0;

            while(i<idx-1){
                temp = temp.next;
                i++;
            }
            //when temp = prev
            newNode.next = temp.next;
            temp.next = newNode;  
        }

        public int helper(Node head, int key){
            if(head == null){
                return -1;
            }
            if(head.data == key){
                return 0;
            }
            int idx = helper(head.next, key);
            if(idx==-1){
                return -1;
            }
            return idx+1;
        }
        public int recSearch(int key){
            return helper(head,key);
        }

        // ^     REVERSE LL
        public void reverse(){
            Node prev = null;
            Node curr =tail= head;
            Node next;

            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
        // ^  REMOVE Nth ELEMENT FROM LL
        public void removeNth(int idx){
            // find size
            int size = 0;
            Node temp = head;
            while(temp != null){
                temp = temp.next;
                size++;
            }
            //if head delete
            if(size == idx){
                head = head.next;
            }
            //else
            Node prev = head;
            int i = 1;
            int toFind = size - idx;
            while(i<toFind){
                prev = prev.next;
                i++;
            }
            prev.next = prev.next.next;
            return;
        }
        // ^  FIND MID of LL
        public Node findMid(Node head){
            Node slow = head;
            Node fast = head;

            while(fast!=null && fast.next != null){
                slow = slow.next;//+1
                fast = fast.next.next; //+2
            }
            return slow; 
        }

        // ^   CHECK PALLINDROME
        public boolean checkPallindromeLL(){
            //some base cases
            if(head == null || head.next==null){
                return true;
            }
            
            //S1 - Find mid
            Node midNode = findMid(head);

            //S2 - reverse 2nd half
            Node prev = null;
            Node curr = midNode;
            Node next;
            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = curr.next;
            }


            Node right = prev; // right half ka head
            Node left = head;  // left half ka head


            //S3 - Compare left and right halves
            while(right !=null){
                if(left.data!=right.data){
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;

        }
        // ^  DETECT CYCLE
        public boolean isCycle(){
            Node slow = head;
            Node fast = head;
            while(fast!= null && fast.next !=null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    return true;
                }
            }
            return false;
        }

        // ^  REMOVE CYCLE FROM LL
        public void removeCycle(){
            //detect cycle
            Node slow = head;
            Node fast = head;
            boolean cycle = false;
            while(fast!= null && fast.next !=null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    cycle = true;
                    break;
                }
            }
            if(cycle == false){
                return ;
            }
            //find meeting point\
            slow = head;
            Node prev = null; // last node stored here
            while(slow!=fast){
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            // remove cycle
            prev.next = null;
        }

        // ^   MERGE SORT ON LL
        public Node getMidM(Node head){
            Node slow = head;
            Node fast = head.next;

            while(fast!=null && fast.next!= null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        private Node merge(Node head1, Node head2){
            Node mergeLL = new Node(-1);
            Node temp = mergeLL;

            while(head1!= null && head2!=null){
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
            while(head2!=null){
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
            return mergeLL.next;
        }
        public Node mergeSort(Node head){
            if(head ==null || head.next == null){
                return head;
            }
            //find mid
            Node mid = getMidM(head);
            //left and right MS
            Node rightHead = mid.next;
            mid.next = null;
            Node newLeft = mergeSort(head);
            Node newRight = mergeSort(rightHead);

            //merge
            return merge(newLeft, newRight);
        }

            // ^   Z I G Z A G  L L 
        public void zigzagLL(){
            //find middle
            Node slow = head;
            Node fast = head.next;
            while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }
            Node mid = slow;

            //reverse LL
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
            Node nextL , nextR;
            
            //zazigzag
            while(left!=null && right!= null){
                nextL = left.next;
                left.next = right;
                nextR = right.next;
                right.next = nextL;
                
                //  Updation 
                left = nextL;
                right = nextR;
            }
        }

        // public static void main(String args[]){
        //     LinkedLL ll = new LinkedLL();
        //     ll.addF(200);
        //     ll.addF(104);
        //     ll.addLast(30);
        //     ll.addLast(94);
        //     ll.addLast(54);
        //     ll.addLast(89);
        //     ll.addLast(8);
        //     ll.addLast(895);
        //     ll.printLL();
        //     ll.head = ll.mergeSort(ll.head);
        //     // System.out.println(ll.recSearch(3));
        //     ll.printLL();
        //     ll.zigzagLL();
        //     ll.printLL();
        //     // ll.removeNth(2);
        //     // ll.printLL();

        // }


    public class DoubleLL{
        public class Node{
            int data;
            Node next;
            Node prev;
            public Node(int data){
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }
        public static Node head;
        public static Node tail;
        public static int size;

        //add
        public void addF(int data){
            Node newNode = newNode = new Node(data);
            size++;
            if(head == null){
                head = tail = newNode;
                return;
            }

            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        }

        //print
        public void print(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+"<->");
                temp = temp.next;
            }
            System.out.println("null");
        }

        //remove
        public int removeFirst(){
            if(head == null){
                System.out.println("Empty DLL");
                return Integer.MIN_VALUE;
            }
            if(size == 1){
                int val = head.data;
                head = tail = null;
                size--;
                return val;
            }
            int val = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return val;

        }

    }

    
}
