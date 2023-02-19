package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class g5_bj2551_2 {

    public static class Bucket {
        int A, B;

        public Bucket(int a, int b) {
            A = a;
            B = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //물통 A,B,C 배열 생성
        int[] volume = new int[3]; // A,B,C
        StringTokenizer st = new StringTokenizer(br.readLine());

        //물통 용량 입력 받기
       for (int i = 0; i < 3; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }

        // A가 비어 있을 때, 가질 수 있는 C 물통의 물양을 index로 설정
        boolean[] answer = new boolean[volume[2] + 1];
        // 초기 물통 C가 가지는 물양 먼저 넣어주기
        answer[volume[2]] = true;

        // C -> A, C -> B, B -> A, B -> C, A -> B, A -> C
        int[] from = {0, 0, 1, 1, 2, 2};
        int[] to = {1, 2, 0, 2, 0, 1};

        //A,B가 가질 수 있는 물의 양을 queue에 넣기
        Queue<Bucket> queue = new LinkedList<>();

        // A, B 물의 값 방문 여부를 체크한다.
        boolean[][] visit = new boolean[volume[0] + 1][volume[1] + 1];

        // 처음 A, B는 비어 있다.
        queue.add(new Bucket(0, 0));
        visit[0][0] = true; // 방문 체크

        //큐가 비어있을 때까지 반복한다.
        while (!queue.isEmpty()) {
            //큐에서 하나를 꺼내고
            Bucket cur = queue.poll();
            //A,B,c를 구한다.
            int A = cur.A, B = cur.B;
            int C = volume[2] - A - B;


            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C}; // 옮긴 뒤의 용량

                next[to[k]] += next[from[k]]; // 물 옮기기
                //from 비워주기
                next[from[k]] = 0;

                // 용량이 초과된다면
                if (next[to[k]] > volume[to[k]]) {
                    // 옮겨 온 곳으로 초과한 만큼 넣어준다
                    next[from[k]] = next[to[k]] - volume[to[k]];
                    next[to[k]] = volume[to[k]];
                }

                //A,B를 방문하지 않았다면
                if (!visit[next[0]][next[1]]) {
                    //방문 체크 해준다.
                    visit[next[0]][next[1]] = true;
                    queue.add(new Bucket(next[0], next[1]));

                    if (next[0] == 0) { // A가 빈 경우
                        answer[next[2]] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        //C물통의 용량까지 반복한다.
        for (int i = 0; i <= volume[2]; i++) {
            //C물통에 들어갈 수 있는 i양이 true면 출력한다.
            if (answer[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}