package baekjoon.silver;
/*제목 : 큐*/

/*블로그 풀이 분석*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s4_bj10845_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //N을 입력받는다.
        int N = Integer.parseInt(bf.readLine());

        //StringBuilder 사용에 익숙해져야겠다.
        StringBuilder sb = new StringBuilder();
        //큐 생성하기
        Queue<Integer> myQueue = new LinkedList<>();

        //마지막에 들어온 수 저장하는 역할
        int last = 0;

        //N번 입력받기
        for(int i=0;i<N;i++){
            //문자열 공백 분리할거면 바로 이렇게 하는 게 좋겠다.
            StringTokenizer st = new StringTokenizer(bf.readLine());
            //잘라서 가져오기
            String S = st.nextToken();

            //switch문 익숙해져야겠다.
            switch (S){
                case "push" :
                    //다음 데이터를 받아서 큐에 넣는다.
                    last = Integer.parseInt(st.nextToken());
                    myQueue.offer(last);
                    break;

                case "pop" :
                    //isEmpty로 확인하고 append로 값을 넣었다. - isEmpty로 먼저 확인했어야했다.
                    //느낀점 : append 사용에 익숙해져야겠다.

                    if(myQueue.isEmpty())sb.append(-1).append("\n");
                    else sb.append(myQueue.poll()).append("\n");
                    break;
                case "size" :
                    sb.append(myQueue.size()).append("\n");
                    break;
                case "empty" :
                    if(myQueue.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append(("\n"));
                    break;
                case "front" :
                    if(myQueue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(myQueue.peek()).append("\n");
                    break;
                case "back" :
                    if(myQueue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(last).append("\n");
                    break;
            }
        }
        //끝으로 sb로 전체 출력
        System.out.println(sb);

    }
}
