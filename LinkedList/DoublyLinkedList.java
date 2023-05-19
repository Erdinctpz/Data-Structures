public class DoublyLinkedList {
    private Node head;
    private int size;    


    class Node{
        private int data;
        private Node next,prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
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

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public boolean isEmpty(){
        return (head==null);
    }

    public int size(){
        return this.size;
    }
    
    public void addFirst(int value){
        if(isEmpty()){
            head = new Node(value);
            ++size;
            return;
        }

        Node newNode = new Node(value);
        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
        ++size;
    }

    public void addLast(int value){
        if(isEmpty()){
            head = new Node(value);
            ++size;
            return;
        }

        Node temp = head;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }

        Node newNode = new Node(value);
        temp.setNext(newNode);
        newNode.setPrev(temp);
        ++size;
    }

    public void addToIndex(int value, int index){
        if(isEmpty()){
            head = new Node(value);
            ++size;
            return;
        }

        if(index == 1){
            addFirst(value);
            return;
        }

        if(index == size + 1){
            addLast(value);
            return;
        }

        if(index < 0 || index > size + 1){
            System.out.println("Illegal Index!");
            return;
        }

        Node temp = head;
        Node newNode = new Node(value);

        int count = 1;
        while(temp.getNext() != null){
            if(count + 1 == index){
                newNode.setNext(temp.getNext());
                newNode.setPrev(temp);
                temp.getNext().setPrev(newNode);
                temp.setNext(newNode);
                ++size;
            }
            temp = temp.getNext();
        }
    }

    public void removeFirst(){
        if(isEmpty()){
            System.out.println("Empty list");
            return;
        }

        head.getNext().setPrev(null);
        head = head.getNext();
        --size;
    }

    public void removeIndex(int index){
        if(index < 1 || index > size){
            System.out.println("Illegal index");
            return;
        }
        if(isEmpty()){
            System.out.println("Empty list");
            return;
        }

        if(index == 1){
            head = head.getNext();
            head.setPrev(null);
            --size;
        }

        Node temp = head;
        if(index == size){
            while(temp.getNext().getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(null);
            --size;
        }

        int count = 1;
        while(temp.getNext() != null){
            if(count + 1 == index){
                temp.setNext(temp.getNext().getNext());
                temp.getNext().setPrev(temp);
                --size;
                return;
            }
            ++count;
            temp = temp.getNext();
        }
    }

    public boolean search(int value) {
        if(isEmpty()){
            System.out.println("Empty list");
            return false;
        }

        Node temp = head;
        while(temp != null){
            if(temp.getData() == value){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Empty list");
            return;
        }

        Node temp = head;
        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
