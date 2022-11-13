package fc_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//간선 클래스
public class Edge1 implements Comparable<Edge1>{
    public int weight;
    public String nodeV;
    public String nodeU;

    public Edge1(int weight, String nodeV, String nodeU){
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    //출력방식 변경
    public String toString(){
        return "(" + this.weight + "," + this.nodeV + "," + this.nodeU +")";
    }

    //weight 으로 정렬
    @Override
    public int compareTo(Edge1 o) {
        return this.weight - o.weight;
    }

    public static void main(String[] args) {

        ArrayList<String> vetices = new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G"));

        //간선 배열
        ArrayList<Edge1> edges = new ArrayList<>();

        //간선 다 넣기
        edges.add(new Edge1(7,"A","B"));
        edges.add(new Edge1(5,"A","D"));
        edges.add(new Edge1(7,"B","A"));
        edges.add(new Edge1(8,"B","C"));
        edges.add(new Edge1(9,"B","D"));
        edges.add(new Edge1(7,"B","E"));
        edges.add(new Edge1(8,"C","B"));
        edges.add(new Edge1(5,"C","E"));

        edges.add(new Edge1(5,"B","D"));
        edges.add(new Edge1(9,"B","E"));
        edges.add(new Edge1(7,"C","B"));
        edges.add(new Edge1(6,"C","E"));

        System.out.println(edges);



    }
    //내 노드의 부모노드를 리턴하는 해쉬맵을 만들기
    HashMap<String, String> parent = new HashMap<>();
    //자기 노드의 랭크를 리턴하는 해쉬맵
    HashMap<String, Integer> rank = new HashMap<>();

    //find 매소드 - 노드를 받으면, 그 노드의 루트노드를 리턴해주는 메소드
    //명확힌 이해가 안감.
    public String find(String node){

        //path compression 기법
        if(parent.get(node)!=node){ //현재 노드가 루트노드가 아니면
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node); // 루트노드를 리턴한다.
    }

    //union 메소드 - 간선을 잇는다. nodeV와 nodeU를 잇는다.
    //전제 조건 : nodeV와 nodeU를 이었을 때, 싸이클이 안생기는 것을 조건으로 함.
    public void union(String nodeV, String nodeU){
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        //union-by-rank 기법
        //높이가 다를 때는 높이가 큰 쪽에 붙어라.
        //높이가 같을 때는 한쪽의 높의를 높인뒤 붙여라.
        if(rank.get(root1)>rank.get(root2)){
            parent.put(root2, root1);
        } else{
            parent.put(root1, root2);
            //루트 랭크가 같은지 비교한다. 같다면,
            if (rank.get(root1)==rank.get(root2)){
                //한쪽의 랭크를 높여준다.
                rank.put(root2, rank.get(root2)+1);
            }
        }

    }
}
