package baekjoon.gold;

/*이 방법은 시간초과가 난다. 왜냐? 불필요한 탐색을 많이하기 때문이다.*/

import java.io.*;
import java.util.StringTokenizer;

public class g4_9663_3 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = scan.nextInt();
        col = new int[N+1];
    }

    static int N, ans; // N 입력받는 값, ans 가능한 경우의 수를 세는 변수
    static int[] col; // col[i] : i번 행의 퀸은 col[i]번 열에 놓았다는 기록이다.

    //공격가능한지 확인하는 함수
    static boolean attackable(int r1, int c1, int r2, int c2){
        if(c1==c2) return true; // 행이 같은 경우
        if(r1-c1 == r2 - c2) return true; //왼쪽 대각선인 경우
        if(r1+c1 == r2 + c2) return true; //오른쪽 대각선인 경우
        return false;
    }

    //모든 퀸이 서로를 공격할 수 없는지 확인하는 함수, 공격이 없다면 true, 공격이 있다면 false
    static boolean validity_check(){
        for(int i=1; i<=N;i++){
            //(i, col[i])
            for(int j=1; j<i; j++){
                //(j, col[j])
                if(attackable(i, col[i], j, col[j])){
                    return false;
                }
            }
        }
        return true;
    }

    //row번 ~N 번 행에 대해서 가능한 퀸을 놓는 경우의 수를 구하는 함수
    static void rec_func(int row){
        if(row == N+1){ // 각 행마다 퀸을 하나씩 잘 놓았다는 뜻

            ans++;

        } else{
            //모든 퀸을 확인하는 것이 아닌 가능한 자리만 확인한다.
            for(int c = 1; c<=N; c++){

                boolean possible = true;

                //valid check(row, c)
                for(int i=1; i<=row-1;i++){
                    //(i, col[i])
                    //놓으려는 위치(row, c)와 i, col[i]가 공격가능하다면
                    if(attackable(row, c, i, col[i])){
                        possible = false;
                        break;
                    }
                }
                if(possible){
                    //가능하다면, 재귀호출을 해준다.
                    col[row] = c;
                    rec_func(row+1);
                    col[row] = 0;
                }

            }
        }
    }

    public static void main(String[] args) {
        input();

        //1번째 원소부터 M 번쨰 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
        System.out.println(ans);
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
