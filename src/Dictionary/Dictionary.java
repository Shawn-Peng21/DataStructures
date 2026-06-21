package Dictionary;

class Dictionary<K,V>{
    private K[] keys;
    private V[] values;
    private int size;

    Dictionary(){
        keys=(K[])new Object[100];
        values=(V[])new Object[100];
        size=0;
    }

    void insert(K key,V value){
        for(int i=0;i<size;i++){
            if(keys[i].equals(key)){
                values[i]=value;
                return;
            }
        }

        keys[size]=key;
        values[size]=value;
        size++;
    }

    boolean containsKey(K key){
        for(int i=0;i<size;i++){
            if(keys[i].equals(key))
                return true;
        }
        return false;
    }

    V obtain(K key){
        for(int i=0;i<size;i++){
            if(keys[i].equals(key))
                return values[i];
        }

        throw new IllegalStateException();

    }

    void delete(K key){
        for(int i=0;i<size;i++) {
            if (keys[i].equals(key)) {
                for (int j = i; j < size - 1; j++) {
                    keys[j] = keys[j + 1];
                    values[j] = values[j + 1];
                }
                size--;
                return;
            }
        }
    }
}