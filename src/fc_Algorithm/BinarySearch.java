package fc_Algorithm;

/*이진 탐색 구현*/

/*이진 탐색이란?
* 정의 : 탐색할 자료를 둘로 나누어 해당 데이터가 있을만한 곳을 탐색하는 방법
*
* 특징 : 정렬이 되어있어야한다.
**/

import java.util.ArrayList;
import java.util.Collections;


public class BinarySearch {
    public boolean searchFunc(ArrayList<Integer>dataList, Integer searchItem){ //찾아보려는 배열과 찾을 데이터를 받는다.
        //예외 상황을 먼저 정의해줘야지 오류가 안난다.
        if(dataList.size()==1&&searchItem==dataList.get(0)){ //데이터가 1개인데, 그게 찾는 데이터일 경우
            return true;
        }
        if(dataList.size()==1&&searchItem!=dataList.get(0)){//데이터가 1개인데, 그게 찾는 데이터가 아닌 경우
            return false;
        }
        if(dataList.size()==0){ //데이터가 없는 경우
            return false;
        }

        //여기까지 왔다면 배열의 사이즈는 2 이상인 경우이다.
        int medium = dataList.size()/2;

        if(searchItem == dataList.get(medium)){//이것도 예외상황 - 반으로 쪼갠 인덱스가 찾는 데이터인 경우
            return true;
        }else{
            //실제로는 여기서부터가 이진탐색의 핵심 로직임
            if(searchItem<dataList.get(medium)){//찾는 데이터가 더 작을 때 왼쪽 부분을 탐색하도록 재귀한다.
                return this.searchFunc(new ArrayList<Integer>(dataList.subList(0,medium)),searchItem);
            }else{//찾는 데이터가 더 클 때 오른쪽 부분을 탐색하도록 재귀한다.
                return this.searchFunc(new ArrayList<>(dataList.subList(medium,dataList.size())),searchItem);
            }
        }
    }
    public static void main(String[] args) {
        //배열을 만들고
        ArrayList<Integer> testData = new ArrayList<>();

        //배열에 랜덤값을 넣는다.
        for(int index =0;index<100;index++){
            testData.add((int)(Math.random()*100));
        }
        //이진 탐색은 정렬이 되어있어야하므로 정렬시킨다.
        Collections.sort(testData);

//        System.out.println(testData); //정렬됐는지 확인

        //바이너리서치 객체 생성
        BinarySearch bSearch = new BinarySearch();

        //찾아오려는 배열과 데이터를 입력한다.
        System.out.println(bSearch.searchFunc(testData,4));
    }
}
