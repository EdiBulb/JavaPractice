package baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_bj2178_3 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    //N, M
    static int N, M;

    static String[] map;//미로 지도
    static int[][] dist; // 거리를 담는 배열
    static boolean[][] visit; // 방문 체크
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        //지도 입력
        map = new String[N];
        for (int i = 0; i < N; i++)
            map[i] = scan.nextLine();


        visit = new boolean[N][M];
        dist = new int[N][M];
    }

    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void bfs(int x, int y) {

        // dist 배열을 -1로 초기화
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                dist[i][j] = -1;

        //위치 정보를 큐에 넣어준다.
        // (x, y)를 Q에 넣어주고, visit 표시와 dist 값 초기화
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        //시작점을 1로 표현한다.
        dist[x][y] = 1;
        //방문 체크
        visit[x][y] = true;

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            //현재 위치의 두 점을 뺀다.
            x = Q.poll();
            y = Q.poll();

            //갈 수 있는 방향 확인하기
            for (int k = 0; k < 4; k++) {

                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                //갈 수 있는 길인지 확인

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;  // 지도를 벗어나는 곳으로 가는가?
                if (map[nx].charAt(ny) == '0') continue;  // 갈 수 있는 칸인지 확인해야 한다.
                if (visit[nx][ny]) continue;  // 이미 방문한 적이 있는 곳인가?

                //다음 값을 넣어준다.
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1; // 다음 위치니까 거리에 1을 더해준다.
            }
        }
    }

    static void pro() {
        // 시작점이 (0, 0)인 탐색 시작
        bfs(0, 0);

        // (N-1, M-1)까지 필요한 최소 이동 횟수 출력
        System.out.println(dist[N - 1][M - 1]);
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