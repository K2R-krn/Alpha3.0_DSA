import java.util.*;
import java.util.LinkedList;
public class B1inaryTrees {

//^ Node class
//^ BT class
//^ 1. PREORDER TRAVERSAL         O(n)
//^ 2. INORDER TRAVERSAL          O(n)
//^ 3. POSTORDER TRAVERSAL        O(n)
//^ 4. LEVEL ORDER                O(n)
//^  5. HEIGHT OF A TREE          O(n)
//^ 6. NUMBER OF NODES IN A TREE  O(n)
//^  7. SUM OF NODES IN A TREE    O(n)
//^  8. DIAMETER OF A TREE        O(n)^2  ( Approach 1)
//&        8.  OPTIMIZED          O(n)    ( Approach 2)
//^  9. Identical Subtree         O(n)
//^  10.  T O P    V I E W        O(n)
//^  11.  Kth Level of a tree     O(n)
//^  12. a. Find Common Ancestor  O(n)    ( Approach 1)
//^      b. Find Common Ancestor  O(n)    ( Approach 2) No extra space other than recursion stack
//^  13. MIN DIST B/W 2 Nodes     O(n)
//^  14. Kth Ancestor of a Node   O(n)
//^  15. Transform to SUM TREE    O(n)

    //! Node class
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }    

    //! BT class
    static class BinaryTree{
        static int index = -1; // static as in every recurrsion we want it to update levels
        public static Node buildTree(int nodes[]){
            index++;
            if(nodes[index]==-1){
                return null;
            }

            Node newNode = new Node(nodes[index]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        //! 1. PREORDER TRAVERSAL   O(n)
        public static void preOrder(Node root){
            // BC
            if(root == null){
                // System.out.print("-1 ");
                return;
            }
            System.out.print(root.data+" ");// 1.  Root print
            preOrder(root.left);            // 2.  Left Subtree
            preOrder(root.right);           // 3.  Right Subtree

        }

        //! 2. INORDER TRAVERSAL   O(n)
        public static void inOrder(Node root){
            // BC
            if(root == null){
                return;
            }
            inOrder(root.left);                 // 1.  Left Subtree
            System.out.print(root.data+" ");    // 2.  Root print
            inOrder(root.right);                // 3.  Right Subtree
        }

        //! 3. POSTORDER TRAVERSAL   O(n)
        public static void postOrder(Node root){
            // BC
            if(root == null){
                return;
            }
            postOrder(root.left);                 // 1.  Left Subtree
            postOrder(root.right);                // 2.  Right Subtree
            System.out.print(root.data+" ");      // 3.  Root print
        }

        //! 4. LEVEL ORDER   O(n)
        public static void levelOrder(Node root){
            if(root==null){
                return;
            }

            // 1. Create Queue
            Queue<Node> q = new LinkedList<>();
            q.add(root); // root and
            q.add(null);//next line added 

            while(!q.isEmpty()){
                Node currNode = q.remove();               // ek ek krke queue ko nukallte hai
                if(currNode == null){                         // if currNode NULL 
                    System.out.println();                         // next line print
                    if (q.isEmpty()) {                        // if Queue empty
                        break;                                    //break
                    }else{              
                        q.add(null);                        // else ADD NULL for next level ending
                    }
                }else{
                    System.out.print(currNode.data+" "); // CuyrrNode data print
                    if(currNode.left != null){              // if Left is not null
                        q.add(currNode.left);                   // add Left in queue
                    }
                    if(currNode.right != null){             // if right is not null
                        q.add(currNode.right);                  // add right in queue
                    }
                }
            }
        }
    }
    //!  5. HEIGHT OF A TREE   O(n)
    public static int height(Node root){
        // BC
        if(root == null){
            return 0;
        }
        //  height for left subtree
        int lh = height(root.left);
        // height for right subtree
        int rh = height(root.right);

        return Math.max(lh, rh)+1;
    }

    //! 6. NUMBER OF NODES IN A TREE   O(n)
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);

        return leftCount+rightCount+1;
    }


    //!  7. SUM OF NODES IN A TREE   O(n)
    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int leftSumm = sum(root.left);
        int rightSumm = sum(root.right);
        
        return leftSumm+rightSumm+root.data;
    }


    //!  8. DIAMETER OF A TREE      O(n)^2
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int selfDia = leftHeight+rightHeight+1;

        return Math.max(selfDia, Math.max(leftDia, rightDia));
    }

    //&   8.  OPTIMIZED  O(n)
    static class Info{
        int ht;
        int diam;

        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameterBetter(Node root){
        if(root ==null){
            return new Info(0, 0);
        }

        Info leftInfo = diameterBetter(root.left);
        Info rightInfo = diameterBetter(root.left);
        
        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;

        return new Info(diam, ht);
    
    }

    //!  9. Identical Subtree

    public static boolean isIdentical(Node node, Node subRoot){

        if(node ==null && subRoot==null){ // that is if both null identical yes
            return true;
        // BELOW ALL Conditions for non identical
        }else if(node == null || subRoot == null || node.data != subRoot.data){ 
            return false;
        }

        //  left subtree non identical
        if(!isIdentical(node.left, subRoot)){
            return false;
        }
        // right subtree no nidentical
        if(!isIdentical(node.right, subRoot)){
            return false;
        }
        
        // As all conditions for non identical are mentioned above,  If it still doesnt satisfy then true only
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot){  // Major kaam  - To check meri subroot main tree me kaha par lye kr rhi hai
        if(root == null){
            return false;
        }
        // first find node which match with subroot
        // first check current node
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }

        boolean leftAns = isSubtree(root.left, subRoot);
        boolean rightAns = isSubtree(root.right, subRoot);
        
        return leftAns || rightAns;
        // OR CAN EVEN WRITE BELO LINE FOR ABOVE 3 LINES OF CODE
        // return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }



    //!  10.  T O P    V I E W
//  As we want two things, Node data info and Horizontal distance info
    static class Infoo{
        Node node;
        int hd;
        public Infoo(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        // LEVEL ORDER TRAVERSAL
        Queue<Infoo> q = new LinkedList<>();
        //  We also want a map to store hd and node info
        HashMap<Integer, Node> map = new HashMap<>();

        int min=0, max =0; 
        // first add root node in queue
        q.add(new Infoo(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Infoo curr = q.remove();
            //.. Condition for null
            if(curr == null){
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            }else{
                // now we can process normal nodes
                // How ?
                // first check if current node s horizontal distance already exist in map or no
                if(!map.containsKey(curr.hd)){ // first time hd is occuring
                    map.put(curr.hd, curr.node);
                }           //key    //value

                if(curr.node.left!= null){ // if left child is not null we add it
                    q.add(new Infoo(curr.node.left , curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null){ // if right child is not null we add it
                    q.add(new Infoo(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }

            
        }

        // To print topview
        for(int i = min;i<=max;i++){
            System.out.print(map.get(i).data+" "); // map.get(i) prints node  as we cant print node we print node.data
        }
        System.out.println();

    }


    //!  11.  Kth Level of a tree
    public static void kthLevel(Node root, int level, int k){
        if(root == null){
            return ;
        }

        if(level == k){
            System.out.print(root.data+" ");
            return;
        }

        kthLevel(root.left, level+1, k);
        kthLevel(root.right, level+1, k);

    }
    
    //!  12. a. Find Common Ancestor ( Approach 1)  O(n)
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1); // Found path from root to n1
        getPath(root, n2, path2); // Found path from root to n2 

        // once get both path now find lca
        int i = 0;
        for(; i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!= path2.get(i)){
                break;
            }
        }
        //last equal node = at i-1th node
        Node lca = path1.get(i-1);
        return lca;
    }
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root==null){ // BC
            return false;
        }
        // Add it in path arraylist 
        path.add(root);
        // If found
        if(root.data ==n){
            return true;
        }
        // Not found, it search it in subtrees
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }

        // if didnt find in left or right subtree /  we remove it from path
        path.remove(path.size()-1);
        return false;

    }

    //!   b.  Approach 2
    public static Node lca2(Node root, int n1, int n2){

        if(root == null /* BC */ ||root.data == n1 || root.data ==n2){
            return root;
        }

        // now find for left and right subtree
        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.right, n1, n2);
        
        // leftlca gave valid value but right gave null  
        // any side null means that side none of value exists  /  and that also means that root node is not lca as next number below it will be lca
        if(rightlca == null){
            return leftlca;
        }
        if(leftlca == null){
            return rightlca;
        }

        // if non null that means ek subntree me n1 exist and other subtree me n2 dsubtrree
        return root;
    }

    //!  13.  Minimum Distance between 2 Nodes  O(n)
    public static int minDistance(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca,n1);
        int dist2 = lcaDist(lca,n2);
        
        return dist1+dist2;
    }
    public static int lcaDist(Node root, int n){
        if(root==null){
            return -1;
        }
        // If root par hi node n hai
        if(root.data == n){
            return 0;
        }
        // check left and right subtree
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist ==-1){ // no subtree has n
            return -1;
        }else if(leftDist ==-1){ // means exist in right dist only
            return rightDist+1;
        }else{
            return leftDist+1;
        }
    }

    //!  14. Kth Ancestor of a Node   O(n)
    public static int kAncestor(Node root, int n, int k){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }
        // Check left and right 
        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);
        //  If -1 doesnt exist
        if(leftDist==-1 && rightDist==-1){
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
    }

    //!  15. Transform to SUM TREE  O(n)

    public static int sumTree(Node root){
        if(root == null){
            return 0;
        }

        int leftChild = sumTree(root.left);
        int rightChild = sumTree(root.right);

        int data = root.data;
        int newLeft = root.left ==null ? 0 : root.left.data;
        int newRight = root.right ==null ? 0 : root.right.data;

        root.data = leftChild+newLeft+rightChild+newRight;
        return data;
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String args[]){ 
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        //! 1. PreOrder Print
        // tree.preOrder(root);

        //! 2. InOrder Print
        // tree.inOrder(root);
        
        //! 3. PostOrder Print
        // tree.postOrder(root);

        //! 4. LevelOrder Print
        // tree.levelOrder(root);

        //! 5. Tree HEIGHT
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println(height(root));

        //! 6. Number of Nodes in a tree
        // System.out.print(count(root));

        //! 7. Sum of Nodes
        // System.out.print(sum(root)); 

        //! 8. Diameter of a tree O(n) ^ 2
        // System.out.println(diameter(root));
            //& Better Approach O(n)
            // System.out.println(diameterBetter(root).ht);
            // System.out.println(diameterBetter(root).diam);

        //! 9. Subtree of another tree
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        // System.out.println(isSubtree(root, subRoot));

        //! 10. TOP VIEW
        // topView(root);

        //!  11. Kth Level of a tree
        // kthLevel(root, 1, 3);

        //!  12.  a.  Lowest Common Ancestor  (Approach 1)
        // int n1=4, n2=5;
        // int n1=4, n2=7;
        // System.out.println(lca(root, n1, n2).data);
        //!       b.  ( Approach 2 )
        // System.out.println(lca2(root, n1, n2).data);  


        //!  13.  Minimum Distance between 2 Nodes
        // int n1=4, n2=6;
        // System.out.println(minDistance(root, n1, n2));

        //!  14. Kth Ancestor of a Node   O(n)
        // kAncestor(root, 5, 2);
        // kAncestor(root, 5, 1 );

        //!  15. Transform to SUM TREE
        sumTree(root);
        preOrder(root);

    }
}
