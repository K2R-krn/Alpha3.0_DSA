
public class bst {

    static class Node{
        int data;
        Node left;
        Node right;
    
        Node(int data){
            this.data = data;
        }
    }
    
    public static Node insert(Node root, int value){ // Node returned that is ROOT
        if(root == null){
            root = new Node(value);
            return root;
        }
    
        if(root.data>value){
            // left subtree
            root.left = insert(root.left, value);
        }else{
            // right subtre
            root.right = insert(root.right, value);
        }
        return root;
    }
    
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void main(String str[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for(int i =0;i<values.length;i++){
            root = insert(root, values[i]);
        }

        // To verify If above correct or not we print it in inorder traversal wayt and check if correct or no // if corect it will be sorted
        inOrder(root);
        System.out.println();
    }
}
