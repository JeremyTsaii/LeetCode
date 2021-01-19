        return right;
    }
    
    public int getVal() {
        return val;
    }
}
​
​
class MyLinkedList {
    Node head;
    Node tail;
    int size;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        tail = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= this.size) {
            return -1;
        }
        
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.right;
        }
        
        return cur.getVal();
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        this.size++;
        newHead.setRight(this.head);
        if (this.head != null) {
            this.head.setLeft(newHead);
        } else {
            this.tail = newHead;
        }
        this.head = newHead;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newTail = new Node(val);
        this.size++;
        newTail.setLeft(this.tail);
        if (this.tail != null) {
            this.tail.setRight(newTail);
        } else {
            this.head = newTail;
        }
        this.tail = newTail;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > this.size) {
            return;
        } else if (index == 0) {
            this.addAtHead(val);
        } else if (index == this.size) {
            this.addAtTail(val);
        } else {
            this.size++;
            Node cur = this.head;
            for (int i = 0; i < index; i++) {
                cur = cur.right;
            }
            
            Node newNode = new Node(val);
            Node left = cur.getLeft();
            left.setRight(newNode);
            cur.setLeft(newNode);
            newNode.setLeft(left);
            newNode.setRight(cur);
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= this.size) {
            return;
        }
        
        this.size--;
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.right;
