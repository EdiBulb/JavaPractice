package baekjoon.bronze;
/*문제 : 알파벳 개수*/

/*문제 이해 :
* 1. 문자열에 알파벳이 몇개 들어가있는지 파악하기*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*접근법 :
* 1. 문자열 입력받기
* 2. 알파벳 크기의 배열 생성
* 3. 알파벳이 있을 때마다 +1해주기*/
public class b4_bj10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] count =new int[26];

        //문자열에서 1개 문자 뽑기
        for(int i=0;i<s.length();i++){
//            System.out.println(s.charAt(i) - 'a');
            count[s.charAt(i)-'a']+=1;
        }
        for(int i=0;i<26;i++){
            System.out.print(count[i]+" ");
        }
    }
}
