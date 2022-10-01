package fc_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFSSearch {
    //메소드
    public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>>graph,String startNode){

        //ArrayList 2개를 만든다.
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        //시작 노드를 넣어준다.
        needVisit.add(startNode);

        //방문할 노드가 있다면
        while (needVisit.size()>0){

            //스택 맨끝에서 데이터를 뽑는다. : BFS와 이 부분만 다름 (큐-> 스택)
            String node = needVisit.remove(needVisit.size()-1);
            //해당 노드가 방문을 안했다면
            if(!visited.contains(node)){
                //방문한다.
                visited.add(node);
                //해당 노드와 연결된 노드를 넣는다.
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }

    public static void main(String[] args) {

        //그래프를 자료구조로 만들기
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
        DFSSearch dObject = new DFSSearch();

        //메소드 호출
        System.out.println(dObject.dfsFunc(graph,"A"));
    }
}
