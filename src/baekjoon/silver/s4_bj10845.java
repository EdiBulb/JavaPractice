package baekjoon.silver;
/*제목 : 큐*/

/*문제 이해 :
* 정수를 저장하는 큐를 구현한 다음, 주어진 명령을 처리하는 프로그램을 작성하라
* 명령 6가지
* 1. Push X
* 2. pop
* 3. size
* 4. empty
* 5. front
* 6. back*/

/*접근법
* 1. 큐를 구현한다.
* 2. 입력에 따라 큐의 메소드들을 호출한다.
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s4_bj10845 {
    public static void main(String[] args) throws IOException {
        //문제 1 : 큐를 어떻게 구현해야하는지 모른다.
        //필요한 것 : 배열, 첫 인덱스를 가리키는 변수, 마지막을 가리키는 변수

        //공부할 것 : Queue는 인터페이스만 있고 별도의 클래스가 없다. 그래서 Queue인터페이스를 구현한 클래스들을 사용해야한다. -
        Queue<Integer> queue = new LinkedList<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        //만약 입력값이 push라면 뒤의 값을 add해주고
        //pop이라면 메서드 실행하고...
        while (N-->0){
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);

            switch (st.nextToken()){
                case "push":
                    //add를 해준다.
                    queue.add(Integer.valueOf(st.nextToken()));
                case "pop" :
                    //큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 수가 비었으면 -1을 출력한다.

                case "size" :
                     queue.size();
                     //문제 2 : 두 가지 경우의 수를 어떻게 나눠야할지 모르겠다.

            }
        }
    }
}
