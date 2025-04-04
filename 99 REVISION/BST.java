import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
    public int getValue(){
        return data;
    }
}

class BinaryTree{
    Node root;
    public BinaryTree(){
        this.root = null;
    }    
    
    //* TRAVERSALS  */
    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    //* LEVEL ORDER */
    public List<List<Integer>> levelOrder(Node root){
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> ans = new ArrayList<>();
            for(int i = 0;i<q.size();i++){
                Node temp = q.poll();
                ans.add(temp.data);
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
                
            }
            result.add(ans);
        }
        return result;
    }

    
}

public class BST {
    public static void main(String args[]){
        BinaryTree bt1 = new BinaryTree();
        bt1.root = 
    }

}
