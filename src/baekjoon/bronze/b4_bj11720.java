package baekjoon.bronze;
/*숫자의 합*/

/*문제 이해
* 1. 첫째줄에 숫자의 개수 N이 주어짐
* 2. 두번째 줄에 숫자 N개가 공백없이 주어짐
* 3. 이 모든 수를 더한값을 출력해야함*/

import java.util.Scanner;

/*접근법
* 1. 첫쨰줄의 입력값을 받는다.
* 2. 둘째줄의 입력값을 N개의 크기의 배열에 넣는다.
* 2-1. 이걸 잘라서 넣어야하는데. 마치 하나의 정수처럼 나온다.맨 앞의 값을 빼는 방법이 없을까?
* 음.. 정수로 받고, 문자열로 바꿔서 문자열의 첫쨰값을 계속 빼서 배열에 넣는다.
* 그리고 배열의 값을 다 더한다.*/
public class b4_bj11720 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        //1. 첫째줄 입력받기
        int N = sc.nextInt();

        //2. 둘째줄 입력받기
        //주의 : 이건 정수로 입력받게 되면 100의 자리가 넘어가게 됌. 이런 경우 조심해서 다시 풀어볼 것!!!!
      //  float num = sc.nextFloat();
        String num = sc.next(); /*이건 숫자가 아니라 문자열로 받아야해!!*/

//        //문자열로 바꾼다.
//        String str = String.valueOf(num);

        int sum = 0;
        for(int i=0;i<N;i++){
            sum+= (num.charAt(i) -'0');
//            sum += (int)(str.charAt(i));/*아 이러면 아스키코드로 변환이 되는구나!!*/
        }
        System.out.println(sum);
    }
}
