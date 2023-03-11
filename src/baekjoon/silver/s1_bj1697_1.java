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
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_bj1697_1 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K; // 수빈, 동생 위치
    static int[] dist; // 각 위치별 거리 배열
    static boolean[] visit; // 방문 체크 배열

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        visit = new boolean[100005];
        dist = new int[100005];
    }

    // 숨바꼭질 시작~
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        //수빈 위치에서 시작
        Q.add(N);
        visit[N] = true; // 방문체크
        dist[N] = 0; // N까지의 거리 0

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            int x = Q.poll();
            //x-1 간선이고, 범위 벗어나지 않고, 방문 x
            if (x - 1 >= 0 && !visit[x - 1]) {
                visit[x - 1] = true;
                dist[x - 1] = dist[x] + 1;
                Q.add(x - 1);
            }
            //x+1 간선이고, 범위 벗어나지 않고, 방문 x
            if (x + 1 <= 100000 && !visit[x + 1]) {
                visit[x + 1] = true;
                dist[x + 1] = dist[x] + 1;
                Q.add(x + 1);
            }
            //x*2 간선이고, 범위 벗어나지 않고, 방문 x
            if (x * 2 <= 100000 && !visit[x * 2]) {
                visit[x * 2] = true;
                dist[x * 2] = dist[x] + 1;
                Q.add(x * 2);
            }
        }
    }

    static void pro() {
        bfs();
        System.out.println(dist[K]);
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