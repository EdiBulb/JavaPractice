package baekjoon.silver;

/*문제 제목 : 수 찾기*/

/*문제 이해 :
* 1. N개의 정수가 주어지고 M개의 정수도 주어진다.
* 2. M개의 정수가 N개에 들어있는지 탐색을 한다.
* 3. 정수의 범위 int 이상인 듯*/

/*접근법 :
* 1. N개의 원소를 갖는 배열 생성하기
* 2. 매개값을 판단하는 메소드를 만든다. - 이진 탐색 메소드를 만든다.
* 2. M번 돌릴떄마다 메소드에 매개값을 넣어서 출력한다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//문제 2 : 탐색의 결과가 다르게 나온다.
//시도 2 : 탐색 메소드 로직을 바꿔보자

//문제 3 : 메모리초과
//시도 3 : Stringbuilder 쓰기

//문제 4 : 메모리초과
//시도 4 : 메모리 초과 이유 찾기 -> 재귀함수가 유력하다. N의 값이 꽤 컸는데, 재귀가 가능한 N의 범위와 아닌 범위를 구분하는 능력을 키워보자
//시도 4-1 : 재귀를 사용하지 않고 이진탐색을 써보자 -> s4_bj1920_1.java



public class s4_bj1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //배열의 크기
        int N = Integer.parseInt(bf.readLine());

        //배열 생성
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        //배열 값 넣기
        for(int i=0;i<N;i++){
            arr.add(Integer.valueOf(st.nextToken()));
        }

        //이진 탐색 조건 - 오른차순 정렬상태
        Collections.sort(arr);

        //M번 반복할 수 입력받기
        int M = Integer.parseInt(bf.readLine());

        //M개의 수를 가진 줄 공백자르기
        StringTokenizer st2 = new StringTokenizer(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            //메소드로 각각의 입력값이 존재하는지 확인하기
            sb.append(binarySearch(arr, Integer.valueOf(st2.nextToken()))).append("\n");
        }
        System.out.println(sb);

    }

    //메소드 - 이진 탐색
    static boolean binarySearch(ArrayList<Integer> arr, Integer searchItem){
        //찾는 값이 존재하는지 파악하고 있으면 true, 없으면 false를 리턴하면 된다.
        //arr의 크기가 1개인 경우, 그게 찾는 값인 경우
        if(arr.size()==1 && arr.get(0)==searchItem){
            return true;
        }
        //arr의 크기가 1개인 경우, 그게 찾는 값이 아닌 경우
        if(arr.size()==1&& arr.get(0)!=searchItem){
            return false;
        }
        //arr의 크기가 0개인 경우,
        if (arr.size()==0){
            return false;
        }
        //arr의 크기가 2 이상인 경우, 중간값을 찾아야한다.
        int medium = arr.size()/2;

        //배열의 중간 인덱스와 찾는값이 같은 경우
        if(searchItem == arr.get(medium)){
            return true;
        }
        else{
            //같지 않은 경우
            //찾는값이 중간값보다 작은 경우
            if(searchItem<arr.get(medium)){
                //범위를 좁힌다.
                return binarySearch(new ArrayList<Integer>(arr.subList(0,medium)),searchItem);
                //문제1 : subList를 어떻게 쓰는지 모른다.
                //해결책1 : subList는 List클래스의 메소드였다.그래서 ArrayList -> List했다.

            }
            //찾는값이 중간값보다 큰 경우
            else {
                return binarySearch(new ArrayList<Integer>(arr.subList(medium,arr.size())),searchItem);
            }

        }
    }
}
