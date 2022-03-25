class CircularQueue {
    int arr[];
    int front,rear;
    int capacity;
    CircularQueue(int size){
        front = -1;
        rear = -1;
        capacity = size;
        arr = new int[size];
    }
    public boolean isEmpty(){
        if(front==-1){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(front==0 && rear == capacity-1){
            return true;
        }
        if(front==rear + 1){
            return true;
        }
        return false;
    }

    public void enqueue(int data){
        if(isFull()){
            return;
        }
        if(front == -1){
            front = 0;
        }
        rear = rear + 1;
        arr[rear%capacity] = data; 
    }
    public void dequeue(){
        if(isEmpty()){
            return;
        }
        if(front == rear){
            front = -1;
            rear = -1;
        }
        else{
            front = (front +1)%capacity;
        }
    }
    public void display(){
        for(int i=front;i<=rear;i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String[] args){

        CircularQueue q = new CircularQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.display();

        q.dequeue();
        System.out.println();
        q.display();
        q.enqueue(70);
        q.display();
    }
}
