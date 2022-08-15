package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*풀이 연구*/
public class b1_bj1259_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*입력을 계속 받을 떄 while(true)를 사용해주면 깔끔하다.*/
        while (true){
            String str = br.readLine();

            if(str.equals("0")){
                break;
            }
            else{
                String reverse = "";
                for(int i = str.length()-1;i>=0;i--){
                    reverse +=str.charAt(i);
                }

                if(str.equals(reverse)){
                    System.out.println("yes");
                }
                else{
                    System.out.println("no");
                }
            }
        }
    }
}
