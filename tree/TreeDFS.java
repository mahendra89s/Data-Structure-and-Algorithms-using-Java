
//Binary tree with DFS Traversal
class Node{
    int item;
    Node left,right;
    Node(int data){
        item = data;
        left = null;
        right = null;
    }
}
class TreeDFS {
    Node root;
    TreeDFS(){
        root = null;
    }

    public void traverseInOrder(Node root){
        if(root != null){
            traverseInOrder(root.left);
            System.out.print(root.item + " ");
            traverseInOrder(root.right);
        }
    }

    public void traversePreOrder(Node root){
        if(root != null){
            System.out.print(root.item + " ");
            traversePreOrder(root.left);
            traversePreOrder(root.right);
        }
    }

    public void traversePostOrder(Node root){
        if(root != null){
            traversePostOrder(root.left);
            traversePostOrder(root.right);
            System.out.print(root.item+" ");
        }
    }
    public static void main(String[] args){
        TreeDFS tree = new TreeDFS();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.traverseInOrder(tree.root);
        System.out.println();
        tree.traversePreOrder(tree.root);
        System.out.println();
        tree.traversePostOrder(tree.root);
        System.out.println();
    }
}
