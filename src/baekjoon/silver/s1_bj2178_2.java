package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_bj2178_2 {
    static int[][] map;
    static int n;
    static int m;
    static boolean[][] visited;

    //질문 - 이게 왜 필요한거지?
    static int[] dx = {-1, 1, 0, 0}; // x방향 배열 - 상하
    static int[] dy = {0,0,-1,1}; // y 방향 배열 - 좌우


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        // map 배열 넣기
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(0,0);
        System.out.println(map[n-1][m-1]);

    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int now[] = q.poll();

            //현재 위치
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0;i<4;i++){
                //다음 가능 위치 파악
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY <0 || nextX>=n || nextY >=m)
                    continue;
                if(visited[nextX][nextY] || map[nextX][nextY]==0)
                    continue;

                q.add(new int[]{nextX, nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}
