package baekjoon.silver;

/*제목 : DFS와 BFS*/

/*블로그 풀이 연구*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class s2_bj1260_2 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;//방문 여부를 확인하는 배열
    static int[][] arr; //간선 확인을 위한 2차원 배열

    static int node, line, start;//노드 수, 간선 수, 시작 정점

    static Queue<Integer> q = new LinkedList<>();//BFS에 사용할 큐


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력받기 - 노드 수, 간선 수, 시작 정점
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start= Integer.parseInt(st.nextToken());

        //노드 수와 배열 인덱스를 맞춘다.
        arr = new int[node+1][node+1];
        //노드 수와 배열 인덱스 맞춘다.
        check = new boolean[node+1];

        //간선수 만큼 반복하면서 간선 확인
        for(int i = 0 ; i < line ; i ++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            //노드 a와 b 연결 상태를 1로 표현
            arr[a][b] = arr[b][a] =  1;
        }
        //여기까지 했으면 모든 연결이 되었다.


        //sb.append("\n");

        //dfs 메소드 실행
        dfs(start);
        sb.append("\n");

        //check 배열 초기화
        check = new boolean[node+1];

        //bfs 메소드 실행
        bfs(start);

        //출력
        System.out.println(sb);

    }
    public static void dfs(int start) {//시작 노드

        //시작노드 방문
        check[start] = true;

        sb.append(start + " ");

        //반복해서 방문 확인
        for(int i = 1 ; i <= node ; i++) {
            //i인덱스의 값이 1이고 방문이 안됐으면 재귀로 방문하기
            if(arr[start][i] == 1 && !check[i])
                dfs(i);
        }

    }

    public static void bfs(int start) {
        //큐에 시작 노드 넣기
        q.add(start);
        //시작 노드 방문 체크하기
        check[start] = true;

        //큐에 더 이상 방문할 노드가 없을 때까지
        while(!q.isEmpty()) {
            //큐에 처음 삽입한 노드 뺴고
            start = q.poll();
            sb.append(start + " ");


            for(int i = 1 ; i <= node ; i++) {
                //뺀 노드 start와 연결되고 방문이 안된 노드들을 큐에 넣어준다.
                if(arr[start][i] == 1 && !check[i]) {
                    //큐에 넣어주기
                    q.add(i);
                    //
                    check[i] = true;
                }
            }
        }


    }
}