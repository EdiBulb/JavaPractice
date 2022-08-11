package baekjoon.bronze;
/*다른 내 풀이*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b4_bj11720_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*첫째줄 입력받기*/
        int N = Integer.parseInt(br.readLine());

        /*둘째줄 입력받기*/
        String str  =  br.readLine();

        int sum = 0;

        /*문자열을 문자로 빼서 정수로 바꿔준다.*/
        for(int i = 0;i<N;i++){
            sum += str.charAt(i) -'0';
        }

        System.out.println(sum);

    }
}
