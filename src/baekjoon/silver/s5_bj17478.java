package baekjoon.silver;

/*문제 : 재귀함수가 뭔가요?*/

/*문제 이해 :
* 재귀 횟수 N을 통해 응답을 출력한다.*/

/*접근법 :
* 재귀함수가 뭔가요? ~부분을 메서드로 만들고 N==1 이면 마지막 부분을 출력한다.*/
public class s5_bj17478 {

    public static void response(int N){
        if(N==0){

            return;
        }
        for(int i=1;i<=(N-i);i++){
            System.out.print("----");
        }
        System.out.println("\"aaaa\"");
        for(int i=1;i<=(N-i);i++){
            System.out.print("----");
        }
        System.out.println("\"bbb");
        for(int i=1;i<=(N-i);i++){
            System.out.print("----");
        }
        System.out.println("cccc");
        for(int i=1;i<=(N-i);i++){
            System.out.print("----");
        }
        System.out.println("dddd\"");

        response(N-1);
    }

    public static void main(String[] args) {
        response(2);

    }
}
