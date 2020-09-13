import java.io.*;
class Node{
	Node left;
	Node right;
	int data;
}
public class RootToLeafToSum {

    public boolean printPath(Node root, int sum, List<Node> path){
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            if(root.data == sum){
                path.add(root);
                return true;
            }else{
                return false;
            }
        }
        if(printPath(root.left, sum-root.data, path) || printPath(root.right, sum - root.data, path)){
            path.add(root);
            return true;
        }
        return false;
    }
    
    public static void main(String args[]){
        RootToLeafToSum rtl = new RootToLeafToSum();
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(5, head);
        head = bt.addNode(7, head);
        head = bt.addNode(19, head);
        head = bt.addNode(20, head);
        head = bt.addNode(4, head);
        head = bt.addNode(3, head);
        List<Node> result = new ArrayList<>();
        boolean r = rtl.printPath(head, 22, result);
        if(r){
            result.forEach(node -> System.out.print(node.data + " "));
        }else{
            System.out.println("No path for sum " + 22); 
        }
    }
}