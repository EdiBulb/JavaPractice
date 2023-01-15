package baekjoon.silver;
//제목 : 먹을 것인가 먹힐 것인가

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s3_7795_1 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] A,B; // 생명체 A, B

    static int N, M; // A의 수, B의 수

    static  void input(){
        N = scan.nextInt(); //A 개수
        M = scan.nextInt(); //B 개수
        
        A = new int[N+1]; // idx를 1부터
        B = new int[M+1]; // idx를 1부터

        // A값 받기
        for(int i=1; i<=N ;i++){
            A[i] = scan.nextInt(); 
        }
        
        // B값 받기
        for(int i=1;i<=M;i++){
            B[i] = scan.nextInt(); 
        }
    }

    //정렬된 B를 A와 비교해서 A보다 작은 B의 개수를 찾는 메서드
    static int findAns(int[]B, int L, int R, int X){ // 배열, 왼쪽, 오른쪽, 비교할 A값
        int res = L-1; // 조건을 만족하는 AB쌍의 개수

        while(L<=R){ // B를 다 돌때까지 반복한다.
            //L과 R의 가운데 위치를 찾는다.
            int mid = (L+R)/2;
            if(B[mid] < X){ // A의 값보다 B의 중간값이 작다면,
                res = mid; //갱신한다.
                L = mid +1; // L을 갱신한다.
            } else{
                R = mid -1; // 오른쪽 구간을 갱신한다.
            }
        }
        return res;
    }

    //
    static void find(){
        //이분탐색을 사용하기 위해 B 배열을 오름차순 정렬한다.
        Arrays.sort(B, 1, M+1);

        int ans = 0; // A와 B 짝수 초기화

        //A의 1번 idx부터 N까지 확인하기
        for(int i=1;i<=N;i++){
            //A[i]를 골랐을 때, B에서 A[i]보다 작은 게 몇개 있는지 count한다.
            ans += findAns(B, 1, M, A[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int TestCase;
        TestCase = scan.nextInt();
        for(int i=1; i<=TestCase;i++){
            input();
            find();
        }
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
