package study;

public class sp_Tree {
    /*가장 먼저 노드를 만든다. */
    public class Node {
        Node left;
        Node right;
        int value;

        Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }
    /*트리가 생성되면 노드가 없다. head = null */
    Node head = null;

    /*method - 노드 삽입*/
    /*크게 2가지 경우로 나뉜다.
    * 1. 노드가 하나도 없을 때
    * 2. 노드가 하나라도 들어가 있을 때 -> findNode를 통해, 노드를 어디에 삽입할지, 적절한 위치의 leafNode 를 찾아야한다.
    * 늘 고려해야하는 것 - BST이므로, 작은 것은 왼쪽에, 큰 것은 오른쪽에 넣는다.*/
    public boolean insertNode(int data) {

        // CASE1: Node 가 하나도 없을 때
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            // CASE2: Node 가 하나라도 들어가 있을 때
            Node findNode = this.head;
            while (true) {

                // CASE2-1: 현재 Node 의 왼쪽에 data 가 들어가야 할 때
                if (data < findNode.value) {
                    if (findNode.left != null) {//leafNode가 아니라면
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }

                    // CASE2-2: 현재 Node 의 오른쪽에 data 가 들어가야 할 때
                } else {
                    if (findNode.right != null) {//leafNode가 아니라면
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    /*method - 노드 탐색*/
    /*크게 2가지 경우로 나뉜다.
     * 1. 노드가 하나도 없을 때
     * 2. 노드가 하나라도 들어가 있을 때 -> findNode를 통해 순회하며 비교한다.
     * 늘 고려해야하는 것 - BST이므로, 작은 것은 왼쪽에, 큰 것은 오른쪽에 넣는다.*/

    public Node search(int data) {
        // CASE1: Node 가 하나도 없을 때
        if (head == null) {
            return null;//찾지 못했음 -> null 리턴
        } else {
            // CASE2: Node 가 하나라도 들어가 있을 때
            Node findNode = this.head; //head 값부터 순회하며 탐색한다.
            while (findNode != null) {
                if (findNode.value == data) {//같으면 값을 리턴해준다.
                    return findNode;
                } else if (data < findNode.value) {//작다면, 왼쪽 탐색한다.
                    findNode = findNode.left;
                } else {//크다면, 오른쪽 탐색한다.
                    findNode = findNode.right;
                }
            }
            return null; // 하나 이상 들어가 있는데도 없으면, 찾는 값이 없으므로 null 리턴
        }
    }

    /*method - 노드 삭제*/
    /*노드를 삭제하려면 먼저 삭제할 노드가 트리에 존재하는지부터 판단해야합니다.

     * 1. 트리에 Node 하나도 없는 경우 ->삭제 실패
     * 2. 트리에 Node가 하나 이상 들어가 있는 경우
     *  2-1. Node가 단지 하나이고, 그게 삭제될 Node인 경우 -> 삭제해야함
     *  2-2. Node가 2개 이상일 때, ->삭제해야함
     *  2-3. 노드가 하나 이상 들어있었지만 삭제할 노드가 없을 때 -> 삭제 실패
     */
    public boolean delete(int value) {
        boolean searched = false;

        Node currParentNode = this.head; //삭제할 때는 삭제할 노드와 그 부모노드를 가리켜야한다.
        Node currNode = this.head;

        // 경우 1: Node 가 하나도 없을 때
        if (this.head == null) {
            return false; //삭제 실패
        }
        // 경우 2: Node가 하나 이상 들어가 있을 때
        else {
            // 경우 2-1: (Node 가 단지 하나이고, 해당 Node 삭제 시)
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true; //삭제 해야함
            }
            // 경우 2-2 : Node가 2개 이상일 때 -> 삭제해야하는 노드를 찾는다.
            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }
            // 경우 2-3 : 노드가 하나 이상 들어있었지만 삭제할 노드가 없을 때
            if (searched == false) {
                return false;//삭제 실패
            }
        }
        /*여기까지 진행되었다면, 노드가 2개 이상인 경우만 남았고, currNode에는 삭제할 노드가, currParentNode에는 삭제할 값의 부모 노드가 들어있다.*/

        /*여기서 노드 유형에 따라 3가지 케이스로 나뉜다.
        * 1.Leaf Node를 삭제하는 경우 -> 삭제할 노드의 Parent Node가 삭제할 Node를 가리키지 않게 한다.
        * 2. Child Node가 1개인 노드를 삭제하는 경우 -> 삭제할 Node의 Parent Node가 삭제할 Node의 Child 노드를 가리키도록 한다.
        * 3. Child Node가 2개인 노드를 삭제하는 경우 -> 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 ParentNode가 가리키도록 한다.
        */
        /*게다가 삭제하는 노드의 위치가 왼쪽인지, 오른쪽인지에 따라서 경우가 달라진다.*/

        // Case1: 삭제할 Node가 Leaf Node인 경우 ->삭제할 노드의 Parent Node가 삭제할 Node를 가리키지 않게 한다.
        if (currNode.left == null && currNode.right == null) {
            //Case1-1 : 삭제할 노드가 왼쪽에 있는 경우
            if (value < currParentNode.value) {
                currParentNode.left = null;
                currNode = null; // 해당 객체 삭제를 위해, 강제로 null 로 만들어줌

            } else { //Case1-2 : 삭제할 노드가 오른쪽에 있는 경우
                currParentNode.right = null;
                currNode = null; // 해당 객체 삭제를 위해, 강제로 null 로 만들어줌
            }
            return true;

        // Child Node가 1개인 노드를 삭제하는 경우 -> 삭제할 Node의 Parent Node가 삭제할 Node의 Child 노드를 가리키도록 한다.
        // Case2-1: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우 (왼쪽)
        } else if (currNode.left != null && currNode.right == null) {
            if (value < currParentNode.value) {
                //부모의 왼쪽을 삭제할 노드의 왼쪽 노드와 연결
                currParentNode.left = currNode.left;
                currNode = null;
            } else {
                //부모의 오른쪽을 삭제할 노드의 왼쪽 노드와 연결
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;
            // Case2-2: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우 (오쪽)
        } else if (currNode.left == null && currNode.right != null) {
            if (value < currParentNode.value) {
                //부모의 왼쪽을 삭제할 노드의 오른쪽 노드와 연결
                currParentNode.left = currNode.right;
                currNode = null;
            } else {
                //부모의 오른쪽을 삭제할 노드의 오른쪽 노드와 연결
                currParentNode.right = currNode.right;
                currNode = null;
            }
            return true;


            // Case3-1: 삭제할 Node가 Child Node를 두 개 가지고 있을 경우 -> 삭제할 Node의 오른쪽 자식 중, "가장 작은 값"을 삭제할 Node의 ParentNode가 가리키도록 한다.
            // "즉, 가장 작은 값을 찾는 작업이 필요하다" ->changeNode를 통해서 찾는다.

            // 상위 코드 조건에 부합하지 않는 경우는 결국 (currNode.left != null && currNode.right != null) 이므로
            // 별도로 else if 로 하기 보다, else 로 작성한다.
        } else {

            // 삭제할 Node가 Parent Node 왼쪽에 있을 때
            if (value < currParentNode.value) {

                // changeNode를 통해서, 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node 찾기
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {//여기 오타 있었음 (currNode.left -> changeNode.left 로 바꿔줌)
                    changeParentNode = currNode;
                    changeNode = currNode.left;
                }
                // 여기까지 실행되면, changeNode 에는 삭제할 Node 의 오른쪽 자식 중, 가장 작은 값을 가진 Node 가 들어있음

                if (changeNode.right != null) {
                    // Case3-1-2: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case3-1-1: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 없을 때
                    changeParentNode.left = null;
                }
                // parent Node 의 왼쪽 Child Node 에 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 changeNode 를 연결
                currParentNode.left = changeNode;
                // parent Node 왼쪽 Child Node 인 changeNode 의 왼쪽/오른쪽 Child Node 를
                // 모두 삭제할 currNode 의 기존 왼쪽/오른쪽 Node 로 변경
                changeNode.right = currNode.right;//다시 연결해준다.
                changeNode.left = currNode.left;//다시 연결해준다.

                // 삭제할 Node 삭제!
                currNode = null;

                // 삭제할 Node가 Parent Node 오른쪽에 있을 때
            } else {
                // 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node 찾기
                Node changeNode = currNode.right;//
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                if (changeNode.right != null) {
                    // Case3-2-2: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case3-2-1: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 없을 때
                    changeParentNode.left = null;
                }

                // parent Node 의 오른쪽 Child Node 에 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 changeNode 를 연결
                currParentNode.right = changeNode;

                // parent Node 왼쪽 Child Node 인 changeNode 의 왼쪽/오른쪽 Child Node 를
                // 모두 삭제할 currNode 의 기존 왼쪽/오른쪽 Node 로 변경

                // 2021.11.09 업데이트 (참고: 코너 케이스)
                // currNode.right 가 changeNode 일 경우, changeNode 가 currNode 자리로 올라가면서,
                // 오른쪽에 다시 자신의 객체를 가리키는 상황이 될 수 있습니다.
                // 이 경우 의도치 않게, 삭제할 객체를 다시 연결하는 상황이 될 수 있습니다.
                // 특별한 코너 케이스이므로, 참고로만 코드를 업데이트를 드리며,
                // 우선은 트리의 핵심 알고리즘 이해에 보다 초점을 맞추시는 것을 추천드립니다.
                if (currNode.right != changeNode) {
                    changeNode.right = currNode.right;
                }
                changeNode.left = currNode.left;
                // 삭제할 Node 삭제!
                currNode = null;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        sp_Tree myTree = new sp_Tree();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);

        System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);

    }
}
