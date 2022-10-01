package fc_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BFSSearch {
    //메소드
    public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>>graph,String startNode){//그래프, 처음 시작 노드

        //큐를 두개 만든다.
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        //시작 노드를 넣어준다.
        needVisit.add(startNode);

        //needVisit.size()>0 이면 방문할 노드가 남아있다는 뜻
        while(needVisit.size()>0){
            //맨 앞 노드를 가져온다.
            String node = needVisit.remove(0);

            //해당 노드가 방문을 안했다면
            if(!visited.contains(node)){
                //방문해라
                visited.add(node);
                //해당 노드의 연결된 노드를 넣는다.
                needVisit.addAll(graph.get(node));
            }
        }
        //여기까지 오면 방문할 노드는 더 이상 없음
        return visited;//기록된 방문한 순서 리턴
    }

    public static void main(String[] args) {

        //그래프를 자료구조로 작성하기
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        graph.put("A",new ArrayList<>(Arrays.asList("B","C")));
        graph.put("B",new ArrayList<>(Arrays.asList("A","D")));
        graph.put("C",new ArrayList<>(Arrays.asList("A","G","H","I")));
        graph.put("D",new ArrayList<>(Arrays.asList("B","E","F")));
        graph.put("E",new ArrayList<>(Arrays.asList("D")));
        graph.put("F",new ArrayList<>(Arrays.asList("D")));
        graph.put("G",new ArrayList<>(Arrays.asList("C")));
        graph.put("H",new ArrayList<>(Arrays.asList("C")));
        graph.put("I",new ArrayList<>(Arrays.asList("C","J")));
        graph.put("J",new ArrayList<>(Arrays.asList("I")));


        //객체 생성
        BFSSearch bObject  = new BFSSearch();

        //메소드 호출
       System.out.println(bObject.bfsFunc(graph,"A"));
    }
}
