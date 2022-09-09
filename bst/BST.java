public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data = d;
        }
    }
    static Node root = null;
    public static Node insertNode(Node root,int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
    
        if(root.data > data){
            root.left = insertNode(root.left, data);
        }
        else{
            root.right = insertNode(root.right, data);
        }
        return root;
    }

    
    public static Node deleteNode(Node root, int data){
        if(root == null){
            return root;
        }
        if(data<root.data){
            root.left = deleteNode(root.left, data);
        }
        else if(data<root.data){
            root.right = deleteNode(root.right, data);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    public static int minValue(Node root){
        int minV = root.data;
        while(root.left !=null){
            minV = root.left.data;
            root = root.left;
        }
        return minV;
    }

    public  static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.data+" ");
        inOrderTraversal(root.right);
    }
    

    static Node prev = null;
    public static Boolean isBst(Node root,Node prev){
        if(root != null){
            isBst(root.left,prev);
            if(prev != null && root.data <= prev.data){
                return false;
            }
            prev = root;
            isBst(root.right, prev);
        }
        return true;
    }

    public static void main(String args[]){
       // int[] values = {5,1,3,4,2,7};
        int[] values = {3,2,5,1,4};
        for(int v : values){
            root = insertNode(root, v);
        }

        inOrderTraversal(root);

        deleteNode(root, 5);
        inOrderTraversal(root);

        Node root1 = new Node(3);
        root1.left = new Node(2);
        root1.right = new Node(5);
        root1.left.left = new Node(1);
        root1.left.right = new Node(4);
        if(isBst(root1,prev)){
            System.out.println("BST");
        }
        else{
            System.out.println("Not BST");
        }
    }

}
