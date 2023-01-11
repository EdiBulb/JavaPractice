package self_study;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch2 {

    public static void main(String[] args) {

        //ArrayList 생성
        ArrayList<Integer> numbers = new ArrayList<>();

        //임의의 수를 넣습니다.
        for(int idx = 0; idx<100;idx++){
            numbers.add((int)(Math.random()*100));
        }

        //정렬하기
        Collections.sort(numbers);

        //정렬된 모습 확인하기
        System.out.println(numbers);

        BinarySearch2 bs = new BinarySearch2();

        //3을 탐색하기
        System.out.println(bs.searchFunc(numbers, 3));

    }
    //찾는 자료의 여부를 판단하는 메서드
    public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem){ // 탐색 범위, 찾는 값
        if(dataList.size() == 1 && searchItem == dataList.get(0)){ // 범위 크기가 1이고 그 값이 찾는 값인 경우,
            return true; // 탐색 성공
        }
        if(dataList.size() == 1 && searchItem != dataList.get(0)){ // 범위 크기가 1이고 그 값이 아닌 경우
            return false; // 탐색 실패
        }
        if(dataList.size() == 0){
            return false; // 탐색 실패
        }
        //여기까지 예외 사항을 처리//

        int mid = dataList.size()/2; // 중간 위치

        if(searchItem == dataList.get(mid)){
            return true; //탐색 성공
        }
        else{
            if(searchItem < dataList.get(mid)){ // 찾는값이 중간보다 작다면
                return this.searchFunc(new ArrayList<Integer>(dataList.subList(0,mid)), searchItem);
            } else {//찾는 값이 중간보다 크다면
                return this.searchFunc(new ArrayList<>(dataList.subList(mid, dataList.size())), searchItem);
            }
        }
    }
}
