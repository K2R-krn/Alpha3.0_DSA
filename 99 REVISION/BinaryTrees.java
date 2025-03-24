import java.util.*;
public class BinaryTrees {
    
    public BinaryTrees(){

    }
    private static class Node{
        private int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;


    //^  INSERT ELEMENTS
    public void populateBT(Scanner sc){
        System.out.println("Enter Root node value : ");
        int value = sc.nextInt();
        root = new Node(value);
        populateBT(sc, root);
    }
    private void populateBT(Scanner sc , Node node){
        // INSERT LEFT
        System.out.println("Do you want to enter left of "+node.data);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter node value of left of "+node.data);
            int value = sc.nextInt();
            node.left = new Node(value);
            populateBT(sc, node.left);
        }
        // INSERT RIGHT
        System.out.println("Do you want to enter right of "+node.data);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter node value of right of "+node.data);
            int value = sc.nextInt();
            node.right = new Node(value);
            populateBT(sc, node.right);
        }
    }

    //^ DISPLAY ELEMENTS
    public void display(){
        display(root, "");
    }
    private void display(Node node, String indent){
        if(node==null){
            return;
        }
        System.out.println(indent+node.data);
        display(node.left, indent +"\t");
        display(node.right, indent +"\t");

    }

    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }
    public void prettyDisplay(Node node, int level){
        if(node == null){
            return;
        }
        prettyDisplay(node.right, level+1);

        if(level!=0){ // that is level is not 0
            for(int i = 0;i<level-1; i++){
                System.out.print("|\t");
            }
            System.out.println("|------>"+node.data);
        }else{
            System.out.println(node.data);
        }
        prettyDisplay(node.left, level+1);
    }


    //*   B I N A R Y   S E A R C H   T R E E

    



    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        BinaryTrees tree = new BinaryTrees();
        tree.populateBT(sc);
        tree.display();
        tree.prettyDisplay(); 
    }

}
