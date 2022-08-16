package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*문제 : 스택 수열*/
public class s3_bj1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N을 입력받는다.
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> myStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        //처음에만 number로 받아주고
        int number = Integer.parseInt(br.readLine()); // number가 pop이 안된상태에서 나오면 안된다.
        for(int i=1;i<N+1;i++){
            //N개의 수를 오름차순으로 스택에 넣는다.

            //1부터 넣는데,
            myStack.push(i);
            //최상단이 입력값과 같으면
            //문제 : number가 p
            //문제 : 같아도 일단 append를 해줘야한다.
            if(myStack.peek()!=number){ // i값을 +1 해서 다음값을 넣어서 비교를 해줘야하는데...
                sb.append("+");
                //변화를 줘야 반복문을 나오는데.
            }
            if(myStack.peek()==number){
                myStack.pop();
                sb.append("-");
                number = Integer.parseInt(br.readLine()); // number가 pop이 안된상태에서 나오면 안된다.
                //얘는 3인데, 쟤는 5야.. 그럼 안되지?
                //반드시 그림을 그려가면서 문제를 풀자!!
            }
        }
        if(myStack.size()!=0){
           System.out.println(myStack.size());
            System.out.println("NO");
        }else{
            sb.toString();
        }
        //스택에 사이즈가 0이 아니라면, No를 출력해야하는데, 앞에 sout가 있어서 No만 출력하는 방법을 찾아야한다. ->stringbuilder를 사용한다.
        //내가 간과한 것 : 예제 입력은 원하는 결과값이고 맨 앞에있는 데이터와 비교를 해야하는 것이다.

    }
}
