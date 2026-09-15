public class Leaf<O extends Nodeable> extends Node{
    private final O obj;

    public Leaf(String key, O obj){
        super(key);
        this.obj = obj;
        increaseSize();
        updateWeight();
    }
    public Leaf(String key){
        super(key);
        this.obj = null;
    }
    public void updateWeight(){
        if(obj != null)
            this.setWeight(this.getSize() * this.obj().getValue());
        else
            setWeight(0);
    }
    public O obj(){return this.obj;}


}

