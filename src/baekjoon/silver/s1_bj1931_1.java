package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*제목 : 회의실 배정*/

/*문제 이해 :
* 1. 1개의 회의실과 N개의 회의가 있다. 그리고 회의실 사용표를 만든다.
* 2. 회의 : 시작시간과 끝나는 시간이 있다. 끝나는 시간과 시작 시간은 겹칠 수 있음
* 3. 최대한으로 가질 수 있는 회의의 개수를 구해라!!
* */

/*접근법
* 1. 시작시간과 끝나는 시간을 갖는 회의(Meeting) 클래스를 만든다.
* 2. 회의 종류 리스트를 만든다.
* 3. 정렬 기준 메서드 정의- 종료시간이 가장 빠른 회의를 고른다. 이전 회의 종료 시간에 바로 올 수 있는 시작시간을 가진 회의를 분류하고, 그 중에서도 종료시간이 가장 빠른 회의를 고르는 것을 반복한다.
* 4. 그리디 메소드 정의
* 5. 정렬하기
* 6. 그리디 메서드 실행하기*/
public class s1_bj1931_1 {
    static List<Meeting> list = new ArrayList<>(); //회의 리스트
    static int N;//회의 개수

    /*1번*/
    //Meeting 클래스 만들기 - 시작시간, 끝나는 시간 가짐
    static class Meeting{
        int start;
        int end;

        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());//회의 개수

        /*2번*/
        //회의 종류 리스트 만들기
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());//시작시간
            int end = Integer.parseInt(st.nextToken());//끝나는 시간

            list.add(new Meeting(start,end));//회의 리스트에 회의를 추가
        }

        /*5번*/
        compare_sort();

        /*6번*/
        greedy();
    }

    /*3번*/
    //정렬 기준 메서드 정의
    static void compare_sort(){
        Collections.sort(list, new Comparator<Meeting>() {//회의 리스트를 매개변수로 받아서 재정렬하기
            @Override
            public int compare(s1_bj1931_1.Meeting o1, s1_bj1931_1.Meeting o2) {
                if(o1.end == o2.end){//끝나는 시간이 같은 경우
                    return o1.start - o2.start;//시작 시간을 기준으로 정렬
                }
                return o1.end - o2.end;//같지 않은 경우 끝나는 시간을 기준으로 정렬
            }
        });
    }

    /*4번*/
    //그리디 메서드 정의
    static void greedy(){
        int count = 0;//회의실 개수
        int prev_end_time = 0; // 이전 회의 끝난 시간

        for(int i=0;i<N;i++){
            Meeting time = list.get(i);

            if(prev_end_time <= time.start){//현재 미팅의 시작시간과 이진 미팅의 끝나는 시간 비교해서 시작시간이 큰 경우만,
                prev_end_time = time.end;//그 미팅의 끝나는 시간을 갱신해줌
                count++;//회의 개수 +1
            }
        }
        System.out.println(count);//총 회의 개수 출력
    }
}