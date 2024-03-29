package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bottle{
    int a;
    int b;
    int c;
    Bottle(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
public class g5_bj2251_1 {
    static BufferedReader br = null;
    static StringTokenizer st = null;

    static int[] mBottle; // 물통의 용량 - mBottle[0]은 A, mBottle[1]은 B, mBottle[2]은 C
    static boolean[][][] check = null; // [A][B][C]
    static ArrayList<Integer> ans = null;
    static Queue<Bottle> que = null;

    public static void pourWater(int from, int to, int[]pBotte){ // from은 반드시 이어있지 않아야한다.
        //from, to는 pBottle의 인덱스다.
        //pBottle = {a,b,c}
        int[] temp = {pBotte[0], pBotte[1], pBotte[2]};

        if(temp[from] + temp[to] <= mBottle[to]){ // from의 물을 다 붓는 경우
            temp[to]+=temp[from];
            temp[from] = 0;
        }else{ // to가 꽉 찰때까지만 붓는 경우
            temp[from] -= mBottle[to]-temp[to];
            temp[to] = mBottle[to];
        }

        int nowA = temp[0], nowB = temp[1], nowC = temp[2];
        if(!check[nowA][nowB][nowC]){
            que.add(new Bottle(nowA, nowB, nowC));
            check[nowA][nowB][nowC] = true;
            if(nowA == 0) ans.add(nowC);
        }
    }

    public static void bfs(int a, int b, int c) {
        que = new ArrayDeque<>();
        que.add(new Bottle(a, b, c));
        check[a][b][c] = true;
        ans.add(c);

        while(!que.isEmpty()) {
            Bottle bottle = que.poll();
            int[] pBottle = {bottle.a, bottle.b, bottle.c};

            if(pBottle[0] != 0) {  // from A
                if(pBottle[1] != mBottle[1]) pourWater(0, 1, pBottle);
                if(pBottle[2] != mBottle[2]) pourWater(0, 2, pBottle);
            }
            if(pBottle[1] != 0) {  // from B
                if(pBottle[0] != mBottle[0]) pourWater(1, 0, pBottle);
                if(pBottle[2] != mBottle[2]) pourWater(1, 2, pBottle);
            }
            if(pBottle[2] != 0) {  // from C
                if(pBottle[0] != mBottle[0]) pourWater(2, 0, pBottle);
                if(pBottle[1] != mBottle[1]) pourWater(2, 1, pBottle);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        mBottle = new int[3];
        mBottle[0] = Integer.parseInt(st.nextToken());
        mBottle[1] = Integer.parseInt(st.nextToken());
        mBottle[2] = Integer.parseInt(st.nextToken());
        check = new boolean[mBottle[0] + 1][mBottle[1] + 1][mBottle[2] + 1];
        ans = new ArrayList<>();

        bfs(0, 0, mBottle[2]);
        Collections.sort(ans);
        for(int c : ans) {
            System.out.print(c + " ");
        }
    }
}
