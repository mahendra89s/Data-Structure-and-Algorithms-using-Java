class CircularLinkedList {

    static class Node{
        Node next;
        int data;
        Node(int d){
            data = d;
            next = null;
        }
    }
    public Node head = null;
    public Node tail = null;
    

    public void insertData(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            tail = new_node;
            new_node.next = head;
        
        }
        else{
            tail.next = new_node;
            tail = new_node;
            new_node.next = head;
        }
    }
    public void insertDataAtFirst(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            tail = new_node;
            tail.next = head;
        }
        else{
            new_node.next = head;
            tail.next = new_node;
            head = new_node;

        }
    }

    public void insertDataAtPosition(int index, int data){
        Node new_node = new Node(data);
        Node currNode = head,prev=null;
        if(index == 0){
            new_node.next = head;
            tail.next = new_node;
            head = new_node;
            return;
        }
        int counter = 0;
        do{
            if(counter == index){
                prev.next = new_node;
                new_node.next = currNode;
                return;
            }
            else{
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }while(currNode != head);
        
        tail.next = new_node;
        tail = new_node;
        tail.next = head;

    }

    public static void printList(CircularLinkedList list){
        Node currNode = list.head;
        do{
            System.out.print(currNode.data+ " ");
            currNode = currNode.next;
        }
        while(currNode != list.head);
    }

    public void deleteAtFirst(){
        Node currNode = head;
        if(head != null){
            head = currNode.next;
            tail.next = head;
        }
    }

    public void deleteAtLast(){
        Node currNode = head,prev=null;
        while(currNode.next != tail){
            prev = currNode.next;
            currNode = currNode.next;
        }
        tail = prev;
        tail.next = head;
    }

    public void deleteAtIndex(int index){
        Node currNode = head, prev=null;
        int counter = 0;
        if(index == 0){
            head = currNode.next;
            tail.next = head;
            return;
        }
        
        while(currNode != tail){
            if(counter == index){
                prev.next = currNode.next;
                currNode = currNode.next;
                break;
            }
            else{
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
        if(currNode == tail){
            prev.next = head;
        }
    }

    public static void main(String[] args){
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.insertData(2);
        circularLinkedList.insertData(3);
        circularLinkedList.insertData(4);
        circularLinkedList.insertData(5);

        printList(circularLinkedList);

        // circularLinkedList.deleteAtFirst();
        // System.out.println();
        // printList(circularLinkedList);

        // circularLinkedList.deleteAtLast();
        // System.out.println();
        // printList(circularLinkedList);

        // circularLinkedList.deleteAtIndex(0);
        // System.out.println();
        // printList(circularLinkedList);

        // circularLinkedList.insertDataAtFirst(10);
        // circularLinkedList.insertDataAtFirst(20);
        // System.out.println();
        // printList(circularLinkedList);

        circularLinkedList.insertDataAtPosition(5,9);
        System.out.println();
        printList(circularLinkedList);
    }
}
