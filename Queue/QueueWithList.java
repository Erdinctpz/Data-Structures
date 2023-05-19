package Queue;

public class QueueWithList {
    private QueueNode head;
    private QueueNode tail;
    private int size;

    class QueueNode{
        private int data;
        private QueueNode next;

        public QueueNode(int data) {
            this.data = data;
            next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public QueueNode getNext() {
            return next;
        }

        public void setNext(QueueNode next) {
            this.next = next;
        }
    }

    public boolean isEmpty(){
        return (head == null);
        
    }

    public int size() {
        return size;
    }

    public void push(int data){
        QueueNode newNode = new QueueNode(data);
        if(isEmpty()){     
            head = newNode;
            tail = newNode;
            ++size;
            return;
        }
        tail.setNext(newNode);  // if list is not empty
        tail = newNode;
        ++size;
    }

    public int pull(){
        if(isEmpty()){
            System.out.println("Empty list");
            return -1;
        }
        int number = head.getData();
        head = head.getNext();
        --size;
        return number;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Empty list");
            return -1;
        }
        return head.getData();
    }

    public void printQueue(){
        if(this.isEmpty()){
            System.out.println("Empty list");
            return;
        }

        QueueNode temp = head;
        while(temp != null){
            System.out.print(" " + temp.getData());
            temp = temp.getNext();
        }
        
    }

    public static void main(String[] args) {
        QueueWithList myQueue = new QueueWithList();
        myQueue.push(10);
        myQueue.push(5);
        myQueue.push(50);
        myQueue.push(25);
        
        myQueue.printQueue();
        System.out.println("\nQueue's size:" + myQueue.size());
        myQueue.pull();

        System.out.println();
        myQueue.printQueue();
        System.out.println("\nQueue's size:" + myQueue.size());
        //System.out.println("\n" + myQueue.peek());
    }


}
