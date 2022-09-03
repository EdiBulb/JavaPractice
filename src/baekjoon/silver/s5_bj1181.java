package baekjoon.silver;

/*제목 : 단어 정렬*/

/*문제 이해 :
* 1. 단어를 n개 입력 받는다.
* 2. 단어의 개수 순으로 출력을 한다.
* 3. 단어의 개수가 같다면 사전순으로 출력한다.
* 4. 같은 단어가 입력되면 한번만 출력한다.*/

/*접근법
* 1. 입력받은 데이터를 배열에 다 넣는다?
* 2. 배열을 정렬시킨다? - 문자열의 길이에 따라서 배치하고 알파벳순으로 배치한다.
* 3. 출력한다. 일텐데... 이게 쉽지가 않을 것 같음
* 해시를 써야하나?
* 배열 순서로 문자를 넣어야할텐데,
* 문자열의 개수가 50이 넘지 않는다면, 배열을 50개 만들어서 문자열의 크기에 따라서 들어가는 배열을 분류하는 것은 어떨까?
* 그 다음에는 그 문자열의 크기가 같으니까, 알파벳끼리 비교를 해서.. !!해보는거지
*
* 접근법도 잘 떠오르지 않음...
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s5_bj1181 {



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++){
            String s = bf.readLine();

        }
    }
}










