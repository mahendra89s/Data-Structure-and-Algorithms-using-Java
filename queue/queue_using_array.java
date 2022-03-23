package queue;

class Queue {
    int rear,front;
    int arr[];
    int capacity;
    Queue(int size){
        rear = -1;
        front = -1;
        arr = new int[size];
        capacity = size;
    }

    public boolean isEmpty(){
        if(front == -1){
            return true;

        }
        return false;
    }
    public boolean isFull(){
        if(front == 0 && rear==capacity-1){
            return true;
        }
        return false;
    }
    public void push(int data){
        if(isFull()){
            System.out.println("Queue is Full!!!");
            return;
        }
        if(front==-1){
            front = 0;
        }
        arr[++rear] = data;

    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        if(front>=rear){
            front = -1;
            rear = -1;
        }
        front++;
        return arr[front];
    }
    public void printQueue(){
        if(isEmpty()){
            return;
        }
        for(int i=front; i<=rear;i++){
            System.out.print(arr[i] +" ");
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        q.push(60);
        q.printQueue();
        System.out.println();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
    

        System.out.println();

        q.printQueue();
    }
    
}
