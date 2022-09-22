package supplement.chap18;

import java.util.ArrayList;
import java.util.Collections;

//이진탐색 클래스
public class BinarySearch2 {

    public static void main(String[] args) {
        //배열 생성
        ArrayList<Integer> testData = new ArrayList<Integer>();

//배열에 임의값 넣기
        for (int index = 0; index < 100; index++) {
            testData.add((int) (Math.random() * 100));
        }
//오름차순 정렬하기 - 이진 탐색의 조건!
        Collections.sort(testData);
//정렬 확인하기
        System.out.println(testData);

//이진탐색 클래스로 객체 생성하기
        BinarySearch2 bSearch = new BinarySearch2();

//이진 탐색하기
        System.out.println(bSearch.searchFunc(testData, 2));



    }


    //배열과 찾을값을 받아서 존재유무를 알려주는 탐색 메서드
    public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        //예외 사항을 앞부분에서 정리를 해주면 편합니다.

        //배열의 크기가 1이고 그 값이 찾는값일 때
        if (dataList.size() == 1 && searchItem == dataList.get(0)) {
            return true;//존재함
        }
        //배열의 크기가 1이지만 찾는 값이 아닐 때
        if (dataList.size() == 1 && searchItem != dataList.get(0)) {
            return false;
        }
        //배열의 크기가 0일 때
        if (dataList.size() == 0) {
            return false;
        }

        //배열의 크기가 2이상인 경우
        int medium = dataList.size() / 2; //배열의 중간 인덱스 구하기
        //배열의 중간 인덱스와 찾는값을 비교
        if (searchItem == dataList.get(medium)) {
            return true;
        } else {//아닐 시, 중간값과 크기 비교
            if (searchItem < dataList.get(medium)) {//작을시,매개변수 범위 바꿔서 재귀 호출
                return this.searchFunc(new ArrayList<Integer>(dataList.subList(0, medium)), searchItem);
            } else {//클시, 매개변수 범위 바꿔서 재귀 호출
                return this.searchFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())), searchItem);
            }
        }
    }
}