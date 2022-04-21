class Node{
    int item;
    Node right,left;
    Node(int data){
        item = data;
        left = null;
        right = null;
    }
}

class TreeBFS {
    Node root;
    TreeBFS(){
        root = null;
    }

    public static void main(String[] args){
        TreeBFS tree = new TreeBFS();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.printLevelOrder();
    }
    public void printLevelOrder(){

        int height = height(root);
        int i;
        for(i =1;i<=height;i++){
            printCurrentLevel(root,i);
        } 
    }

    public int height(Node root){
        if(root == null){
            return 0;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        if(lheight>rheight){
            return(lheight + 1);
        }
        else{
            return(rheight + 1);
        }
    }
    public void printCurrentLevel(Node root,int level){
        if(root == null){
            return;
        }
        if(level == 1){
            System.out.print(root.item);
        }
        if(level>1){
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }
}
