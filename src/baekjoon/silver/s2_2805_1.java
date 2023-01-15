package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class s2_2805_1 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;//나무의 수, 가져가는 나무 길이
    static int[] A;// 나무 길이

    static void input(){
        N = scan.nextInt(); // 나무 수
        M = scan.nextInt(); // 필요한 나무 길이
        A = new int[N+1]; // 나무 길이 배열
        for(int i=1;i<=N;i++){
            A[i] = scan.nextInt();
        }
    }

    static boolean determination(int H){
        //H 높이로 나무들을 잘랐을 때, M 만큼 얻을 수 있으면 true, 없으면 false를 리턴하는 함수
        long sum = 0; // 잘린 나무 길이 합

        for(int i=1;i<=N;i++){
            if(A[i]>H){
                sum +=A[i] -H;// 잘린 길이 더하기
            }
        }
        return sum>=M;
    }

    static void pro(){
        long L = 0, R=2000000000, ans = 0; // ans는 높이의 최댓값

        while(L<=R){
            int mid = (int)((L+R)/2);
            //true 인 경우
            if(determination(mid)){
                ans = mid;
                L = mid +1;
            } else{
                R = mid -1;
            }
        }
        //여기까지 하면 최대 높이 ans를 구한다.
        System.out.println(ans);
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
