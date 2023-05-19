public class SinglyLinkedList {
    private Node head;
    private int size;

    // Node class for data
    class Node{  
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    // Check if linked list is empty.
    public boolean isEmpty(){
        return (size() == 0);
    }
    
    public int size(){
        return size;
    }

    // Add to the beginning of this linked list
    public void addAtHead(int data){
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
        ++size;
    }

    // Add a node to specified index of this linked list
    public void addIndex(int data, int index) {
        if(index < 1 || index > size){
            System.out.println("Index not found");
            return;
        }
        
        Node newNode = new Node(data);
        if(index == 1){
            head = newNode;
            ++size;
            return;
        }

        if(index == size+1){
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            ++size;
        }

        Node temp = head;
        int count=1;
        while(count + 1 != index){
            temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        ++size;
    }

    // Add a node to the end of this linked list
    public void addAtLast(int data){
        if(isEmpty()){
            addAtHead(data);
            return;
        }

        Node newnoNode = new Node(data);
        Node temp = head;
        while(temp.getNext() !=null){
            temp = temp.getNext();
        }

        temp.setNext(newnoNode);
        ++size;
    }

    // remove specified index
    public void removeIndex(int index){
        if(isEmpty()){
            System.out.println("Empty list");
            return;
        }
        if(index == 1){
            head = head.getNext();
            --size;
            return;
        }

        Node newNode = new Node(index);
        Node temp = head;
        int count = 1;
        while(count + 1 != index){
            temp = temp.getNext();
            ++count;
        }
        temp.setNext(temp.getNext().getNext());
        --size;
    }

    // Remove all particular data
    public void removeElements(int data){
        if(isEmpty()){
            System.out.println("Empty list");
            return;
        }

        while(head != null && head.getData() == data){
            head = head.getNext();
            --size;
        }

        Node temp = head;
        while(!isEmpty() && temp.getNext() != null){
            if(temp.getNext().getData() == data){
                temp.setNext(temp.getNext().getNext());
                --size;
            }else{
                temp = temp.getNext();
            }
        }
    }

    // Add the data to this linked list from smallest to largest 
    public void addInOrder(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            ++size;
            return;
        }

        if(head.getData() >= newNode.getData()){
            newNode.setNext(head);
            head = newNode;
            ++size;
            return;
        }

        Node temp = head;
        while(temp.getNext() != null){
            if(temp.getNext().getData() >= newNode.getData()){
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
                ++size;
                return;
            }
            temp = temp.getNext();
        }
        temp.setNext(newNode);
    }

    public void printList(){
        if(isEmpty()){
            System.out.println("Empty list");
            return;
        }

        Node temp = head;
        while(temp != null){
            System.out.println(" " + temp.getData());
            temp = temp.getNext();
        }
    }
    
    public static void main(String[] args) {
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.addAtLast(10);
        myList.addAtHead(50);
        myList.addIndex(15, 2);
        myList.addIndex(30,2);
        myList.removeElements(50);
        myList.removeIndex(3);

        myList.printList();
    }
}