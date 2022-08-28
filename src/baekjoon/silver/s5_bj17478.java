package baekjoon.silver;

/*제목 : 재귀함수가 뭔가요?*/

/*문제 이해 :
 * 재귀 횟수 N을 통해 응답을 출력한다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*접근법 :
 * 1. 입력값 N이 0인 경우 마지막 대답을 출력하고 아닌 경우 재귀하기
 * 2. 대시 기호를 따로 구분하기*/

/*배운점 :
1.  static 문자열 변수에 ----을 담아서 재귀에 영향을 안 받고, 출력할 문장 앞에 + 하는 접근법
* */

public class s5_bj17478 {

    //문제 1 : dash처리 - 반복을 하면 재귀를 타서 초기화 되어서 무한루프를 돈다.
    //해결책 1 : 반복문 대신, String 변수 tap을 만들어서 + 연산자로 추가했음

    static String recurTap = ""; // 처음에는 여백이 없음.

//잘못된 방법 1 : N이
//    public static void dash(int N) {
//        for (int i = 0; i < N; i++) {
//            System.out.print("____");
//        }
//    }

    public static void response(int N) {
        //처음에는 여백이 없다.
        String tap = recurTap;


        //N==0이 되면 재귀를 종료한다.
        if (N == 0) {
            System.out.println(tap+"\"재귀함수가 뭔가요?\"");
            System.out.println(tap+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(tap+"라고 답변하였지.");
            return;
        }

        //0이 되기 전까지는 재귀 반복한다.
        System.out.println(tap + "\"재귀함수가 뭔가요?\"");
        System.out.println(tap + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(tap + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(tap + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");


        //재귀에 들어가기 전에 빈칸 사이즈를 늘려준다.
        recurTap+="____";
        response(N - 1);
        //재귀에서 빠져나오면서 탭이 큰 순서부터 출력한다.
        System.out.println(tap+"라고 답변하였지.");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N입력 받기
        int N = Integer.parseInt(br.readLine());

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

        response(N);

    }
}
