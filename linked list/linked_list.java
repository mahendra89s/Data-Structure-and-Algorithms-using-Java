class LinkedList{
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static LinkedList insertData(LinkedList list, int data){
        Node new_node = new Node(data);
        new_node.next = null;
        if(list.head == null){
            list.head = new_node;
        }
        else{
            Node last = list.head;
            while(last.next != null){
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static LinkedList insertDataAtPosition(LinkedList list, int index,int data){
        Node currNode = list.head,prev = null;
        Node new_node = new Node(data);
        new_node.next = null;
        if(index == 0 && currNode != null){
            new_node.next = currNode;
            list.head = new_node;
            return list;
        }
        int counter = 0;
        while(currNode != null){
            if(counter == index){
                prev.next = new_node;
                new_node.next = currNode;
            }
            else{
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
        if(currNode == null){
            System.out.println("Key Not found");
        }
        return list;
    }

    public static void printList(LinkedList list){
        Node currNde = list.head;
        while(currNde != null){
            System.out.println(currNde.data+" ");
            currNde = currNde.next;
        }
    
    }
    public static LinkedList deleteByKey(LinkedList list,int key){
        Node currNode = list.head, prev=null;
        //if find at head
        if(currNode!=null && currNode.data==key){
            list.head = currNode.next;
            return list;
        }

        //if find at any location other than head
        while(currNode != null && currNode.data!=key){
            prev = currNode;
            currNode = currNode.next;
        }
        if(currNode != null){
            prev.next = currNode.next;
        }

        //if key not found
        if(currNode == null){
            System.out.println("Key out found");
        }
        return list;
    }

    public static LinkedList deleteByIndex(LinkedList list,int index){
        Node currNode = list.head,prev = null;
        //if index is 0
        if(index == 0 && currNode != null){
            list.head = currNode.next;
            return list;
        }
        int counter = 0;
        while(currNode != null){
            if(counter == index){
                prev.next = currNode.next;
                break;
            }
            else{
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
        if(currNode == null){
            System.out.println("Not found");
        }
        return list;
    }
    public static void main(String[] args){
        LinkedList list = new LinkedList();

        list = insertData(list,1);
        list = insertData(list,2);
        list = insertData(list,3);
        list = insertData(list,4);
        list = insertData(list,5);

        // printList(list);

        // deleteByKey(list,1);
        // printList(list);

        // deleteByIndex(list,3);
        // printList(list);

        insertDataAtPosition(list,3,6);
        printList(list);
    }

}