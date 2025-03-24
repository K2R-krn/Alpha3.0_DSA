import java.util.*;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;
public class BSTRev {
    public class Node{
        private int data;
        private Node left;
        private Node right;
        private int height;

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
