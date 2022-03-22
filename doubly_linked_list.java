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
    public void insertDataAtFront(int data){
        Node currNode = head;
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            new_node.next = null;
            new_node.prev = null;
            return;
        }
        head.prev = new_node;
        new_node.prev = null;
        new_node.next = head;
        head = new_node;
    }

    public void insertDataAtIndex(int data, int Index){
        Node new_node = new Node(data);
        Node currNode = head,prev=null;
        if(head == null){
            head = new_node;
            new_node.next = null;
            new_node.prev = null;
            return;
        }
        int counter = 0;
        do{
            if(counter == Index){
                prev.next = new_node;
                new_node.next = currNode;
                new_node.prev = prev;
                currNode.prev = new_node;
                return;
            }
            else{
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }while(currNode != null);

        prev.next = new_node;
        new_node.next = null;
        new_node.prev = prev;
    }

    public void deleteFromFront(){
        if(head == null){
            return;
        }
        head = head.next;
        head.prev = null;
    }
    public void deleteFromLast(){
        Node currNode = head,prev=null;
        if(head == null){
            return;
        }
        while(currNode.next != null){
            prev = currNode;
            currNode = currNode.next;
        }
        prev.next = null;
        
    }

    public void deleteFromIndex(int index){
        Node currNode = head,prev=null,currNodeNext=null;
        if(head == null){
            return;
        }
        if(index == 0){
            head = currNode.next;
            head.prev = null;
            return;
        }
        int counter = 0;
        do{
            if(counter == index){
                if(currNode.next == null){
                    prev.next = null;
                    return;
                }
                prev.next = currNode.next;
                currNodeNext = currNode.next;
                currNodeNext.prev = prev;
                return;
            }
            else{
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }while(currNode != null);
        return;
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

        // list.insertDataAtFront(50);
        // list.insertDataAtFront(60);
        // System.out.println();
        // list.printList();

        // list.insertDataAtIndex(60,3);
        // System.out.println();
        // list.printList();

        // list.deleteFromFront();
        // list.deleteFromFront();
        // System.out.println();
        // list.printList();

        // list.deleteFromLast();
        // list.deleteFromLast();
        // System.out.println();
        // list.printList();

        // list.deleteFromIndex(3);
        // System.out.println();
        // list.printList();

    }
}
