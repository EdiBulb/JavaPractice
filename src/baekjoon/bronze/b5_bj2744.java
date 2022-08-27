package baekjoon.bronze;

/*제목 : 대소문자 바꾸기*/

/*문제 이해 : 대소문자로 이루어진 단어를 입력받고 대소문자를 바꾸는 프로그램*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*문제 해결법

* 1. 소문자를 대문자로 바꾸는 방법, 대문자를 소문자로 바꾸는 방법을 찾아본다.*/
public class b5_bj2744 {

    /*메소드 - 소문자->대문자, 대문자 -> 소문자 변환하는 기능*/
    static StringBuilder change(String before){

        StringBuilder sb = new StringBuilder();

        //반복문을 통해서 구현해보자
        for(int i=0;i<before.length();i++){
            if(before.charAt(i)<91){//대문자라면
                sb.append((char)(before.charAt(i)+32));//소문자로 바꿔서 넣는다.
            }
            else {//소문자라면
                sb.append((char)(before.charAt(i)-32));//대문자로 바꿔서 넣는다.
            }
        }

        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(change(s));
    }
}
