package fc_Algorithm;
/*삽입 정렬 강의 정리*/
/*삽입 정렬이란?
 * 삽입 정렬은 두 번째 인덱스부터 시작한다.
 * 해당 인덱스(Key 값) 앞에 있는 데이터(B)부터 비교해서 key값이 더 작으면, B값을 뒤 인덱스로 복사한다.
 * 이를 key값이 더 큰 데이터를 만날때까지 반복, 그리고 큰 데이터를 만난 위치 바로 뒤에 key값을 이동한다.*/

/*삽입 정렬 구현*/

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int index = 0; index < dataList.size() - 1; index++) {
            for (int index2 = index + 1; index2 > 0; index2--) {
                if (dataList.get(index2) < dataList.get(index2 - 1)) {
                    Collections.swap(dataList, index2, index2 - 1);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData= new ArrayList<>();

        for (int index = 0;index<100;index++){
            testData.add((int)(Math.random()*100));
        }
        InsertionSort iSort = new InsertionSort();
        System.out.println(iSort.sort(testData));
    }
}
