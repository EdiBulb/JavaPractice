package study;

import java.util.ArrayList;
import java.util.Collections;
/*그리디 예제 - Action Selection 문제*/
public class PracticeGreedy1 {

    public static void main(String[] args) {

        //활동 정보를 List에 저장하고 정렬한다.
        ArrayList<Action> list = new ArrayList<>();
        list.add(new Action("A",7,8));
        list.add(new Action("B",5,7));
        list.add(new Action("C",3,6));
        list.add(new Action("D",1,2));
        list.add(new Action("E",6,9));
        list.add(new Action("F",10,11));

        Collections.sort(list);
//        System.out.println(list);

        //그리디 알고리즘 수행 후, 결과 출력
        ArrayList<Action> ans = greedy(list);
        for(Action act : ans){
            System.out.print(act.name + ", ");
        }
    }

    //그리디 알고리즘 메소드
    private static ArrayList<Action> greedy(ArrayList<Action> list){
        int time = 0;
        ArrayList<Action> ans = new ArrayList<>();//리스트 생성

        for(Action act : list){//리스트 반복
            if(time<= act.startTime){//시작은 가장 작은 값, 끝나는 시간보다 큰 값인 경우
                time = act.endTime;//끝나는 시간을 대입
                ans.add(act);//리스트에 집어넣는다.
            }
        }
        return ans; // 배열 반환
    }
}
class Action implements Comparable<Action>{ // 질문 : Comparable 이 뭐지?
    String name;
    int startTime;
    int endTime;

    //생성자
    public Action(String name, int startTime, int endTime){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    @Override
    public int compareTo(Action o) {
        return this.endTime - o.endTime;
    }

    @Override
    public String toString() {
        return this.name;
    }
}