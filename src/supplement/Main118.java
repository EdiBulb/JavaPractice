package supplement;

//스택의 기능을 정의한 인터페이스
interface StackIF {
    boolean isEmpty();//스택이 비어있는지 확인하는 기능

    boolean isFull();//스택이 가득차있는지 확인하는 기능

    void push(String data);//스택에 데이터를 집어넣는 기능

    void pop();//마지막 데이터를 꺼내는 기능

    void peek();//마지막 데이터를 조회하는 기능

    void clear();//모든 데이터를 삭제하는 기능
}

//스택을 구성하는 Node 클래스
//링크드리스트로 구현하기 때문에 노드가 필요합니다.
class ListStackNode {
    private String data;//데이터 저장 변수
    public ListStackNode link; //다른 노드를 참조할 링크

    //노드 생성자 1
    public ListStackNode() {
        this.data = null;
        this.link = null;
    }

    //노드 생성자 2
    public ListStackNode(String data) {
        this.data = data;
        this.link = null;
    }

    //노드 생성자 3
    public ListStackNode(String data, ListStackNode link) {
        this.data = data;
        this.link = link;
    }

    //노드의 데이터를 가져오는 기능
    public String getData() {
        return this.data;
    }
}

//인터페이스를 구현하여 연결리스트 스택 만들기
class ListStack implements StackIF {
    private ListStackNode head; //ListStackNode 타입의 head 노드 인스턴스 변수 : 처음 노드를 가리키는 역할
    private ListStackNode top; //스택의 top 포인터 : 스택이 어디까지 차있는지 가리키는 역할
    private int stackSize;     //스택 사이즈 : 스택 사이즈를 가리키는 역할

    //스택 생성자
    public ListStack(int size) {
        head = null;    //head 초기화
        top = null;     //top 초기화
        this.stackSize = size;  //스택 사이즈 초기화
    }

    //이제부터 메소드 구현!!!

    @Override
    //스택이 비어있는지 확인
    public boolean isEmpty() {
        //top이 가리키는 게 없으면 true 리턴
        return (top == null);
    }

    @Override
    //스택이 가득 찬 상태인지 확인
    public boolean isFull() {
        //1. 스택이 비어있을 경우 false return
        if (isEmpty()) {
            return false;
        }
        //2. 스택 포인터가 null이 아닌 경우(=스택이 비어있지 않은 경우) 몇 번째 노드까지 존재하는지 count 계산한다.
        else {
            int nodeCount = 0;//스택 노드 카운터 : 스택 노드의 개수를 세는 역할
            ListStackNode tempNode = head; //tempNode에 head 할당 : 처음 노드부터 순회하여 마지막 노드를 찾기 위한 역할

            //while문을 통해 순회 시작
            while (tempNode.link != null) {//tempNode의 다음 노드가 존재한다면
                ++nodeCount;//count를 올려준다.
                tempNode = tempNode.link;//다음 노드를 참조한다.
            }
            //스택 사이즈와 노드 카운터가 동일한 경우, 스택이 가득 차 있으므로 true 리턴
            return (this.stackSize - 1 == nodeCount);
        }
    }

    @Override
    //스택에 Node 를 삽입하는 기능
    public void push(String data) {
        //추가할 새로운 노드 생성
        ListStackNode newNode = new ListStackNode(data);

        //1. 스택이 가득 찼을 경우
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        //2. 스택이 비었을 경우
        else if (isEmpty()) {
            this.head = newNode;//추가된 노드가 첫 노드이므로 head는 newNode를 가리킨다.
            this.top = this.head;//top 포인터가 null인 경우니까, new 노드를 참조하게 한다.
        }
        //3. 어느정도 차있는 경우
        else {
            ListStackNode tempNode = top;// top 노드가 null이 아니기 때문에 temp노드가 top을 참조하도록 한다. tempNode : 마지막 노드를 찾기 위한 역할

            //while문이 끝나면 tempNode는 가장 마지막 노드를 가리키고 있다.
            while (tempNode.link != null) {
                tempNode = tempNode.link;
            }
            //tempNode(마지막 노드)의 link가 다음 노드를 참조하도록 한다.
            tempNode.link = newNode;
        }
    }

    @Override
    //스택에서 Node 삭제(마지막 노드 삭제)
    public void pop() {
        //삭제할 때는 삭제할 노드를 가리키는 역할과 삭제할 노드의 이전 노드를 가리키는 역할이 필요하다.
        ListStackNode preNode; //삭제할 노드의 이전 노드를 가리키는 역할
        ListStackNode tempNode;//삭제할 노드를 가리키는 역할

        //1.비어있는지 확인
        //top 포인터가 null인 경우 모든 노드가 삭제되었으므로 return
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        //2.노드가 1개인 경우
        //top 포인터의 link가 null인 경우(스택의 노드가 1개 남았을 경우)
        if (top.link == null) {
            //head와 top 포인터에 null을 할당하여 남은 노드와의 연결을 끊고 초기화시킨다.
            head = null;
            top = null;
        }
        //3.노드가 두 개 이상인 경우
        else {
            preNode = top;//preNode는 top 포인터가 가리키는 노드를 할당한다.
            tempNode = top.link;//tempNode는 top포인터가 가리키는 노드의 다음노드를 할당한다


            while (tempNode.link != null) {//tempNode는 link가 null이 아닐 때까지 한 노드씩 다음 노드로 이동한다.
                preNode = tempNode;//preNode는 tempNode를 할당한다.
                tempNode = tempNode.link;//tempNode는 tempNode의 다음 노드를 할당한다.

                //결론 while문을 돌리면, preNode는 마지막 노드의 이전 노드가 되고, tempNode는 마지막 노드가 된다.
            }
            preNode.link = null;//마지막 노드를 삭제한다.
        }
    }

    @Override
    //스택의 최상위(마지막)데이터 추출
    public void peek() {
        //1.비어있는지 확인하고
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        //2. 비어있지 않다면
        else {
            ListStackNode tempNode = top;//tempNode가 top를 가리키게 하고

            while (tempNode.link != null) {//tempNode의 다음 노드가 존재한다면
                tempNode = tempNode.link;//다음 노드로 갱신한다.
            }
            System.out.println(tempNode.getData());//가장 마지막 데이터를 추출한다.
        }
    }

    @Override
    //스택 초기화
    public void clear() {
        //1.스택이 비어있는지 확인한다.
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        //2. 스택이 차 있다면, 스택 포인터 top과 head를 초기화한다.
        else {
            head = null;
            top = null;
        }
    }

    //스택 Node 탐색 : 원하는 데이터를 찾는 기능
    public ListStackNode searchNode(String data) {
        //temp 노드에 top 포인터가 가리키는 노드를 할당한다.
        ListStackNode tempNode = this.top; //tempNode의 역할 : 원하는 데이터를 찾을 때까지 값을 변경하는 역할
        //temp노드가 null이 아닐 때까지 반복하여 탐색한다.
        while (tempNode != null) {
            //주어진 데이터와 temp 노드의 데이터가 일치할 경우 해당 temp 노드를 리턴한다.
            if (data.equals(tempNode.getData())) {
                return tempNode;
            } else {
                //데이터가 일치하지 않을 경우 temp노드에 다음 노드를 할당한다.
                tempNode = tempNode.link;
            }
        }
        return tempNode;//원하는 값을 찾지 못했을 때...?
    }

    //스택에 저장된 모든 데이터를 출력하는 기능
    public void printListStack() {
        //1. 스택이 비어있는지 확인한다.
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        //2. 스택이 비어있지 않다면
        else {
            //tempNode에 head가 가리키는 첫번째 노드를 할당한다.
            ListStackNode tempNode = this.top;

            //tempNode가 null이 아닐 때까지 반복하여 출력한다.
            while (tempNode != null) {
                System.out.println(tempNode.getData() + " ");
                tempNode = tempNode.link;//temp 노드에 다음 노드(tempNode.link)할당한다.
            }
            System.out.println();

        }
    }
}


public class Main118 {
    public static void main(String[] args) {
        int stackSize = 5;
        String str = "B";
        ListStack listStack = new ListStack(stackSize);//스택 생성

        listStack.printListStack();//Stack is empty 출력

        listStack.push("A");
        listStack.printListStack();
        listStack.push("B");
        listStack.printListStack();
        listStack.push("C");
        listStack.printListStack();
        listStack.push("D");
        listStack.printListStack();
        listStack.push("E");
        listStack.printListStack();

        listStack.push("F"); //Stack is full 출력
        listStack.printListStack();

        listStack.pop();
        listStack.printListStack();
        listStack.pop();
        listStack.printListStack();

        listStack.peek(); //C 출력

        System.out.println(listStack.searchNode(str).getData());

    }
}
