import java.util.*;
public class bst1 {

    //!  1.  Build BST   // create Node class
    //!      INSERT A NODE
    //!  2.  Search in BST    // O(H) ie H = Height  // O(log n) - average case  // O(n) - worst case 
    //!  3.  Delete a Node in BST    IMPIMP QUESTION
    //!  4.  Print In RANGE
    //!  5.  Print Root to Leaf
    //!  6.  Valid BST
    //!  7.  MIRROR a BST

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

    //!  2.  Search in BST    // O(H) ie H = Height  // O(log n) - average case  // O(n) - worst case 
    public static boolean search(Node root, int key){
        if(root==null){     // root == null
            return false; 
        }
        if(root.data==key){ // root.data == key
            return true;
        }
        if(root.data>key){
            return search(root.left, key); // root.data > key
        }
        else{
            return search(root.right, key); // root.data < key
        }
    }

    //!  3.  Delete a Node in BST.
    public static Node delete(Node root, int value){

        //1 first search it
        if(root.data<value){
            root.right = delete(root.right, value);
        }
        else if(root.data>value){
            root.left = delete(root.left, value);
        }
        else{ // this is the case where we found our value in bst // voila case

            //2  Now comes multiple cases
            // 2 a   CASE 1 = Leaf Node
            if(root.left == null && root.right == null){
                return null;
            }

            // 2 b  CASE 2 = Single Chile
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            // 2 c   CASE 3 = Both left and right children exist
            // so we need to find Inorder Sucessor first  
            Node inoSuc = findInorderSucessor(root.right);  // First found Inorder Sucessor from root rightsubtree
            root.data = inoSuc.data;                        // Replaced value
            delete(root.right, inoSuc.data);                // Ino Suc ko delete kiya at last
        }
        return root;
    }
    public static Node findInorderSucessor(Node root){
        while(root.left !=null){
            root = root.left;
        }
        return root;
    }

    
    //!  4.  Print In RANGE
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){

            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);

        }
        else if(root.data > k1){
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }

    //!  5.  Print Root to Leaf
    public static void printRoottoLeaf(Node root, ArrayList<Integer> path){
        if(root==null){
            return;
        }
        // 1. Add to arraylist
        path.add(root.data);

        // 2. If leaf node then print
        if(root.left == null && root.right == null){
            // PRINTING ARRAYLIST
            for(int i=0;i<path.size();i++){
                System.out.print(path.get(i)+" -> ");
            }
            System.out.println("NULL");
        }
        // 3. Call for left and right nodes
        printRoottoLeaf(root.left, path);
        printRoottoLeaf(root.right, path);

        //4. After printing remove nodes
        path.remove(path.size()-1);

    }

    //!  6.  Valid BST
    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }

        //  Now if current root satisfy for both the condition   // now we analyze both the subtree

        return isValidBST(root.left, min, root)
        &&     isValidBST(root.right, root, max);
        
    }


    //!  7.  MIRROR a BST
    public static Node mirrorBST(Node root){
        if(root == null){
            return null;
        }

        Node leftMirror = mirrorBST(root.left);
        Node rightMirror = mirrorBST(root.right);
        
        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }
     // PREORDER FN
     public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
     }
    public static void main(String str[]){
        // int values[] = {8,5,3,1,4,6,10,11,14};
        // int values[] = {1,1,1};
        int values[] = {8,5,3,6,10,11};
        Node root = null;

        for(int i =0;i<values.length;i++){  
            root = insert(root, values[i]);
        }

        //! 1
        // To verify If above correct or not we print it in inorder traversal wayt and check if correct or no // if corect it will be sorted
        inOrder(root);
        System.out.println();
        //! 2
        // System.out.println(search(root, 99));
        //! 3
        // root = delete(root, 5);
        // inOrder(root);
        //! 4
        // printInRange(root, 4, 13);
        //! 5
        // printRoottoLeaf(root, new ArrayList<>());
        //! 6
        // System.out.println(isValidBST(root, null, null));
        //! 7
        // preOrder(root);
        // mirrorBST(root);
        // System.out.println();
        // preOrder(root);
    }
}
