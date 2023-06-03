 class AvlTree {
    Node root;
    private int size;
    
    class Node{
        private int data, height;
        private Node left, right;

         Node(int data){
            this.data = data;
            left = right = null;
            height = 1;
        }

         int getData() {
            return data;
        }

         void setData(int data) {
            this.data = data;
        }

         int getHeight() {
            return height;
        }

         void setHeight(int height) {
            this.height = height;
        }

         Node getLeft() {
            return left;
        }

         void setLeft(Node left) {
            this.left = left;
        }

         Node getRight() {
            return right;
        }

         void setRight(Node right) {
            this.right = right;
        }      
    }
    
     boolean isEmpty(){
        return (root == null);
    }

    int size(){
        return size;
    }

    int height(Node root){
        if(root == null){
            return 0;
        }
        return root.getHeight();
    }

    int getBalance(Node root){
        if(root == null){
			return 0;
		}
		return height(root.getLeft()) - height(root.getRight());
    }

    boolean search(Node root, int value){
        if(isEmpty()){
            System.out.println("Empty list");
            return false;
        }

        Node temp = root;
        while(temp != null){
            if(value < temp.getData()){
                temp = temp.getLeft();
            }
            else if(value > temp.getData()){
                temp = temp.getRight();
            }
            else{
                return true;
            }
        }

        return false;
    }

    Node rightRotate(Node root){
        Node pl = root.getLeft();
        Node plr = pl.getRight();

        pl.setRight(root);
        root.setLeft(plr);

		root.setHeight(Math.max(height(root.getLeft()), height(root.getRight())) + 1);
        pl.setHeight(Math.max(height(pl.getLeft()), height(pl.getRight())) + 1);
        
        return pl;
    }

    Node leftRotate(Node root){
        Node pr = root.getRight();
        Node prl = pr.getLeft();

        pr.setLeft(root);
        root.setRight(prl);

		root.setHeight(Math.max(height(root.getLeft()), height(root.getRight())) + 1);
        pr.setHeight(Math.max(height(pr.getLeft()), height(pr.getRight())) + 1);
        
        return pr;
    }
    

    Node insert(Node root, int data){
		if(root == null){
            ++size;
			return (new Node(data));
		}

		if(data < root.getData()){
			root.setLeft(insert(root.getLeft(), data));
		}
		else if(data > root.getData()){
			root.setRight(insert(root.getRight(), data));
		}
		else{
			return root;
		}

		//update height
		root.setHeight(Math.max(height(root.getLeft()), height(root.getRight())) + 1);

		int balance = getBalance(root);

		if(balance > 1 && data < root.getLeft().getData()){
			return rightRotate(root);
		}

		if(balance < -1 && data > root.getRight().getData()){
			return leftRotate(root);
		}

		if(balance > 1 && data > root.getLeft().getData()){
			root.setLeft(leftRotate(root.getLeft()));
			return rightRotate(root);
		}

		if(balance < -1 && data < root.getRight().getData()){
			root.setRight(rightRotate(root.getRight()));
			return leftRotate(root);
		}

		return root;
	}

    Node remove(Node root, int value){
        if(root == null){
            return null;
        }

        if(value < root.getData()){
            root.setLeft(remove(root.getLeft(), value));
        }
        else if(value > root.getData()){
            root.setRight(remove(root.getRight(), value));
        }
        else{
            
            if(root.getLeft() == null){
                --size;
                return root.getRight();
            }

            else if(root.getRight() == null){
                --size;
                return root.getLeft();
            }

            if(root.getLeft() != null && root.getRight() != null){
                int data = findMin(root.getRight());
                root.setData(data);
                root.setRight(remove(root.getRight(), data));
            }
        }

        root.setHeight(Math.max(height(root.getLeft()), height(root.getRight())) + 1);

		int balance = getBalance(root);

		if(balance > 1 && getBalance(root.getLeft()) >= 0){
			return rightRotate(root);
		}

		if(balance < -1 && getBalance(root.getRight()) <= 0){
			return leftRotate(root);
		}

		if(balance > 1 && getBalance(root.getLeft()) < 0){
			root.setLeft(leftRotate(root.getLeft()));
			return rightRotate(root);
		}

		if(balance < -1 && getBalance(root.getRight()) > 0){
			root.setRight(rightRotate(root.getRight()));
			return leftRotate(root);
		}

        return root;
    }

    int findMin(Node root){
        if(isEmpty()){
            System.out.println("Empty list");
            return -1;
        }

        Node temp = root;
        while(temp.getLeft() != null){
            temp = temp.getLeft();
        }

        return temp.getData();   
    }

    int findMax(Node root){
        if(isEmpty()){
            System.out.println("Empty list");
            return -1;
        }

        Node temp = root;
        while(temp.getRight() != null){
            temp = temp.getRight();
        }

        return temp.getData();
    }

    void preOrder(Node root){
        if(root != null){
            System.out.print(" " + root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    void inOrder(Node root){
        if(root != null){
            inOrder(root.getLeft());
            System.out.println(" " + root.getData());
            inOrder(root.getRight());
        }
    }

    void postOrder(Node root){
        if(root != null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(" " + root.getData());
        }
    }




    public static void main(String[] args) {
        AvlTree myt = new AvlTree();
        int deleteVal = 5;

        myt.root = myt.insert(myt.root, 10);
        myt.root = myt.insert(myt.root, 20);
        myt.root = myt.insert(myt.root, 30);
        myt.root = myt.insert(myt.root, 40);
        myt.root = myt.insert(myt.root, 50);
        myt.root = myt.insert(myt.root, 25);
        myt.root = myt.insert(myt.root, 5);

        /* The constructed AVL Tree would be
	            30
		    / \
		   20 40
		  / \  \
		 10 25 50
         	/
        	5
	*/
        
        myt.preOrder(myt.root);
        System.out.println("\nroot: " + myt.root.getData());
        System.out.println("count nodes of tree: " + myt.size());
        
        System.out.println("------After deleted " + deleteVal + "------");
        myt.remove(myt.root, deleteVal);
        myt.preOrder(myt.root);
        System.out.println("\nroot: " + myt.root.getData());
        System.out.println("count nodes of tree: " + myt.size());
        System.out.println("min value of tree: " + myt.findMin(myt.root));
        System.out.println("max value of tree: " + myt.findMax(myt.root));
        
    }
}
