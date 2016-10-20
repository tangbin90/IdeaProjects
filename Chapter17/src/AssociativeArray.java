/**
 * Created by TangBin on 9/19/16.
 */

public class AssociativeArray<K,V> {
    private Object[][] pairs;
    private int index;
    public AssociativeArray(int length){
        pairs = new Object[length][];
    }

    public void put(K key, V value){
        if(index>pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }

    public V get(K key){
        for(int i=0;i<index;i++)
            if(key.equals(pairs[i][0]))
                return (V)pairs[i][1];
        return null;
    }
@SuppressWarnings("unchecked")
    public java.lang.String toString(){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<index;i++){
            result.append(pairs[i][0].toString());
            result.append(": ");
            result.append(pairs[i][1].toString());
            if(i<index-1)
                result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args){
        AssociativeArray<String, String> map = new AssociativeArray<String, String>(6);
        map.put("sky", "put");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try{
            map.put("extra", "object");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.print("Too many objects!");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
    }
}
