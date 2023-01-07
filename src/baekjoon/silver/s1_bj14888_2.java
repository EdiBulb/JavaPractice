package baekjoon.silver;
/*제목 : 연산자 끼워넣기*/

import java.io.*;
import java.util.StringTokenizer;

public class s1_bj14888_2 {



    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = scan.nextInt();
        nums = new int[N+1];
        operators = new int[5];

        for(int i=1;i<=N;i++) nums[i] = scan.nextInt();
        for(int i=1;i<=4;i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min;
    static int[] nums, operators;

    //완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
    static int calculator(int operand1, int operator, int operand2){
        //nums, order
        if(operator ==1)
            return operand1 + operand2;
        else if(operator ==2)
            return operand1 - operand2;
        else if(operator ==3)
            return operand1 * operand2;
        else
            return operand1 / operand2;
    }
    static void rec_func(int k, int value){
        //order[1...N-1] 에 연산자들이 순서대로 저장될 것이다.

        if(k==N){
            //완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
            max = Math.max(max, value);
            min = Math.min(min, value);

        } else{
            //k 번째 연산자는 무엇을 선택할 것인가?
            for(int cand = 1; cand<=4; cand++){
                if(operators[cand] >=1){
                    operators[cand]--;
                    rec_func(k+1, calculator(value, cand, nums[k+1]));
                    operators[cand]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();//1번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색한다.
        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());

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