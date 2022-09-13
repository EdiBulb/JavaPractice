package baekjoon.bronze;

/*제목 : 크냐?*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*문제 이해 :
* 두 양수 입력받고 첫번째 수가 두번째 수보다 큰지 구하기*/
public class b5_bj4101 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
//        while (true){

        while(st.hasMoreTokens()){
            //문제 1 : 무한루프 돌게 만드는 법 까먹음.
            //가정 1 : true인 듯?

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(first ==0 && second==0){
                break;
            }
            else if(first>second){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
