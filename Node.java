public abstract class Node
        implements Comparable<Node>{
    private String key;
    private Node parent;

    private int weight = 0;
    private int size = 0;

    public Node(String key){
        this.key = key;
    }

    public void setKey(String key){this.key = key;}
    public String getKey(){return this.key;}

    public InNode getParent(){return (InNode)this.parent;}
    public void setParent(Node parent){this.parent = parent;}

    public int getWeight(){return weight;}
    public void setWeight(int w){this.weight = w;}
    public void addWeight(int toAdd){this.weight += toAdd;}
    public abstract void updateWeight();

    public int getSize(){return this.size;}
    public void increaseSize(){this.size++;}
    public void decreaseSize(){this.size--;}
    public void setSize(int newSize){this.size = newSize;}
    public void addSize(int toAdd){this.size += toAdd;}

    @Override
    public int compareTo(Node other){
        return this.key.compareTo(other.key);
    }

    public int compareTo(String key){
        return this.key.compareTo(key);
    }
    public boolean equals(Node other){
        int compareRes = this.key.compareTo(other.key);
        return compareRes == 0 ? true : false;
    }
    public boolean equals(String key){
        return this.key.equals(key);
    }
    @Override
    public String toString() {
        return this.key.toString();
    }
}
