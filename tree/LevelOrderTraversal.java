import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int dtx = -1;
        public static Node buildTree(int arr[]){
            dtx++;
            if(arr[dtx] == -1){
                return null;
            }

            Node new_node = new Node(arr[dtx]);
            new_node.left = buildTree(arr);
            new_node.right = buildTree(arr);
            return new_node;
        }
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
            return ;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data+ " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }

    }

    public static void LevelOrderNew(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=1; i<=n;i++){
                Node temp = q.poll();
                System.out.print(temp.data + " ");
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            System.out.println();
        }
    }

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    public static int sumNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodesSum = sumNodes(root.left);
        int rightNodesSum = sumNodes(root.right);
        return leftNodesSum + rightNodesSum + root.data;

    }

    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(arr);
        System.out.println(root.data);
        
        
        System.out.println("------");
        inOrder(root);
        System.out.println("------");
        preOrder(root);
        System.out.println("------");
        postOrder(root);

        System.out.println("-------");
        levelOrder(root);

        System.out.println("------- New Level Order");
        LevelOrderNew(root);
        System.out.println("-------");

        System.out.println(countNodes(root));

        System.out.println("-------");

        System.out.println(sumNodes(root));

        System.out.println("-------");

        System.out.println(heightOfTree(root));

    }
}