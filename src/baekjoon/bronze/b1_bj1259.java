package baekjoon.bronze;
/*문제 : 팰린드롬수*/

/*문제 이해
 * 팰린드롬 : 앞으로 읽어도 뒤로 읽어도 우영우
 * 조건 : 맨 앞에 0이 오지 않는다.
 * 여러개의 테스트 케이스임
 * 1~99999 이하 정수임
 * 마지막 줄에 0이 주어지고 끝남
 * 팰린드롬 -> yes, 아니면 no 출력*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*접근법(= 배운 것)
 * 1. 입력값이 정해져있지 않은 반복문의 경우 -> 찾아보기 -> 입력 반복해서 받으려면 입력받기기 반복문의 조건에 들어가있어야한다.
 * 2. 문자열 받고 뒤집기
 * 2-1. 문자열로 받으면, 문자열 뒤집기가 있나? -> 찾아보기
 * 2-2. 문자열로 받으면, 뒤집기 직접 구현이 있는가? -> 찾아보기
 * 3. 입력값이 0인 경우, 반복을 끝내기 -> equals 메소드, "0" '0'의 차이 문자열와 문자.
 * */
public class b1_bj1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        String str=br.readLine();
//
//
//        /*1. 입력값이 없는 반복문*/
//        while(str!=null){
        String str;
        while((str=br.readLine())!=null){ //결국, while문을 계속 돌려야하니까, 입력 값도 계속 받아야하는데, readLine을 밖으로빼면 반복적으로 입력을 받아수가 없어서, 입력을 조건문에 넣어야한다.는 것을 배움
            /*입력값이 0이면 반복문 탈출*/
            if (str.equals("0")){ //배운점 : '0' 과 "0"의 차이, '0'으로 하니까 문자열로 인식을 안한 것 같다. 그래서 반복문이 안끝났던 것임.
                break;
            }
            else{/*문자열을 거꾸로 만들어줘라*/
                String reverse="";
                for(int i =str.length()-1;i>=0;i--){
                    reverse += str.charAt(i);
                }
//                //test
//                System.out.println(reverse);

                if(str.equals(reverse)){
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }
            }
        }

//        if(str.equals('0')){ //참고 : equals 가 문자열 비교인 것 같은데 보충공부할 것

    }

}
