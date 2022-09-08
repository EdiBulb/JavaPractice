package baekjoon.silver;
/*제목 : 나이순 정렬*/

/*문제 이해 :
 * 1. 가입한 순서대로 입력이 주어진다.2
 * 2. 나이가 오름차순이고, 같다면 먼저 온 순서대로 정렬하는 프로그램*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*접근법
 * - Arrays.sort 관련 문제인 것 같다.
 * - 입력된 값이 공백을 가지지만 세트로 움직여야할 것 같다.
 * - 짝수 인덱스에 숫자가 들어가고 홀수에 문자열이 들어간다.
 * 1. 우선 다 배열에 넣는다.
 * 2. */
public class s5_bj10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        /*접근법이었던 것 - 1*/
//        int[] arrInt = new int[N];
//        String[] arrString = new String[N];
//
//        //배열에 넣는다.
//        for (int i = 0; i < N; i++) {//i가 2씩 증가한다.
//            //공백 제거한다.
//            StringTokenizer st = new StringTokenizer(bf.readLine());
//
//            //정수를 배열에 넣는다.
//            arrInt[i] = Integer.parseInt(st.nextToken());
//            //문자열을 배열에 넣는다.
//            arrString[i] = st.nextToken();
//        }
//
//        //test
//        //ARrays.sort 메서드를 오버라이드해서 가입순으로 배열하는 방법을 찾아보자
//        Arrays.sort(arrInt);
//        Arrays.sort(arrString);

        //문제 1 : 배열 2개를 쓰는 것은 복잡한 것 같다.
        //문제 2 : 배열 1개를 쓴다면..숫자와 문자열이 한 쌍이 되어서 움직여야하는데..

        //해결책 : 입력 한 줄을 다 배열에 넣고, 그 중에서 숫자 부분만 추출해서 비교해서 재정렬한다면, 들어온 입력순서를 고려할 필요가 없지않을까?
        String[] arrString = new String[N];
        for(int i=0;i<N;i++){
            //배열에 쌍으로 넣는다.
            arrString[i] = bf.readLine();
        }

        //배열 값의 nexttoken끼리 비교해서 크다면 아프로 작다면 뒤로?
        Arrays.sort(arrString);

        for(int i=0; i<arrString.length;i++){
            StringTokenizer st = new StringTokenizer(arrString[i]);
            Integer.parseInt(st.nextToken());
        }
        //문제 2 : arrays.sort를 통해 어떻게 정수 부분을 정렬할 때 문자열도 정렬되게 할 것인가?


    }
}
