package baekjoon.bronze;
/*제목 : 홍익대학교*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*문제 이해 :
* 홍익대학교는 1946년 개교했다. 입력값으로 특정년도가 주어졌을 때, 그 해가 개교 몇 주년인지 출력하라*/
public class b5_bj16394 {

    //개교 몇주년인지 계산하는 메소드
    static void anniversary(int year){
        System.out.println(year-1946);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());
        anniversary(year);
    }
}
