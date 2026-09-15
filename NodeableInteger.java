public class NodeableInteger implements Nodeable{
    Integer key;
    public NodeableInteger(int key){
        this.key = key;
    }
    @Override
    public String getKey(){
        long shifted = ((long) key) - (long) Integer.MIN_VALUE; // 0 .. 4294967295
        return String.format("%010d", shifted);
    }

    @Override
    public int getValue(){return key;}
}
