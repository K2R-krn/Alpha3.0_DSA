import java.util.*;
import java.util.LinkedList;

import javax.swing.SpringLayout.Constraints;
import javax.swing.tree.TreeNode;
public class BSTRev {
    public class Node{
        private int data;
        private Node left;
        private Node right;
        private int height;
        private Node next;

        public Node(int data){
            this.data = data;
        }

        public int getValue(){
            return data;
        }
    }

    private Node root;
    public BSTRev(){

    }

    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root==null;
    }

    //^ INSERT
    public void insert(int value){
        root = insert(value,root);
    }
    private Node insert(int value, Node node){
        if(node==null){
            node = new Node(value);
            return node;
        }
        if(value<node.data){
            node.left = insert(value, node.left);
        }
        if(value>node.data){
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right))+1;

        return node;
    }

    //^ Check Balanced or no
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node root){
        if(root == null){
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <=1 && balanced(root.left) && balanced(root.right);
    }

    //^ Display
    public void display(){
        display(this.root, " Root Node : ");
    }
    private void display(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.data);
        display(node.left, "Left child of "+node.data+" : ");
        display(node.right, "right child of "+node.data+" : ");
    }

    public void populate(int[] nums){
        for(int i = 0;i<nums.length;i++){
            this.insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length);
    }
    private void populateSorted(int[] nums, int start, int end){
        if(start>=end){
            return ;
        }

        int mid = (start+end)/ 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }


    //^ TRAVERASALS

    //! PRE ORDER
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //! IN ORDER
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }

    //! POST ORDER
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }

    // *  Q U E S T I O N S

    //^ 1. Level Order Traversal
    public List<List<Integer>> levelOrder(Node root){

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> l1 = new ArrayList<>(size);

            for(int i = 0;i<size;i++){
                Node temp = q.poll();
                l1.add(temp.data);
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            result.add(l1);
        }
        return result;
    }

    //^ 2.  (637)  Average of Levels in Binary Tree
    public List<Double> averageOfLevels(Node root) {
        
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            double sum = 0.0;
            int size = q.size();
            for(int i =0;i<size;i++){
                Node temp = q.poll();
                sum+=temp.data;
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);

            }
            res.add(sum/size);
        }
        return res;
    }

    //^ 3.  Level ORder Sucessor of Binary Tree / BST..
    public Node lvSucessor(Node root, int key){
        if(root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.data == key && !q.isEmpty()){
                return q.poll();
            }
            if(curr.left!=null) q.offer(curr.left);
            if(curr.right!=null) q.offer(curr.right);
            if(curr.data == key) return q.poll();
        }
        
        return null;
    }

    //^ 4.  (103)  Binary Tree Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Deque<Node> dq = new LinkedList<>();
        dq.addFirst(root);

        boolean flag = true;

        while(!dq.isEmpty()){
            int size  = dq.size();
            List<Integer> l1 = new ArrayList<>(size);

            if(flag){
                for(int i = 0;i<size;i++){
                    Node temp = dq.pollFirst();
                    if(temp.left!=null) dq.addLast(temp.left);
                    if(temp.right!=null) dq.addLast(temp.right);
                    l1.add(temp.data);
                }
                flag = !flag;
            }else{
                for(int i = 0;i<size;i++){
                    Node temp = dq.pollLast();
                    if(temp.right!=null) dq.addFirst(temp.right);
                    if(temp.left!=null) dq.addFirst(temp.left);
                    l1.add(temp.data);
                }
                flag = !flag;
            }
            result.add(l1);
        }
        return result;
    }

    //^ 5.  (107) Binary Tree Level Order Traversal II
    public List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l1 = new ArrayList<>(size);
            for(int i = 0;i<size;i++){
                Node temp = q.poll();
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                l1.add(temp.data);
            }
            result.add(0,l1);
        }
        return result;
    }

    //^ 6.  (116) Populating Next Right Pointers in Each Node
    //& / // Optimized BFS without extra space (O(1) space complexity).
    //& / LOGIC USED : :
        //&    - Since the tree is perfect, every node has both left and right children.
        //&    - By iterating level-wise and using .next pointers, no extra space is required.
        //&    - Key operations:
        //&         - Connect left child to right child (curr.left.next = curr.right).
        //&         - Connect right child to the next node’s left child (curr.right.next = curr.next.left).
    public Node connectNodesofALevel(Node root){
        if(root == null) return null;

        Node leftMost = root;

        while(leftMost.left!= null){
            Node curr = leftMost;
            while(curr!=null){
                curr.left.next = curr.right;
                if(curr.next!=null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    //^ 7.  (117) Populating Next Right Pointers in Each Node II  -  Difference in this and above is that here TREE IS NOT PERFECT
    public Node connect(Node root) {
        if(root == null) return null;

        Node leftMost = root;

        while(leftMost!=null){
            Node curr = leftMost;
            Node dummy = new Node(0);
            Node prev = dummy;

            while(curr!=null){
                if(curr.left!=null){
                    prev.next = curr.left;
                    prev = prev.next;
                }
                if(curr.right!=null){
                    prev.next = curr.right;
                    prev = prev.next;
                }
                curr = curr.next;
            }
            leftMost = dummy.next;
        }
        return root;
    }

    //^ 8.   (199) Binary Tree Right Side View  // LEFT side view

    // FULL BFS CODE - JUST ONE CONDITION EXTRA WHICH IS UNDER FOR LOOP 
    public List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        
        while(!q.isEmpty()){
            
            int lvSize = q.size();

            for(int i = 0;i<lvSize;i++){
                Node curr = q.poll();
                if( i == lvSize-1) result.add(curr.data); //  RIGHT SIDE = when on last element it adds it to result 
                //if( i == 0) result.add(curr.data); //  LEFT SIDE = when on last element it adds it to result
                if(curr.left!= null) q.offer(curr.left);
                if(curr.right!= null) q.offer(curr.right);
            }
        }
        return result;
    }

    //^  9.  (993)  Cousins in Binary Tree
    public boolean isCousins(Node root, int x, int y) {
        
        if(root == null) return false;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            boolean foundX = false, foundY = false;
            for(int i = 0;i<size;i++){
                Node curr = q.poll();

                // Checking if they have same parent.
                if(curr.left!=null && curr.right!=null){
                    if((curr.left.data == x && curr.right.data == y) || 
                    (curr.right.data == x && curr.left.data == y)) {
                        return false;
                    }
                }

                // Making pointer true if One found
                if(curr.left!=null){
                    q.offer(curr.left);
                    if(curr.left.data == x) foundX = true;
                    if(curr.left.data == y) foundY = true;
                } 
                if(curr.right!=null){
                    q.offer(curr.right);
                    if(curr.right.data == x) foundX = true;
                    if(curr.right.data == y) foundY = true;
                } 
            
            }

            // Check   - BOTH TRUE = same level not siblings but yes cousins 
            //         - ONE TRUE = one on one level another not on that level = not cousins
            if(foundX == true && foundY==true) return true;
            if(foundX == true || foundY==true) return false;
        }
        return false;
    }

    //^ 10.  (101) Symmetric Tree
    public boolean isMirror(Node left, Node right){
        // Both left and right null -> return true
        if(left == null && right == null) return true;
        // When Both not null then -> If any one null or value of left or right not same -> false
        if(left == null || right == null || left.data !=right.data) return false;
        // // If this level perfect -> check for left.left, right.right && left.right, right.left
        return isMirror(left.left, right.right)&& isMirror(left.right, right.left);
    }

    public boolean isSymmetric(Node root) {
        // Base cases:
        //      - If both nodes are null, return true (they are symmetric).
        //      - If only one is null or values don’t match, return false.
        // Recursively check:
        //      - left.left with right.right
        //      - left.right with right.left
        // If all recursive calls return true, the tree is symmetric.

        if(root == null) return true;
        return isMirror( root.left,  root.right);
        


        // If the root is null, return true (an empty tree is symmetric).
        // -Initialize a queue and enqueue the left and right children of the root.
        // -Perform a level-order traversal:
        //      -Dequeue two nodes (left and right).
        //      -If both are null, continue to the next iteration.
        //      -If only one is null or their values don’t match, return false.
        //      -Enqueue their children in the order:
        //      -left.left with right.right
        //      -left.right with right.left
        // -If the queue is exhausted without mismatches, return true.
        
        // if(root == null) return true;

        // Queue<Node> q = new LinkedList<>();
        // q.add(root.left);
        // q.add(root.right);

        // while(!q.isEmpty()){
        //     Node left = q.poll();
        //     Node right = q.poll();

        //     if(left==null && right == null){
        //         continue;
        //     }

        //     if(left == null || right == null){
        //         return false;
        //     }

        //     if(left.data != right.data){
        //         return false;
        //     }

        //     q.add(left.left);
        //     q.add(right.right);
        //     q.add(left.right);
        //     q.add(right.left);
        // }
        // return true;

    }


    //*  D  F  S     D E P T H   F I R S T   S E A R C H   T R A V E R S A L S
    //^  HEIGHT OF A TREE [ 104. Maximum Depth of Binary Tree ]
    // Recursively Finding height
    // BC - base case = if leaf node return 0
    // post leaf will keep on adding 1
    // get maximum of left or right and add 1 for that node and consider max length
    // TC - O(n)  SC - O(n) as recurrsion
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        
        return (Math.max(lh,rh))+1;
    }

    //^ 111. Minimum Depth of Binary Tree [ min height of tree]
    public int minHeight(Node node){
        if(root == null) return 0;
        if(root.left==null) return minHeight(node.right);
        if(root.right==null) return minHeight(node.left);

        int lh = minHeight(node.left);
        int rh = minHeight(node.right);
        
        return Math.min(lh, rh)+1;
    
    }



    //^ 222. Count Complete Tree Nodes  [ COUNT NODES ]
    public int countNodes(Node root) {
        if(root == null) return 0;
        int lc = countNodes(root.left);
        int rc = countNodes(root.right);

        return lc+rc+1;
    }

    //^ COUNT EDGES
    public int countEdges(Node root){
        return countNodes(root)-1;
    }

    //^  543. Diameter of Binary Tree
    int diaMeter = 0;
    public int diameterOfBT(Node root){
        diaHelperHeight(root);
        return diaMeter;
    }
    public int diaHelperHeight(Node root){
        if(root == null) return 0;

        int lh = diaHelperHeight(root.left);
        int rh = diaHelperHeight(root.right);
        
        int dia = lh+rh;
        diaMeter = Math.max(dia, diaMeter);

        return Math.max(lh,rh)+1;
    
    }

     //^ Q11    (226) Invert Binary Tree    /    Mirror of a binary Tree
    // Purpose: Mirrors a binary tree by swapping left and right subtrees at each node.
    // Base Case: If root == null, return null (empty tree).
    // Recursive Calls: First invert left and right subtrees.
    // Swap Operation: After inversion, swap root.left and root.right.
    // Return Value: Return the modified root after swapping.
    // Time Complexity: O(N) (each node is visited once).
    // Space Complexity: O(H) (recursion depth; O(log N) for balanced, O(N) for skewed trees).
    public Node invertTree(Node root) {
        if(root == null) return null;


        Node l = invertTree(root.left);
        Node r = invertTree(root.right);

        root.left = r;
        root.right= l;

        return root;
    }

    //^ 13  108. Convert Sorted Array to Binary Search Tree
    // Purpose: Convert a sorted array into a height-balanced BST.
    // Key Idea: Middle element of the array becomes the root to maintain balance.
    // Recursive Calls:
    //      Left half of the array → Left subtree.
    //      Right half of the array → Right subtree.
    // Base Case: If left > right, return null (no elements left).
    // Time Complexity: O(N) (each element is processed once).
    // Space Complexity: O(log N) (recursive call stack for balanced BST).

    public Node sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length-1);
        
    }
    public Node constructBST(int[] nums, int left, int right){
        if(left>right) return null;

        int mid = left + (right-left) / 2;
        Node root = new Node(nums[mid]);

        root.left = constructBST(nums, left, mid-1);
        root.right = constructBST(nums, mid+1, right);

        return root;
    }

    //^ 14.   ( 114 ) Flatten Binary Tree to Linked List
    // The "linked list" should be in the same order as a pre-order traversal of the binary tree.

    // DID ON OWN - BEST
        // -> Check if root has left. -> if so go to bottom most right of root.left -> then attach there root.right -> now nothing on root.right so attach whole root.left on root.right -> now root.left = null and nothing on left. -> run same thing for root.right that is done with root now go down and fix others.. 
    public void flattenBTtoLL(Node root){
        if( root == null ) return;

        if(root.left!= null){
            Node temp = root.left;
            while(temp.right!=null){
                temp = temp.right;
            }
            temp.right = root.left;
            root.right = root.left;
            root.left = null;
        }
        flattenBTtoLL(root.right);
    }

    //^ 15.  (98) Validate Binary Search Tree
    // Function: Checks if a given binary tree is a valid BST.

    // Base Case: If the node is null, return true (empty trees are valid BSTs).
    // Constraints Check: Ensure node.data is within the valid range (low < node.data < high).
    // Recursive Calls:
    //     Left subtree: helper(node.left, low, node.data) (upper bound updated).
    //     Right subtree: helper(node.right, node.data, high) (lower bound updated).
    // Final Return: Both left and right subtrees must be valid BSTs.

    public boolean isValidBST(Node root){
        return helper(root, null, null);
    }

    public boolean helper(Node node, Integer low, Integer high){
        if(node == null) return true;

        if(low!=null && node.data <= low) return false;
        if(high!=null && node.data >= high) return false;

        boolean leftTree = helper(node.left, low, node.data);
        boolean rightTree = helper(node.right, node.data, high);
        
        return leftTree && rightTree;
    } 








    public static void main(String args[]){
        BSTRev tree = new BSTRev();
        int[] nums = {5,2,7,1,4,6,9,8,3,10};
        tree.populate(nums);
        // tree.display();

        // int[] numsSorted = {1,2,3,4,5,6,7,8,9,10};
        // BSTRev tree1 = new BSTRev();
        // tree1.populateSorted(numsSorted);
        // tree1.display();
        // tree1.inOrder();
        // tree.inOrder();

        List<List<Integer>> levels = tree.levelOrder(tree.root);
        System.out.println("Level Order Traversal: " + levels);
        
        List<Double> Avg = tree.averageOfLevels(tree.root);
        System.out.println("Average of Levels: " + Avg);

        Node ans = tree.lvSucessor(tree.root, 6);
        System.out.println("Level Order sucessor :"+ans.data);

        List<List<Integer>> zigzagLevel = tree.zigzagLevelOrder(tree.root);
        System.out.println("ZigZag order : "+zigzagLevel);

        List<List<Integer>> trav2 = tree.levelOrderBottom(tree.root);
        System.out.println("Level ORder Bottom Traversal : "+trav2);



    }
}
