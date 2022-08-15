package baekjoon.silver;
/*내 풀이*/

/*N번째 큰 수*/
/*문제
* N을 입력받으면 N*N의 개의 수를 입력받고
* 이 수 중에서 N번째로 큰 수를 찾는 프로그램이다
* 조건은 밑에 줄이 위에줄 보다 값이 크다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*접근법
* 1. N을 입력받는다.
* 2. 우선순위 큐를 만든다.
* 3. N*N 개의 데이터를 입력 받아서 우선순위 큐에 넣는다.
* 4. N번째 큰 수를 출력한다.*/

public class s2_bj2075 {
    public static void main(String[] args) throws IOException {
        //1. BufferedReader를 통해서 N을 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //2. 우선순위 큐를 만든다. - 큰값부터 내림차순으로
        PriorityQueue<Integer> myque = new PriorityQueue<>(Collections.reverseOrder());

        //3. N*N개의 데이터를 입력 받아서 우선순위큐에 넣는다.
        for(int i =0;i<N;i++){
            //한줄을 입력받고
            String s = br.readLine();
            //공백 단위로 빼준다.
            StringTokenizer st = new StringTokenizer(s);
            for(int j = 0;j<N;j++){
                int num1 = Integer.parseInt(st.nextToken());
                myque.add(num1);
            }
        }

        //4. N번째 큰수를 출력한다. -> N-1번 poll()을 해주면 마지막에 N번째 큰 수를 출력할 수 있다.

//        for(int i = 0; i<N-1;i++){
////            myque.remove(1);
//            //우선순위큐에서 remove()를 할때는 안에 파라미터를 넣지 않는다.
//            //넣으면 다른 값이 온다.
////            myque.remove();
//            System.out.println(myque.poll());
//            /*여기서 질문
//            * sout(myque) 를 했을 때는 내림차순으로 정렬되어 출력이 되지 않는데,
//            * 왜 poll()로 출력을 해보면 내림차순 출력이 되는 것일까?*/
//        }
//        System.out.println(myque.poll());

        //test용
        System.out.println(myque); //왜 우선순위 큐의 정렬이 안되지?


    }
}
