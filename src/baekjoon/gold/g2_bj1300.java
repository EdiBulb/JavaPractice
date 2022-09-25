package baekjoon.gold;
/*제목 : K번째 수 */

/*문제 이해 :
* 1. N을 입력받고 N*N인 배열 A를 만든다.
* 2. 배열의 값은 i*j이다.
* 3. 이 수를 크기가 N*N인 일차원 배열 B에 넣고 오름차순 정렬한다.
* 4. 배열A,B의 인덱스는 0 이 아닌 1부터 시작한다.
* 5. k가 주어졌을 때, B[k]를 구하라라*/

/*접근법 :
* 1. 이차원 배열에 있는 수 전부를 일차원 배열 B에 넣는다.
* 2. 일차원 배열 B를 오름차순 정렬한다.
* 3. k번째 인덱스의 값을 출력한다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class g2_bj1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //N입력받기
        int N = Integer.parseInt(bf.readLine());

        //N*N 2차원 배열 A 만들기
        Integer[][] A = new Integer[N][N];

        //인덱스 1부터 시작
        A[0][0] = null;
        A[0][1] = null;
        A[1][0] = null;

        //배열 A값 넣기
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                A[i][j] = i*j;
            }
        }

        //배열 B를 생성
        Integer[] B = new Integer[N*N];

        //배열 A의 값을 배열 B에 넣기
//        문제 1 : 2차원 배열의 값을 1차원 배열에 넣고 싶은데, 어떻게 넣어야할지 모르겠다.
//        시도 1-1 : 검색해보기
//        해결책 1 : 2중 for문으로 넣기

        //test
        for(int i=0;i<A.length;i++){
            for(int j=1;j<A[i].length+1;j++){
                B[A[i].length * i + j] = A[i+1][j];
            }
        }
//        문제 3 : 인덱스가 1부터 시작하는 2차원 배열을 인덱스가 1부터 시작하는 1차원 배열로 바꾸는 것
//        시도 3 : 블로그 참조

        //문제 1 이 해결돼었다면
        //배열 B를 오름차순 정렬하기
        Arrays.sort(B);

/*
        //test
        for(int i=0;i<B.length;i++){
            System.out.println(B[i]);
        }
*/

        //k번째 인덱스의 값 출력하기
        int k = Integer.parseInt(bf.readLine());
        System.out.println(B[k+1]);

        //문제 2 : 원하는 k인덱스에 맞는 값이 안 나옴.
        //시도 2 : ...아마 i가 0부터 시작해서 그런 것 같다. 1부터 시작해야지 6 이상의 값이 나옴.



    }
}
