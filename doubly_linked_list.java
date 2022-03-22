class DoublyLinkedList {
    Node head = null;
    static class Node {
        Node prev;
        Node next;
        int data;

        Node(int d){
            data = d;
        }
    }

    public void insertData(int data){
        Node currNode = head;
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            new_node.next = null;
            new_node.prev = null;
    
        }
        else{
            while(currNode.next != null){
                currNode = currNode.next;
            }
            currNode.next = new_node;
            new_node.prev = currNode;
            new_node.next = null;
        }
        
    }
    public void printList(){
        Node currNode = head;
        do{
            System.out.print(currNode.data+ " ");
            currNode = currNode.next;
        }while(currNode != null);
    }
    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertData(10);
        list.insertData(20);
        list.insertData(30);
        list.insertData(40);

        list.printList();
    }
}
