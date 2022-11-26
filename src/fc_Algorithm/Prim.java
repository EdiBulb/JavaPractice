package fc_Algorithm;

import java.util.ArrayList;

public class Prim {
    //간선 클래스
    static class Edge implements Comparable<Edge>{
        public int weight;//가중치
        public String node1;//연결된 노드 1
        public String node2;//연결된 노드 2

        public Edge(int weight, String node1, String node2){
            this.weight = weight;
            this.node1  = node1;
            this.node2  = node2;
        }
        public String toString(){
            return "(" + this.weight + "," + this.node1 + "," + this.node2 + ")";
        }
        //정렬기준 변경

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

//
//    //mst를 리턴하는 메서드
//    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges){ // 시작노드, 간선 정보
//
//        Edge currentEdge, poppedEdge; // 현재 간선
//        ArrayList<Edge> currentEdgeList, candidateEdgeList; //
//
//        //연결된 노드 집합
//        ArrayList<String> connectedNodes = new ArrayList<>();
//        //최소 신장 트리 저장
//        ArrayList<Edge> mst = new ArrayList<>();
//        PriorityQueue<Edge>priorityQueue;
//
//        //노드와 연결된 간선 리스트
//        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<>();
//
//        //초기화
//        for(int index = 0; index<edges.size();index++){
//            currentEdge = edges.get(index);
//            if(!adjacentEdges.containsKey(currentEdge.node1)){
//                adjacentEdges.put(currentEdge.node1, new ArrayList<>());
//            }
//            if(!adjacentEdges.containsKey(currentEdge.node2)){
//                adjacentEdges.put(currentEdge.node2, new ArrayList<>());
//            }
//        }
//        for(int index = 0; index<edges.size(); index++){
//            currentEdge = edges.get(index);
//            currentEdgeList = adjacentEdges.get(currentEdge.node1);
//            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
//            currentEdgeList = adjacentEdges.get(currentEdge.node2);
//            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
//        }
//
//        //지금까지 연결된 노드를 넣는다.
//        connectedNodes.add(startNode);
//        //연결된게 없을 시 빈 것 연결하기
//        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<>());
//
//        //최소 힙 구현
//        priorityQueue = new PriorityQueue();
//    }

    public static void main(String[] args) {
        //간선 정보 저장
        ArrayList<Edge> myedges = new ArrayList<Edge>();
        myedges.add(new Edge(7, "A", "B"));
        myedges.add(new Edge(5, "A", "D"));
        myedges.add(new Edge(8, "B", "C"));
        myedges.add(new Edge(9, "B", "D"));
        myedges.add(new Edge(7, "D", "E"));
        myedges.add(new Edge(5, "C", "E"));
        myedges.add(new Edge(7, "B", "E"));
        myedges.add(new Edge(6, "D", "F"));
        myedges.add(new Edge(8, "E", "F"));
        myedges.add(new Edge(9, "E", "G"));
        myedges.add(new Edge(11, "F", "G"));
    }
}
