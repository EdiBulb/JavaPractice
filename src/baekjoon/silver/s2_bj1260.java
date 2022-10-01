package baekjoon.silver;

/*제목 : DFS와 BFS*/

/*문제 이해 : 
* 1. 그래프를 DFS 탐색 결과, BFS 탐색 결과 출력하기
* 2. 정점 번호가 작은것부터 탐색
* 3. 정점 번호 1~N번까지
* 4. N : 정점 개수, M : 간선 개수, V : 시작 정점 번호*/

/*접근법 :
* 1. 정점 개수 N, 간선 개수 M, 시작 점 V 입력받기
* 2. M번 반복해서 입력받으면서 그래프 만들기
* 3. 그래프의 시작점에서 DFS와 BFS를 수행하는 메소드 만들기*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class s2_bj1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //첫째줄 입력받기
        String s =  bf.readLine();

        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        ////그래프에 값 넣기////
        //빈 그래프 만들기
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

//      문제 1 : 미리 해시를 만들어 놓고 add하는 방향으로 가보는 건 어떨까?
        //미리 선언해 놓기
        for(int i=1;i<=N;i++){
            graph.put(i,null);
        }

        //간선의 개수만큼 반복한다.
        for(int i=0;i<M;i++){
            String s2 = bf.readLine();
            StringTokenizer st2 = new StringTokenizer(s2);

            //시도 1 : 키 값에 접근해서 그 키값의 배열에 접근하는 방법
            graph.put(Integer.valueOf(st2.nextToken()),new ArrayList<>(Integer.parseInt(st2.nextToken())));
        }
        System.out.println(graph);
    }
}