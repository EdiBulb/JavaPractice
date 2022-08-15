package fc_Algorithm;
/*선택 정렬 강의 정리

* 다음과 같은 순서를 반복하며 정렬하는 알고리즘이다.
* 1. 주어진 데이터 중, "최소값"을 찾는다.
* 2. 해당 최소값을 데이터 맨 앞에 위치한 값과 교체한다.
* 3. 맨 앞의 위치를 뺀 나머지 데이터를 동일한 방법으로 반복한다.*/

import java.util.ArrayList;
import java.util.Collections;

/*선택 정렬 구현*/

public class SelectionSort {
    /*method*/
    public ArrayList<Integer> sort(ArrayList<Integer>dataList){
        //가장 작은 값을 저장하기 위한 변수
        int lowest;
        //N개의 데이터에서, N-1번 사이클을 돌기위해서 stand 변수
        for (int stand = 0;stand<dataList.size()-1;stand++){
            //최초에는 인덱스 0인 수를 lowest로 가정한다.
            lowest=stand;
            //다음 것부터 비교를 한다.
            for(int index = stand+1;index<dataList.size();index++){
                if (dataList.get(lowest)>dataList.get(index)){
                    lowest=index;//가장 작은 값을 찾는다.
                }
            }
            //가장 작은 값과 stand를 swap한다.
            Collections.swap(dataList,lowest,stand);
        }
        return dataList;
    }

    public static void main(String[] args) {
        //정렬되지 않은 리스트를 만든다.
        ArrayList<Integer> testData = new ArrayList<>();
        //랜덤값을 넣는다.
        for(int i =0;i<100;i++){
            testData.add((int)(Math.random()*100));
        }
        //선택 정렬을 객체를 만든다.
        SelectionSort sSort= new SelectionSort();
        //정렬시킨다.
        System.out.println(sSort.sort(testData));

    }
}
