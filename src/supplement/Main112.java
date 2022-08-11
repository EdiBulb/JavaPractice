package supplement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main112 {
    public static void main(String[] args) {
        //리스트 생성
        List<String> listA = new ArrayList<>();

        //리스트 값 추가
        listA.add("aaa");
        listA.add("bbb");
        listA.add(new String("ccc"));
        listA.add(1, "ddd");

        //리스트 값 출력
        System.out.println(listA);

        String element0 = listA.get(0);
        String element1 = listA.get(1);
        String element2 = listA.get(2);

        //iterator 통한 전체 조회
        Iterator<String> iterator = listA.iterator();

        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
        }

        //for - loop 를 통한 전체 조회

        for(Object object : listA){
            String element = (String) object;
            System.out.println(element);
        }

        System.out.println(listA.contains("aaa"));

        int index = listA.indexOf("aaa");
        listA.add(index,"add in front of bbb");
        System.out.println(listA);
    }
}
