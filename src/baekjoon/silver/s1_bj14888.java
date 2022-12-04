package baekjoon.silver;
/*제목 : 연산자 끼워넣기*/

/*문제 이해 :
* N개로 이루어진 수열 - 수열은 움직이지 않는다.
* N-1개의 연산자 - 연산자는 + - * / 이다.
* 연산자 우선순위 무시한다.
* 최대값, 최소값 출력하기*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*접근법 :
* 1. N입력받기 -int
* 1-1. N개의 수 입력받기 - int[]
* 2. 연산자 입력받기 - int[]
* 3. max 변수, min 변수 - int
* 4. 계산하기 - 연산자가 수열 사이사이에 들어가야하는데, 어떻게 들어가지?
* 4. 질문 : 연산자를 어떻게 수열 사이에 끼워넣지?
* */
public class s1_bj14888 {

    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N입력받기
        int N = Integer.parseInt(br.readLine());

        //수열 입력받기
        int[] A = new int[N]; // 수열
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        for(int i=0;i<A.length;i++){
            A[i] = Integer.parseInt(st.nextToken());
//            System.out.println(A[i]);
        }

        //연산자 입력받기
        int[] operators = new int[4]; // 덧셈, 뺄셈, 곱셈, 나눗셈
        String s2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(s2);
        for(int i=0;i<operators.length;i++){
            operators[i] = Integer.parseInt(st2.nextToken());
//            System.out.println(operators[i]);
        }

        //
    }
}
