package baekjoon.bronze;
/*제목 : 치킨 두 마리*/

/*문제 이해 :
* 1. 첫째 줄에 두 수를 입력 받는다.
* 2. 둘째 줄에 치킨 1마리 값을 입력받는다.
* 3. 통장의 돈을 합쳐서 치킨 2마리를 살 수 있으면 남은 돈을, 없으면 잔고의 합을 출력한다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*접근법
* 1. 두 수를 더한다.
* 2. 치킨의 2배 가격을 빼고 0이되는지 확인한다.*/
public class b4_bj14489 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());//통장 a
        int b = Integer.parseInt(st.nextToken());//통장 b

        int chicken = Integer.parseInt(bf.readLine());//치킨 한 마리 값

        if((a+b)-chicken*2>=0){
            //남은 돈
            System.out.println((a+b)-chicken*2);
        } else{
            System.out.println(a+b);
        }
    }
}
