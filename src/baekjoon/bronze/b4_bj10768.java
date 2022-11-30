package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b4_bj10768 {
    public static void main(String[] args) throws IOException {
        //입력 2개 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(br.readLine());
        int date = Integer.parseInt(br.readLine());

        //값으로 검사하기
        if(month==2 && date == 18) System.out.println("Special");

        if(month>2){
            System.out.println("After");
        }
        else if(month==2 && date>18){
            System.out.println("After");
        }
        else if(month<2){
            System.out.println("Before");
        }
        else if (month==2 && date<18){
            System.out.println("Before");
        }
    }
}
