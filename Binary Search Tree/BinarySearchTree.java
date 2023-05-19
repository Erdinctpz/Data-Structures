public class BinarySearchTree{
    public Node root;
    private int size;

    class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
        public boolean isEmpty(){
            return (size == 0);
        }

        public int size() {
            return size;
        }

        public void add(int value){
            //Check if value already exits in this tree.
            if(search(value)){   
                return; 
            }

            if(root == null){
                root = new Node(value);
                ++size;
                return;
            }

            Node parent = null;
            Node temp = root;
            while(temp != null){
                parent = temp;
                if(temp.getData() > value){
                    temp = temp.getLeft();
                }
                else if(temp.getData() < value){
                    temp = temp.getRight();
                }
            }

            Node newNode = new Node(value);
            if(parent.getData() < value){
                parent.setRight(newNode);
            }else{
                parent.setLeft(newNode);
            }
            ++size;
        }

        public boolean search(int value){
            if(isEmpty()){
                return false;
            }

            Node temp = root;
            while(temp != null){
                if(temp.getData() > value){
                    temp = temp.getLeft();
                }
                else if(temp.getData() < value){
                    temp = temp.getRight();
                }
                else{
                    return true;
                }
            }
            return false;
        }

        public Node min(){
            if(isEmpty()){
                System.out.println("Empty list");
                return null;
            }

            Node temp = root;
            while(temp.getLeft() != null){
                temp = temp.getLeft();
            }
            return temp;
        }

        public Node min(Node root){
            if(isEmpty()){
                return null;
            }

            Node temp = root;
            while(temp.getLeft() != null){
                temp = temp.getLeft();
            }
            return temp;
        }
        
        public Node max(){
            if(isEmpty()){
                System.out.println("Empty list");
                return null;
            }

            Node temp = root;
            while(temp.getRight() != null){
                temp = temp.getRight();
            }
            return temp;
        }

        public Node remove(Node root,int value){
            if(isEmpty()){
                System.out.println("Empty list");
                return null;
            }

            while(root != null){                
                if(root.getData() > value){
                    root.setLeft(remove(root.getLeft(), value));
                    return root;
                }
                else if(root.getData() < value){
                    root.setRight(remove(root.getRight(), value));
                    return root;
                }
                else{
                    if(root.getLeft() == null && root.getRight() == null){
                        root = null;
                        --size;
                        return root;
                    }
                    else if(root.getLeft() != null && root.getRight() == null){
                        root = root.getLeft();
                        --size;
                        return root;
                    }
                    else if(root.getLeft() == null && root.getRight() != null){
                        root = root.getRight();
                        --size;
                        return root;
                    }
                    else{
                        Node temp = min(root.getRight());
                        root.setData(temp.getData());
                        root.setRight(remove(root.getRight(), temp.getData()));
                        return root;
                    }
                }
            }
            return null;
        }

        public void preOrder(Node root){
            if(isEmpty()){
                System.out.println("Empty list");
                return;
            }

            if(root == null){
                return;
            }

            System.out.println(" " + root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }

        public void inOrder(Node root){
            if(isEmpty()){
                System.out.println("Empty list");
                return;
            }

            if(root == null){
                return;
            }

            inOrder(root.getLeft());
            System.out.println(" " + root.getData());
            inOrder(root.getRight());
        }

        public void postOrder(Node root){
            if(isEmpty()){
                System.out.println("Empty list");
                return;
            }

            if(root == null){
                return;
            }

            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(" " + root.getData());
        }

    
}
