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


        //시도 2 : 해시 맵에 데이터를 넣을 때, 배열 생성이 중복되어서 값 갱신이 안됨 따라서 switch 문으로 case에 해당하면 배열에 값을 넣어 놓자


        //간선의 개수만큼 반복한다.
        for(int i=0;i<M;i++){
            String s2 = bf.readLine();
            StringTokenizer st2 = new StringTokenizer(s2);

            //문제 1 : 해시맵에 데이터를 넣을 때, arrayList에 데이터를 넣는 방법이 막힘
            //해결책 1 : 다른 방법 찾아보기기
//           graph.put(st2.nextToken(),graph.values().add(st2.nextToken()))

        }
        System.out.println(graph);
    }
}