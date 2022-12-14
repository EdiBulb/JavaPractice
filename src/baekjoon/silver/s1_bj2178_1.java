package baekjoon.silver;

/*제목 : 미로 탐색*/

/*블로그 풀이 연구*/
/*접근법 :
* 1. N*M 미로를 2차원 배열로 연결상태를 만든다.
* 2. 각 좌표에서 1,1과의 거리를 저장하는 2차원 배열을 만들고 -1로 초기화 시킨다.
* 3. 현재 좌표의 위치를 저장하는 type을 가지는 queue를 만든다.
* 4. 현재 좌표에서 이동 가능한 다음좌표를 구한다.
* 5. 이동한 다음 좌표를 큐에 넣어주고 이동한 거리를 +1해준다.
* 6. 마지막 좌표를 위치로 갖는 거리 배열의 값을 출력한다.
*/

import java.util.*;
import java.io.*;
import java.util.Queue;

public class s1_bj2178_1 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        //N*M 입력받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] miro = new char[N][M];  // 미로를 저장할 배열
        int[][] dist = new int[N][M];    // 거리를 계산할 dist 배열


        int[] dx = {1, 0 , -1, 0};       // 상하좌우 계산할 x좌표
        int[] dy = {0, 1, 0, -1};        // 상하좌우 계산할 y좌표

        Queue<Pair> qu = new LinkedList<>(); // Pair 타입인 현재 좌표를 넣는 큐

        //miro 배열에 값 저장하기 및 거리 배열 초기화 시키기
        for(int i=0; i<N; i++){
            String line = bf.readLine();
            for(int j=0; j<M; j++){
                miro[i][j] = line.charAt(j);
                dist[i][j] = -1;    // 거리를 -1로 세팅하면, 방문여부를 확인가능.
            }
        }

        //큐에 시작점 넣기
        qu.offer(new Pair(0,0));  // 시작점
        dist[0][0] = 0;   // 첫 시작이니까 거리가 0이다.

        //큐가 비어있을 때까지 반복해서 좌표 이동
        while(!qu.isEmpty()){
            //현재 좌표 받아오기
            Pair p = qu.poll();

            // 현재좌표에 상, 하, 좌, 우를 계산해서 다음 좌표를 구한다.
            for(int i=0; i<4; i++){
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                // 벽에 부딪히거나, 범위를 넘어가면 PASS
                if(nX < 0 || nX >= N || nY < 0 || nY >= M){
                    continue;
                }
                // 길이 아니거나, 방문을 했다면 PASS
                if(miro[nX][nY] == '0' || dist[nX][nY] != -1){
                    continue;
                }

                // 큐에 이동할할 좌표를 넣어다.
                qu.offer(new Pair(nX, nY));
                // 한칸 이동하였기 때문에, 이전 출발지점의 거리 +1을 해준다.
                dist[nX][nY] = dist[p.x][p.y] + 1;
            }
        }

        // 마지막 지점의 (거리 + 1)를 출력해주면 된다.
        System.out.print(dist[N-1][M-1] + 1);
    }

    // 큐에 좌표를 넣어주기 위한 클래스
    public static class Pair{
        int x, y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public void setX(int x){
            this.x = x;
        }
        public void setY(int y){
            this.y = y;
        }
    }
}
