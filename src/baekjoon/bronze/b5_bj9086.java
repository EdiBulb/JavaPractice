package baekjoon.bronze;
/*문제 : 문자열*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*문제 이해 :
* 문자열을 입력으로 받고 그 문자열의 첫글자와 마지막 글자를 출력한다.*/
public class b5_bj9086 {

    public static StringBuilder printwords(String s){
        StringBuilder sb  = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(s.length()-1));
        return sb;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for(int i=0;i<count;i++){
            System.out.println(printwords(br.readLine()));
        }


    }
}
