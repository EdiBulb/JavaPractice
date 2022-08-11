package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node1991 {
    char data;//노드의 데이터 자료형이 char형 이므로
    Node1991 left;
    Node1991 right;

    Node1991(char data){//생성자는 데이터 값만 받고 노드를 생성한다.
        this.data = data;
    }
}
//트리를 구현한다. - 트리 구현에 익숙해져야한다.
class Tree1991 {
    //처음에는 root가 null이어야한다.
    Node1991 head =null;

    //노드를 추가하는 메서드를 만든다.
    //이 메서드는 데이터를 노드에 넣고 그 노드의 왼쪽과 오른쪽도 만드는 메서드임임
    public void createNode(char data, char leftData, char rightData){
        //노드를 추가할 때, head가 null이라면 아무것도 없는 상태이다.
        if(head ==null){
            head =new Node1991(data);//그러므로 노드를 만들어준다.

            //왼쪽 데이터 값이 있으면 노드를 생성한다.
            if(leftData!='.'){
                head.left = new Node1991(leftData);
            }
            //오른쪽 데이터 값이 있으면 노드를 생성한다.
            if(rightData!='.'){
                head.right = new Node1991(rightData);
            }
        }else{
            //루트노드가 있을 경우에는 어디에 노드를 만들지 찾아야한다.
            //searchNode 메소드로 찾을 것이다.
            searchNode(head,data,leftData,rightData);

        }
    }

    //루트가 존재하다면 어디에 노드를 넣어야한지 찾는 메서드다.
    public void searchNode(Node1991 root, char data, char leftData, char rightData){
        if(root ==null){
            //도착한 노드가 null이면 재귀를 종료한다.
            return;
        }else if(root.data ==data){//내가 찾는 데이터와 같다면
            if(leftData!='.'){
                root.left = new Node1991(leftData);
            }
            if(rightData!='.'){
                root.right = new Node1991(rightData);
            }
        }else{
            //아직 찾지 못했고 탐색할 노드가 남아있다면 탐색한다.
            searchNode(root.left,data,leftData,rightData);
            searchNode(root.right,data,leftData,rightData);
        }
    }
    //전위순회 메서드를 만든다.
    public void preorder(Node1991 root){
        System.out.print(root.data);//먼저 가운데를 출력한다.
        if(root.left!=null){
            preorder(root.left);//그 다음 왼쪽으로 간다.
        }
        if(root.right!=null){//재귀는 끝나면 상위 재귀로 돌아간다.
            preorder(root.right);//마지막으로 오른쪽으로 간다.
        }
    }

    //중위순회 메서드를 만든다.
    public void inorder(Node1991 root){
        if(root.left!=null){//왼쪽 먼저 출력한다.
            inorder(root.left);
        }
        System.out.print(root.data);// 중앙 출력한다.
        if(root.right!=null){//오른쪽 출력한다.
            inorder(root.right);
        }
    }

    public void postorder(Node1991 root){
        if(root.left!=null){
            postorder(root.left);
        }
        if(root.right!=null){
            postorder(root.right);
        }
        System.out.print(root.data);
    }
}

public class s1_bj1991 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree1991 tree = new Tree1991();

        for(int i =0;i<N;i++){
            char[] data;
            data = br.readLine().replaceAll(" ","").toCharArray();
            tree.createNode(data[0],data[1],data[2]);
        }

        //전위 순회
        tree.preorder(tree.head);
        System.out.println();

        //중위 순회
        tree.inorder(tree.head);
        System.out.println();

        //후위 순회
        tree.postorder(tree.head);
        System.out.println();

    }
}