package baekjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class s1_bj2667_2 {

    static int N; // 지도의 크기
    static int[][] Map; //2차원 배열 지도
    static int count; //단지집의 개수
    static int[] dy = {-1, 1, 0, 0}; //y축 이동
    static int[] dx = {0, 0, -1, 1}; // x축 이동

    static ArrayList<Integer> result; // 단지 집의 수를 저장한다.

    static boolean[][] visited; //방문체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 지도의 크기 입력

        //2차원 배열 지도
        Map = new int[N][N];

        //방문 체크
        visited = new boolean[N][N];

        //지도에 값 입력하기
        for(int i=0;i<N;i++){
            String input = sc.next();
            for(int j=0;j<N;j++){
                Map[i][j] = input.charAt(j) - '0';
            }
        }

        //단지 집 개수
        count = 0; // 초기화
        result = new ArrayList<>();

        //지도 전체 탐색
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                //현재 위치 값이 1이고 true라면
                if(Map[i][j] == 1 && !visited[i][j]){
                    //맨 처음이기 때문에 count 1 증가
                    count = 1;
                    Search(i, j);
                    result.add(count);
                }
            }
        }
        //단지 개수 오름차순 하기
        Collections.sort(result);
        System.out.println(result.size()); // 단지 수 출력
        //오름차순 된 단지 출력
        for(int c: result) System.out.println(c);
    }

    public static int Search(int x, int y){
        visited[x][y] = true;

        //상하좌우 확인
        for(int i=0; i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N){
                if(Map[nx][ny] == 1 && !visited[nx][ny]){
                    Search(nx, ny);
                    count++;
                }
            }
        }
        return count;
    }

}
