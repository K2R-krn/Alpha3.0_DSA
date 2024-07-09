import java.util.*;

public class avlTrees{

    static class Node{
        int data, height; // height also cuz everytime we dont want to calc height or clal heigfht function to calculate balance factor
        Node left,right;

        Node(int data){
            this.data = data;
            height =1;
        }
    }

    public static Node root;
    
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }

    static int max(int a, int b){
        return (a>b) ? a : b;
    }


    
    public static Node insert(Node root, int key){
        if(root==null){
            return new Node(key);
        }
        if(key<root.data){
            root.left = insert(root.left, key);
        }
        else if(key>root.data){
            root.right = insert(root.right, key);
        }
        else{
            return root; // Duplicate keys not allowed
        }
        // Update my height
        root.height = 1+ Math.max(height(root.left), height(root.right));

        // Get Balance factor for root
        int bf = getBalance(root);

        // Now check cases
        // 1. LL case
        if(bf>1 && key < root.left.data){
            return rightRotate(root);
        }
        // 2. RR case
        if(bf< -1 && key > root.right.data){
            return leftRotate(root);
        }
        //3. LR case
        if(bf>1 && key>root.left.data){
            root.left=leftRotate(root.left);
            return leftRotate(root);
        }
        // 4. RL case
        if(bf < -1 && key < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;// returned if AVL balance
    }
    //!    G E T   B A L A N C E   F A C T O R 
    public static int getBalance(Node root){
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }
    //!     L E F T  R O T A T E
    public static Node leftRotate(Node x){
        // Original positions
        Node y = x.right;
        Node T2 = y.left;

        // Perform Rotation
        y.left = x;
        x.right = T2;

        // Update Hrights
        x.height = max(height(x.left), height(x.right)) +1;
        y.height = max(height(y.left), height(y.right)) +1;
 
        // Return new Root
        return y;
    }
    
    //!     R I G H T   R O T A T E
    public static Node rightRotate(Node y){
        // Original Positions
        Node x = y.left;
        Node T2 = x.right;

        // Perform Rotations
        x.right = y;
        y.left = T2;

        // Update HEIGHTS
        y.height = max(height(y.left), height(y.right));
        x.height = max(height(x.left), height(x.right));
        
        // return new root
        return x;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void main(String args[]){
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);
        /*
                AVL TREE

                    30
                   /  \
                  20   40
                 /  \   \
                10  25  50
        */
        preOrder(root);
    }
}