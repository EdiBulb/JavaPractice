package baekjoon.gold;
/*내가 풀었다. 근데 못 풀었다.*/
import java.util.Scanner;

/*문제 제목 : 이진 검색 트리*/
//먼저 트리를 구현해야함
class Node{
    Node left;
    Node right;
    int value;
    Node(int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}

class NodeMgmt {
    Node head = null;

    public void insertNode(int data) {

        // CASE1: Node 가 하나도 없을 때
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            // CASE2: Node 가 하나라도 들어가 있을 때
            Node findNode = this.head;
            while (true) {

                // CASE2-1: 현재 Node 의 왼쪽에 data 가 들어가야 할 때
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }

                    // CASE2-2: 현재 Node 의 오른쪽에 data 가 들어가야 할 때
                } else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
    }
    //후위 순회
    public static void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}

public class g5_bj5639 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //0.위에 트리 클래스를 구현한다.

        //1.트리를 생성한다.
        NodeMgmt tree = new NodeMgmt();

        //2.입력 개수만큼 입력값을 받아서 트리를 만든다.
        //2-1.개수를 입력받지 않고 반복해서 입력값을 넣는다.
        while(sc.hasNext()){
            tree.insertNode(sc.nextInt());
            System.out.println(tree.head);
        }

        //여기까지 했으면 트리에는 다 노드가 찼다.

        //3. 이제 후위순회로 출력해준다.
        tree.postOrder(tree.head);
    }

}