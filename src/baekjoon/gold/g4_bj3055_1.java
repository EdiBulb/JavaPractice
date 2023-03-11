package baekjoon.gold;
//탈출//

//고슴도치가 탈출할 수 있는 최소 시간을 구하라
//S 고슴도치 위치
//* 물의 위치 - 상하좌우로 이동
//. 빈칸
//D 탈출구 위치
//X 돌의 위치

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//고슴도치가 물보다 먼저 도착하는가?
//각 칸이 물이 언제 잠기는지를 먼저 파악하기 distwater[][] - 물에서 시작하는 BFS를 하자
//문제점 - 시작점이 여러 개다.
//두번쨰 - 고슴도치가 물을 피해서 도망치는 최소시간
//즉, 2번의 BFS를 사용한다.
//멀티소스 BFS
public class g4_bj3055_1 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M; // 행, 열
    static String[] a;
    static int[][] dist_water, dist_hedgehog; // 물 이동 최단거리, 고슴도치 이동 최단거리
    static boolean[][] visit; // 방문 여부
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = scan.nextLine();
        visit = new boolean[N][M];
        dist_water = new int[N][M];
        dist_hedgehog = new int[N][M];
    }

    // 모든 물들을 시작으로 동시에 BFS 시작!
    static void bfs_water() {
        Queue<Integer> Q = new LinkedList<>();
        // 모든 물의 위치를 Q에 전부 넣어주기!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //초기화
                dist_water[i][j] = -1;
                visit[i][j] = false;
                //물 위치 큐에 추가
                if (a[i].charAt(j) == '*') {
                    Q.add(i);
                    Q.add(j);
                    dist_water[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            //현재 물 위치
            int x = Q.poll();
            int y = Q.poll();
            for (int k = 0; k < 4; k++) {
                //다음 물의 위치 구하기
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;  // 지도를 벗어나는 곳으로 가는가?
                if (a[nx].charAt(ny) != '.') continue;  // 갈 수 있는 칸인지 확인해야 한다.
                if (visit[nx][ny]) continue;  // 이미 방문한 적이 있는 곳인가?
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist_water[nx][ny] = dist_water[x][y] + 1;
            }
        }
    }

    // 고슴도치를 시작으로 동시에 BFS 시작!
    static void bfs_hedgehog() {
        Queue<Integer> Q = new LinkedList<>();
        // 고슴도치 위치를 Q에 넣어주기!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist_hedgehog[i][j] = -1;
                visit[i][j] = false;
                //고슴도치 현재 위치
                if (a[i].charAt(j) == 'S') {
                    Q.add(i);
                    Q.add(j);
                    dist_hedgehog[i][j] = 0; // 현재 거리 0
                    visit[i][j] = true;
                }
            }
        }

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            //고슴도치 현재 위치
            int x = Q.poll();
            int y = Q.poll();
            //고슴도치 다음 위치
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;  // 지도를 벗어나는 곳으로 가는가?
                if (a[nx].charAt(ny) != '.' && a[nx].charAt(ny) != 'D') continue;  // 갈 수 있는 칸인지 확인해야 한다.
                if (dist_water[nx][ny] != -1 && dist_water[nx][ny] <= dist_hedgehog[x][y] + 1) continue;  // 물에 잠기지는 않는가?
                if (visit[nx][ny]) continue;  // 이미 방문한 적이 있는 곳인가?
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist_hedgehog[nx][ny] = dist_hedgehog[x][y] + 1;
            }
        }
    }

    static void pro() {
        // 각 칸마다 물에 닿는 시간 계산하기
        bfs_water();

        // 고슴도치가 물을 피해 탐색할 수 있는 공간 찾기
        bfs_hedgehog();

        // 탈출구 'D' 에 대한 결과를 통해 정답 출력하기
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (a[i].charAt(j) == 'D'){
                    if (dist_hedgehog[i][j] == -1) System.out.println("KAKTUS");
                    else System.out.println(dist_hedgehog[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}