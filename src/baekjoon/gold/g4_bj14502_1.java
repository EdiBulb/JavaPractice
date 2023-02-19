package baekjoon.gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class dot {
    int y,x; // y축, x축

    public dot(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class g4_bj14502_1 {
    // BOJ / 14502번 / 연구소 / 그래프 / 골드5

    static int y,x, ans; // 지도의 크기, 안전영역 크기
    static int map[][], copy[][]; // 지도, 지도 카피
    static int dy[] = {1,-1,0,0};
    static int dx[] = {0,0,-1,1};
    static Queue<dot> q;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //지도의 크기
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        //지도, 카피 생성
        map = new int[y][x];
        copy = new int [y][x];

        q = new LinkedList<>();

        //지도 채우기
        for(int i=0; i<y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //벽 세우기
        makeWall(0,0);

        //안전영역 크기 출력
        System.out.println(ans);
    }

    // 재귀 호출을 통하여 벽을 3개 세운다. map 배열을 통해 탐색하고 바이러스는 copy 배열로 퍼트린다.
    public static void makeWall(int start, int depth) {
        // 벽의 개수가 3개라면
        if(depth == 3) {
            //카피하고
            copy();
            //바이러스 전파
            spreadVirus();
            //안전영역 최대값
            ans = Math.max(ans, countSafe());
            return;
        }

        // 2차원 배열 1차원 배열로 변환. - 왜?
        for(int i=start; i< y * x; i++) {
            int dy = i / x;
            int dx = i % x;
            if(map[dy][dx] == 2 || map[dy][dx] == 1) continue;

            map[dy][dx] = 1;
            makeWall(i+1,depth+1);
            map[dy][dx] = 0;
        }
    }

    // bfs로 바이러스틑 퍼트립니다.
    public static void spreadVirus() {
        while(!q.isEmpty()) {
            dot now = q.poll();
            for(int i=0; i<4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(ny >=0 && ny <y && nx <x && nx>=0) {
                    if(copy[ny][nx] == 0) {
                        copy[ny][nx] = 2;
                        q.offer(new dot(ny,nx));
                    }
                }
            }
        }
    }

    // 안전지대 갯수를 세줍니다.
    public static int countSafe() {
        int count = 0;
        for(int i=0; i<y; i++) {
            for(int j=0; j<x; j++) {
                if(copy[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // map 배열을 copy배열에 복사합니다.
    public static void copy() {
        for(int i=0; i<y; i++) {
            for(int j=0; j<x; j++) {
                copy[i][j] = map[i][j];
                // 복사와 동시에 q에 바이러스 위치를 집어넣습니다.
                if(copy[i][j] == 2) q.offer(new dot(i,j));
            }
        }
    }
}