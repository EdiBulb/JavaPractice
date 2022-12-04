package self_study;

import java.util.Scanner;

/*입력 개수를 모르는데, 입력을 계속 받아야할 때*/
public class inputcount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int input = sc.nextInt();
            if(input!=0){
                System.out.println(input);

            }
        }
    }
}
