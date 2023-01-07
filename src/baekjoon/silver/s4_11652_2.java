package baekjoon.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s4_11652_2 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    //카드 N장
    static int N;
    //숫자
    static long[] a;
    
    static void input(){
        N = scan.nextInt(); // 카드 개수 입력
        a = new long[N+1]; // 숫자 배열 생성
        for(int i=1;i<=N;i++){ // 인덱스 1부터
            a[i] = scan.nextLong();
        }
    }
    
    static void pro(){
        //먼저 정렬부터하기
        Arrays.sort(a, 1, N+1); // 정렬하기 - 인덱스 1부터 N까지

        long mode = a[1];//mode: 최빈값
        int modeCnt = 1; //modeCnt: 최빈값의 등장 횟수
        int curCnt = 1;  //curCnt: 현재 값(a[1])의 등장 횟수

        for(int i=2;i<=N;i++){
            //앞의 값과 같다면
            if(a[i] ==a[i-1]){
                curCnt++;//등장 횟수를 올려준다.
            } else{
                curCnt = 1; // 새로운 수가 등장했다.
            }
            //현재 최빈값이 기존 최빈값 수보다 더 크면 바꾼다.
            if(curCnt > modeCnt){
                modeCnt = curCnt;
                mode = a[i];
            }
        }
        System.out.println(mode);
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
