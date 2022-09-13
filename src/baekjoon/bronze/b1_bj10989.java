package baekjoon.bronze;

/*제목 : 수 정렬하기 3*/

/*문제 이해 :
* 1. N개의 수가 주어지고 오름차순으로 정렬하라
* 2. N기 1천만까지가 범위다.
* 3. 주어진 시간이 5초이다.
* */

/*접근법 :
* 1. 딱봐도 일반 정렬 쓰면 시간초과 날 것 같으니... collections.sort를 써보자.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//문제 1 : 왜 제한시간을 5초를 줬지?
// 가정 1 : nlog(n)에서 n이 1천만일 경우, 5초가 커느라인인지 찾아볼 것
public class b1_bj10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); // Wrapper 클래스 사용

        ArrayList arr = new ArrayList();

        for(int i=0;i<N;i++){
            String s = bf.readLine();
            arr.add(Integer.parseInt(s));
        }
        Collections.sort(arr);

        //문제 2 : 메모리 초과가 떳음
        //가정 2 : StringBuilder를 사용해보자
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<arr.size();i++){
            sb.append(arr.get(i)).append("\n");

//            System.out.println(arr.get(i));
        }
        System.out.println(sb);
        //문제 3 : StringBuilder 를 해도 메모리초과가 떴다.
        //갖어 3 : 메모리초과가 뜨는 이유를 파악하고 다른 방법 찾아보기


    }
}
