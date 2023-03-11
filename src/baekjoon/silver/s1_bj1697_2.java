package baekjoon.silver;
//숨바꼭질//
//수빈이가 동생을 찾는 가장 빠른 시간을 구하라
//수빈 N, 동생 K
//N-1, N+1, N*2 위치 이동 가능
//정답의 최대치 : 언제 가장 오래 걸릴까?
//N>K라면 갈 수 있는 방ㅂ버이 1씩 감소할 뿐이다. 따라서 N=10만, K=0인 경우 10만초
//가장 빠른 시간 -> BFS
//그래프가 주어지지 않았다. -> 정점과 간선을 정의하기
//동생은 고정, 수빈이의 상태가 정점, 간선은 이동을 의미하는 것이 간선이다. -1, +1, *2 가 간선이다.
//새로 만든 그래프는 정점이 10만개고, 간선이 30만개다.

//느낀점 : 수빈이의 상태로 그래프를 만들 수 있는 생각을 배웠다. - 간선을 만드는 발상을 배웠다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class s1_bj1697_2 {
    static int N; // 수빈 위치
    static int K; // 동생 위치
    static int visited[] = new int[10001]; // 방문체크 및 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputs = input.split(" ");

        N = Integer.valueOf(inputs[0]);
        K = Integer.valueOf(inputs[1]);

        int result = bfs(N);
        System.out.println(result);
    }

    private static int bfs(int node){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node); // 시작 위치 넣기
        int index = node;
        int n = 0;
        visited[index] = 1;
        while (queue.isEmpty() == false){
            n = queue.remove();

            //동생 찾았으면
            if(n==K)
                return visited[n]-1;

            //n-1 간선, 방문 x
            if(n-1>=0 && visited[n-1] ==0){
                visited[n-1] = visited[n]+1;
                queue.add(n-1);
            }

            //n+1 간선, 방문 x
            if(n+1<=100000 && visited[n+1]==0){
                visited[n+1] = visited[n]+1;
                queue.add(n+1);
            }
            //2*n 간선, 방문 x
            if(2*n <=100000&& visited[2*n] ==0){
                visited[2*n] = visited[n] +1;
                queue.add(2*n);
            }
        }
        return -1;
    }
}