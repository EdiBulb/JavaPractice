package supplement;

import java.util.Iterator;
import java.util.LinkedList;

public class Main115 {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();

        list.add("apple");
        list.add("banana");
        list.add("grape");
        list.add("strawberry");

        Iterator<String>iterator=list.iterator();

        while (iterator.hasNext()){
            //String str= iterator.next();
            System.out.println(iterator.next());
        }
    }
}
