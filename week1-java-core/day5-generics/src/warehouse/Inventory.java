package warehouse;

import java.util.ArrayList;
import java.util.List;

public class Inventory <T extends Product>{
    private List<T> items = new ArrayList<>();

    public void add (T t){
        items.add(t);
    }

    public T get (int index){
        return items.get(index);
    }

    public List<T> getAll(){
        return items;
    }

    public void printAll(){
        for (T item : items) {
            System.out.println(item);
        }
    }
}
