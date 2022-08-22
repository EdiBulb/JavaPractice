package baekjoon.silver;

/*문제 : 재귀함수가 뭔가요?*/

/*문제 이해 :
* 재귀 횟수 N을 통해 응답을 출력한다.*/

/*접근법 :
* 재귀함수가 뭔가요? ~부분을 메서드로 만들고 N==1 이면 마지막 부분을 출력한다.*/
public class s5_bj17478 {

    public static void dash(int N){
        for(int i=N;i<N;i--){
            System.out.print("----");
        }
    }

    public static void response(int N){

        if(N>0){
            dash(N);
            System.out.println("\"what is Recursive\"");
            dash(N);

            System.out.println("\"Listen carefully");
            dash(N);

            System.out.println("many people ask");
            dash(N);

            System.out.println("his answer was right.\"");

            response(N-1);

            dash(N);

            System.out.println("he answered.");
        }

        //문제 : ----이 부분의 규칙성을 찾아야한다.
        System.out.println("\"what is Recursive\"");
        System.out.println("\"Recursive is\"");
        System.out.println("he answered.");

    }

    public static void main(String[] args) {

        System.out.println("A student asked a professor.");

        response(2);

    }
}
