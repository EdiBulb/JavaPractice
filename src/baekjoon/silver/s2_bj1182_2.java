package baekjoon.silver;

/*제목 : 부분수열의 합*/
/*접근법(다른 풀이 참고) :
* 1. DFS 알고리즘을 적용해서 지금 위치의 원소를 선택하거나 선택하지 않거나 2가지 조건을 재귀함수로 계속 호출하였다.*/

import java.io.*;
import java.util.StringTokenizer;

public class s2_bj1182_2 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N+1];
        for(int i=1; i<=N;i++) nums[i] = scan.nextInt();
    }

    static int N, S, ans; // 원소 개수, 부분수열의 합, 부분수열개수
    static int[] nums; // 수열

    //k번째 원소를 포함시킬 지 정하는 함수
    //value:=k-1 번째 원소까지 골라진 원소들의 합
    static void rec_func(int k, int value){
        if(k==N+1){ // 부분 수열을 하나 원성 시킨 상태
            // value 가 S랑 같은 지 확인하기
            if(value == S) ans++;
        } else{
            // k번째 원소를 포함시킬 지 결정하고 재귀호출 해주기

            //Include
            rec_func(k+1, value + nums[k]);

            //Not Include
            rec_func(k+1, value);
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1, 0); // 처음에는 아무런 원소를 고르지 않았기에 value가 0이다.


        // ans가 정말 "진 부분집합" 만 다루는 지 확인하기

        if(S==0){
            ans--;
        }

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