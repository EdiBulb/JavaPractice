package supplement;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();

        //값 추가
        ll.add("hello");
        ll.add("world");
        ll.add("hello");
        ll.add("world");

//        for(int i=0;i<ll.size();i++){
//            System.out.println(ll.get(i)+" ");
//        }
//
//        for(String str : ll){
//            System.out.println(str + " ");
//        }
//
//        Iterator iter= ll.iterator();
//        while (iter.hasNext()){
//            System.out.println(iter.next()+" ");
//        }

        System.out.println("값 검색(contains) : "+ ll.contains("Hello"));
        System.out.println("값 검색(indexOf) : "+ll.indexOf("Hello"));
    }
}
