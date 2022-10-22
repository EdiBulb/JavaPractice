package fc_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{

    //거리와 노드 이름
    public int distance;
    public String vertex;

    public Edge(int distance, String vertex){
        this.distance = distance;
        this.vertex = vertex;
    }

    //System.out.println()으로 객체 자체 출력시
    public String toString(){
        return "vertex: " + this.vertex + ", distance: "+this.distance;
    }

    //정렬방식 재정의 - distance를 가지고 정렬하겠다.
    @Override
    public int compareTo(Edge o) {
        return this.distance - o.distance;
    }
}

public class Dijstra {
    public HashMap<String,Integer> dijkstraFunc(HashMap<String,ArrayList<Edge>>graph, String start){
        Edge edgeNode, adjacentNode;
        ArrayList<Edge> nodeList;
        int currentDistance, weight, distance;
        String currentNode, adjacent;

        //해시 맵 생성
        HashMap<String,Integer>distances = new HashMap<>();
        //초기화 - 키값에 최대값 넣기
        for(String key : graph.keySet()){
            distances.put(key, Integer.MAX_VALUE);
        }
        //시작값 업데이트
        distances.put(start, 0);

        //
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(distances.get(start), start));//시작 인자 거리, 노드 이름

        //알고리즘 작성
        while (priorityQueue.size()>0){//검토할 노드가 없을 때까지 반복
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;

            //currentNode의 값보다 크다면 할 일이 없으니 다음으로 넘어간다.
            if(distances.get(currentNode)<currentDistance){
                continue;
            }

            //리스트를 가져온다.
            nodeList = graph.get(currentNode);
            for(int index = 0; index<nodeList.size();index++){
                adjacentNode = nodeList.get(index);
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;

                if (distance< distances.get(adjacent)){
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }
            }
        }
        //최종결과 리턴
        return  distances;
    }
    public static void main(String[] args) {
        //그래프 생성
        HashMap<String, ArrayList<Edge>>graph = new HashMap<>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8,"B"), new Edge(1,"C"), new Edge(2,"D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        Dijstra dObject = new Dijstra();
        System.out.println(dObject.dijkstraFunc(graph, "A"));
    }
}
