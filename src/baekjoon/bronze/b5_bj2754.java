package baekjoon.bronze;

/*문제 : 학점 계산*/

/*문제 이해 :
* 문자열이 주어질 때 그것에 맞는 점수를 출력하라*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b5_bj2754 {

    public static double score(String score){
        if(score.equals("A+")){
            return 4.3;
        }
        else if(score.equals("A0")){
            return 4.0;
        }
        else if(score.equals("A-")){
            return 3.7;
        }
        else if(score.equals("B+")){
            return 3.3;
        }
        else if(score.equals("B0")){
            return 3.0;
        }
        else if(score.equals("B-")){
            return 2.7;
        }
        else if(score.equals("C+")){
            return 2.3;
        }
        else if(score.equals("C0")){
            return 2.0;
        }
        else if(score.equals("C-")){
            return 1.7;
        }
        else if(score.equals("D+")){
            return 1.3;
        }
        else if(score.equals("D0")){
            return 1.0;
        }
        else if(score.equals("D-")){
            return 0.7;
        }
        else{
            return 0.0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(score(s));
    }
}
