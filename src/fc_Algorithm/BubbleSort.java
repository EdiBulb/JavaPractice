package fc_Algorithm;
/*버블 정렬 강의 정리*/

/*그 전에, 정렬을 알고리즘으로 가장 먼저 다루는 이유
 * 1. 다양한 정렬 알고리즘을 통해, 동일한 문제에 대해 다양한 알고리즘이 고안될 수 있음을 이해한다.
 * 2. (같은 기능을 하지만)각 알고리즘간 성능 비교를 통해, 알고리즘 성능 분석에 대해 이해한다.*/

import java.util.ArrayList;
import java.util.Collections;

/*버블 정렬*/
/*두 인접한 데이터를 비교해서,
앞에 있는 데이터가 뒤에 있는 데이터보다 크면,
자리를 바꾸는 정렬 알고리즘이다.*/
public class BubbleSort {
    //    public ArrayList<Integer> sort = new ArrayList<>();
    /*sort 메소드 - "정렬이 안된 리스트"를 받아서 "정렬된 리스트"로 리턴하는 메소드*/
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        /*데이터의 개수가 N개라면 N-1번 사이클을 돈다.*/
        for (int index = 0; index < dataList.size() - 1; index++) {
            //swap이 됐는지 체크하기 위해서
            boolean swap = false;
            //인접한 데이터를 비교한다.
            for (int index2 = 0; index2 < dataList.size() - 1 - index; index2++) {

                if (dataList.get(index2)>dataList.get(index2+1)){
                    Collections.swap(dataList, index2, index2 + 1);
                    swap = true;
                }
            }
            //swap이 안됐으면 다 정렬된 것이므로 반복문을 나간다.
            if (swap == false) {
                break;
            }
        }
        //정렬된 리스트를 리턴한다.
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer>testData=new ArrayList<>();
        //임의의 값을 리스트에 넣어준다.
        for(int i =0;i<100;i++){
            testData.add((int)(Math.random()*100));
        }
        //버블 정렬 객체를 만들어준다.
        BubbleSort bSort = new BubbleSort();

        //버블 정렬을 실시한다.
        System.out.println(bSort.sort(testData));
    }

}
