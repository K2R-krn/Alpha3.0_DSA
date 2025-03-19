import java.util.ArrayList;

public class bst2 {
    
    //!  1.  Balanced BST from SORTED array   O(n)
    //!  2.  BST to BALANCED BST              O(n)
    //!  3.  Size of Largest BST in BT
    //!  4.  Merge 2 BST                      O(n)

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node insert(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }

        if(root.data > value){
            root.left = insert(root.left, value);
        }else{
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
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //!  1.  Balanced BST from SORTED array  O(n)
    public static Node createBST(int arr[], int st, int end){
        if(st>end){
            return null;
        }

        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);

        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }


    //!  2.  BST to BALANCED BST             O(n)
    public static void getInorder(Node root, ArrayList<Integer> inorder){           // 1st Step
        if(root == null){
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }
    public static Node createBST2(ArrayList<Integer> inorder, int st, int end){    // 2nd Step
        if(st>end){
            return null;
        }

        int mid = (st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST2(inorder, st, mid-1);
        root.right = createBST2(inorder, mid+1, end);
        return root;
    }
    public static Node balanceBST(Node root){                                      // Combine and write a complete function to perform it
    //  1.  inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
    //  2.  sorted inorder -> balanced BST
        root = createBST2(inorder, 0, inorder.size()-1);
        return root;
    }


    //!  3.  Size of Largest BST in BT       
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max =max;

        }
    }
    public static int maxBST = 0;
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // first take info of left and right subtree
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        
        //now our info after left and right info
        int size = leftInfo.size+rightInfo.size+1;
        int min = Math.min(root.data, Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max,rightInfo.max));
        
        if(root.data<=leftInfo.max || root.data >=rightInfo.min){
            return new Info(false, size, min, max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    //!  4.  Merge 2 BST    O(n)
    public static Node mergeBST(Node root1, Node root2){

        //step 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // 2   merge
        int i = 0, j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        //3 Sorted arr to BST
        return createBST(finalArr, 0, finalArr.size()-1);

    }
    public static Node createBST(ArrayList<Integer> arr, int st, int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }
    public static void main(String args[]){
        // int values[] = {8,5,3,6,10,11,12};
        // Node root = null;
        // for(int i = 0;i<values.length;i++){
        //     root = insert(root, values[i]);
        // }

        // inOrder(root);

        //! 1
        // int arr[] = {3,5,6,8,10,11,12};
        // Node root1 = createBST(arr, 0, arr.length-1);
        // preOrder(root1);
        
        //! 2
        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(3);
        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(12);

        // root = balanceBST(root);
        // preOrder(root);

        //! 3
        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);

        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);
        // /*  
        //                      5
        //                   /    \
        //                 30        60
        //               /    \     /   \
        //             5       20  45    70
        //                        /   \ 
        //                       65    80  
        // */

        // Info info = largestBST(root);
        // System.out.println("Largest BST SIZE : "+maxBST);

        //! 4
        // BST 1
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        //BST 2
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBST(root1, root2);
        preOrder(root);
    }
}
