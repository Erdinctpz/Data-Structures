
/*---------> Stacking using array <----------*/
public class arrayStack{
    private int arraySize;
    private int top;
    private int data[];

    public arrayStack(int arraySize){
        this.arraySize = arraySize;
        data = new int[this.arraySize];
        top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
        
    }

    public boolean isFull(){
        if(top == arraySize - 1){
            return true;
        }
        return false;
    }

    public int numberOfElements(){
        return (top+1);
    }

    public void push(int data){
        if(!isFull()){
            top++;

            this.data[top] = data;
            return;
        }
        System.out.println("List is full");
    }

    public int pop() {
        if(!isEmpty()){
            int number = this.data[top];
            top--;
            return number;
        }
        System.out.println("Empty list");
        return -1; // return "-1" if list is empty.
    }

    public int peek(){
        if(!isEmpty()){
            int number = this.data[top];
            return number;
        }
        return -1; // return "-1" if list is empty.
    }

    public void printStack(){
        for(int i = 0; i <= this.top; i++){
            System.out.print(" " + data[i]);
        }
    }

    public static void main(String[] args) {
        arrayStack myStack = new arrayStack(5);
        myStack.push(5);
        myStack.push(3);
        myStack.push(10);
        myStack.push(1);
        myStack.push(7);
        myStack.pop();
        myStack.pop();
        
        myStack.printStack();
        System.out.println("\nelement at top of the stack: " + myStack.peek());
        System.out.println("Number of elements: " + myStack.numberOfElements());
    }

}
