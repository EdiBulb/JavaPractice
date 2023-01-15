package baekjoon.gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_2470_1 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N; // 용액 개수
    static int[] A; //용액값

    static void input(){
        N = scan.nextInt();
        A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i] = scan.nextInt();
        }
    }

    //A[L...R]에서 X 이상의 수 중 제일 왼쪽 인덱스를 return하는 메소드
    static int lower_bound(int[] A, int L, int R, int X){
        //오른쪽에 있는 수 중,
        int res = R+1;

        while(L<=R){
            int mid = (L+R)/2;

            if(A[mid]>=X){ // X 이상의 수라면
                res = mid;
                R= mid-1;
            } else{
                L = mid+1;
            }
        }
        return res;
    }

    static void pro(){
        //A를 이분탐색 하기 때문에 오름차순 정렬한다.
        Arrays.sort(A, 1, N+1);

        //합을 기록하는 변수
        int best_sum = Integer.MAX_VALUE;

        //왼쪽 값, 오른쪽 값
        int v1 = 0, v2 = 0;

        //left 1부터 차례대로 시작하기
        for(int left = 1; left<=N-1;left++){

            //res값을 찾는다.
            int res = lower_bound(A, left+1, N, -A[left]);

            // A[res-1]와 A[res] 중에 A[left]와 섞었을 때의 정보를 정답에 갱신시킨다.
            if(left<res-1 && Math.abs(A[left] + A[res-1]) < best_sum){
                best_sum = Math.abs(A[left]+A[res - 1]);
                v1 = A[left];
                v2 = A[res -1];
            }

            // 위의 작업을 res에 대해서도 실행한다.
            if (res <= N && Math.abs(A[left] + A[res]) < best_sum) {
                best_sum = Math.abs(A[left] + A[res]);
                v1 = A[left];
                v2 = A[res];
            }
        }

        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
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
