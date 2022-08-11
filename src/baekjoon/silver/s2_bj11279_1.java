package baekjoon.silver;
/*백준  : 최대 힙 */
/*블로그 다른 풀이임*/

/*접근 방법
*
* 힙 직접 구현 x -> PriorityQueue 를 사용한다. - 하지만 우선순위 큐가 힙을 통해 구현된 것이다.
* PriorityQueue는 기본적으로 오름차순이기 때문에 내림차순으로 변경해준다.
* 출력할 때 size =0 이라면 배열이 비어있는 경우이다.
* 문제에서 범위가 연산의 개수가 쵇 100,000개이다. 이럴 경우 Scanner는 느리기 때문에 BufferedReader를 사용한다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class s2_bj11279_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /*우선순위 큐를 사용했고, 그것을 역순으로 배치시키기로 했다.*/
        //값을 넣지도 않았는데, 역순이 가능한가? -> 가능하다.
        //큐가 아닌 우선순위큐를 사용하고 reverse를 한 이유는 가장 첫번째 값이 가장 큰값이어야 하기 때문이다.
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        //문자열 객체를 만들었다. - 출력값을 넣을 문자열 객체다.
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<N;i++){
            //입력값을 받고
            int num = Integer.parseInt(br.readLine());
            //입력값이 0인 경우과 0이 아닌 경우(자연수)를 나눴다.
              if(num ==0){
                //입력값이 0인 경우 ->
                // 1. 배열이 비었을 때 0을 sb에 추가,
                // 2. 배열이 차있을 때 poll을 해서 맨 앞의 갚을 sb에 추가.
                // 그리고 뛰어쓰기 한다.
                sb.append(queue.size() == 0?0:queue.poll()).append('\n');
                //입력갑싱 0이 아닌 경우, 큐에 넣는다.
            }else queue.add(num);
        }
        //객체를 출력한다.
        System.out.println(sb.toString());

    }
}


