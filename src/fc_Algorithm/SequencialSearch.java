package fc_Algorithm;
/*순차 탐색 알고리즘*/

import java.util.ArrayList;

public class SequencialSearch {

    //순차 탐색 메소드를 만든다.
    public int searchFunc(ArrayList<Integer>dataList,Integer searchItem){ //탐색할 배열과 찾을 값을 매개변수로 갖는다.
        for(int index =0;index<dataList.size();index++){//인덱스 0부터 size까지 확인한다.
            if(dataList.get(index)==searchItem){//찾을 값과 같은지 확인한다.
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SequencialSearch test = new SequencialSearch();

        ArrayList testData = new ArrayList();

        for(int i=0;i<10;i++){
            testData.add((int)(Math.random()*100));
        }


        System.out.println(test.searchFunc(testData,19));

    }
}
