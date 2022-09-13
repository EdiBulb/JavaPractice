package baekjoon.bronze;

/*제목 : 크냐?*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*문제 이해 :
* 두 양수 입력받고 첫번째 수가 두번째 수보다 큰지 구하기*/
public class b5_bj4101_1 {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                if(num1 == 0 && num2 == 0) break;

                if(num1 >  num2) System.out.println("Yes");
                else System.out.println("No");
        }

    }
}
