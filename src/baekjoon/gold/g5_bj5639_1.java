package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class g5_bj5639_1 {
    // Method - 후위 순회
    private static void postorder(Node node){
        if(node.left != null) postorder(node.left);
        if(node.right != null) postorder(node.right);
//        System.out.print(node.val);
        System.out.println(node);
    }

    // 이너클래스
    private static class Node{ // 안에 클래스를 만드니까, 클래스 중복이 안되나보네?
        // 변수
        Node left,right;
        int val;

        // 생성자
        public Node(int val){
            this.val = val;
        }

        // Method - insert child Node
        public void makeChild(int cNum){//childNum
            if(cNum<val){ //왼쪽에 넣기
                if(this.left!=null) this.left.makeChild(cNum);//값이 있으면 끝을 찾아 순회하고
                else this.left = new Node(cNum);//값이 없으면 노드를 생성한다.
            }else{ // 오른쪽에 넣기
                if(this.right!=null) this.right.makeChild(cNum);//값이 있으면 끝을 찾아 순회하고
                else this.right = new Node(cNum);//값이 없으면 노드를 생성한다.
            }
        }
        // Method - for output
        /*toString()을 오버라이딩 해서 객체를 출력했을 때, val값이 출력되도록 하였다.*/
        public String toString(){return val+"\n";}
    }

    // Main
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        Node rootNode = new Node(Integer.parseInt(br.readLine()));
        while((input = br.readLine())!=null){
            rootNode.makeChild(Integer.parseInt(input));
        }

        // Logic & Output
        postorder(rootNode);
    }
}