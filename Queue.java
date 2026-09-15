public class Queue<T>{
    public class QNode<K>  {
        private K obj;
        public QNode<K> next = null;
        public QNode<K> prev = null;
        public Queue<K> parent;
        public QNode(K key, Queue<K> p) {
            this.obj = key;
            this.parent = p;
        }

        //if this node was in a linkedlist, then it can takes itself off.
        public void takeoff() {
            QNode<K> p = this.prev;
            QNode<K> n = this.next;
            if(p == null && n == null){
                //only node
                this.parent.remove();
            }
            else if(p != null && n != null){
                p.next = n;
                n.prev = p;
                this.parent.countDown();
            }
            else if(p == null){
                this.parent.remove();
            }
            else{
                this.parent.removeLast();
            }
            
        }
    }


    private QNode<T> head = null;
    private QNode<T> tail = null;
    private int size = 0;

    public void countDown(){size--;}
    public void insert(T element){
        QNode<T> newTail = new QNode<>(element, this);
        if (this.tail != null)
            this.tail.next = newTail;
        newTail.prev = this.tail;
        if (this.head == null)
            this.head = newTail;
    
        this.tail = newTail;
        this.size++;
    }
    public T remove(){
        if (head == null) throw new IllegalArgumentException("Empty Queue");
        T ret = this.head.obj;
        this.head = this.head.next; 
        if (this.head != null)
            this.head.prev = null;
        else
            this.tail = null;  
        this.size--;
        return ret;
    }
   public void removeLast(){
        if (tail == null) throw new IllegalArgumentException("Empty Queue");
        this.tail = this.tail.prev;
        if (this.tail != null)
            this.tail.next = null;
        else
            this.head = null;
        this.size--;
    }

    public T peek(){
        if (tail == null) throw new IllegalArgumentException("Empty Queue");
        return this.head.obj;
    }

    public QNode<T> getLastNode(){
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }
}