public class InNode extends Node{
    private Node left = null;
    private Node middle = null;
    private Node right = null;

    public InNode(String key){
        super(key);
    }
    public Node getRight(){return this.right;}
    public Node getLeft(){return this.left;}
    public Node getMiddle(){return this.middle;}


    public void updateWeight(){
        this.setWeight(this.left.getWeight());

        if(this.middle != null) {
            this.addWeight(this.middle.getWeight());
        }

        if(this.right != null) {
            this.addWeight(this.right.getWeight());
        }
    }
    public void updateSize(){
        this.setSize(this.left.getSize());

        if(this.middle != null) {
            this.addSize(this.middle.getSize());
        }

        if(this.right != null) {
            this.addSize(this.right.getSize());
        }

    }
    public void updateKey(){
        String key = this.left.getKey();

        if(this.middle != null)
            key = this.middle.getKey();

        if(this.right != null)
            key = this.right.getKey();

        this.setKey(key);

    }
    public void updateParameters(){
        updateSize();
        updateWeight();
        updateKey();
    }

    public void setChildren(Node l, Node m, Node r){
        this.left = l;
        this.middle = m;
        this.right = r;
        l.setParent(this);
        if(m != null) m.setParent(this);
        if(r != null) r.setParent(this);
        updateParameters();
    }
    public void updateTillRoot(){
        InNode current = this;
        while(current != null){
            current.updateParameters();
            current = current.getParent();
        }
    }
    public Node insertAndSplit(Node newNode ){
        Node l, m, r;
        l = this.left;
        m = this.middle;
        r = this.right;

        if(r == null){
            if(newNode.compareTo(l) < 0)
                setChildren(newNode,l,m);
            else if(newNode.compareTo(m) < 0)
                setChildren(l,newNode,m);
            else
                setChildren(l,m,newNode);
            return null;
        }

        InNode newSubTree = new InNode(null);
        if(newNode.compareTo(l) < 0){
            this.setChildren(newNode,l,null);
            newSubTree.setChildren(m,r,null);
        }
        else if(newNode.compareTo(m) < 0){
            this.setChildren(l,newNode,null);
            newSubTree.setChildren(m,r,null);
        }
        else if(newNode.compareTo(r) < 0){
            this.setChildren(l,m,null);
            newSubTree.setChildren(newNode,r,null);
        }
        else{
            this.setChildren(l,m,null);
            newSubTree.setChildren(r,newNode,null);
        }
        return newSubTree;
    }
}
