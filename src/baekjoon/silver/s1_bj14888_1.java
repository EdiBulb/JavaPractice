package baekjoon.silver;
/*제목 : 연산자 끼워넣기*/
/*N개의 수와 N-1개의 연산자를 입력받고 조합하여 결과의 최댓값과 최솟값을 찾는 문제*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_bj14888_1 {

    public static int MAX = Integer.MIN_VALUE;//최댓값
    public static int MIN = Integer.MAX_VALUE; //최솟값
    public static int[] operator = new int[4]; // 연산자 배열
    public static int[] number; // 피연산자 배열
    public static int N; // 숫자 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 숫자 개수
        number = new int[N]; // 숫자

        //숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        //연산자 입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<4;i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    //dfs : 현재 인덱스 숫자와 다음 인덱스 숫자를 재귀로 계산하는 함수
    public static void dfs(int num, int idx){ // num 수 계산 결과, idx 수열 인덱스
        if(idx==N){ // 모든 수열을 돌았다.
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN,num);
            return;
        }

        //모든 수열을 돌기 전,
        for(int i=0;i< 4;i++){
            //연산자 개수가 1개 이상인 경우
            if(operator[i] > 0){
                //해당 연산자 1 감소시킨다.
                operator[i]--;

                switch (i){
                    //i 인덱스에 따라서 재귀 함수 호출하기
                    case 0: dfs(num + number[idx], idx+1); break;
                    case 1: dfs(num - number[idx], idx+1); break;
                    case 2: dfs(num * number[idx], idx+1); break;
                    case 3: dfs(num / number[idx], idx+1); break;

                }

                operator[i]++ ;
            }
        }
    }
}
