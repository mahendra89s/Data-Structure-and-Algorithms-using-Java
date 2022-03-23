package stack;

class Stack {
    int arr[];
    int top;
    int capacity;

    Stack(int size){
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int data){

        if(isFull()){
            return;
        }
        arr[++top] = data;

    }
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        return arr[--top];
    }
    public void printStack(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        for(int i=0;i<=top;i++){
            System.out.println(arr[i]);
        }
    }
    public boolean isFull(){
        if(capacity-1 == top){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args){
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        // stack.push(40);
        // stack.push(50);
        // stack.push(60);
        stack.printStack();

        stack.pop();
        stack.pop();
        stack.printStack();
    }
}
