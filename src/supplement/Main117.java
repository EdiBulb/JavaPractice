package supplement;
//배열로 스택 구현하기
//스택의 핵심 메소드들을 interface로 정해둔다.
interface Stack2{
    boolean isEmpty();
    boolean isFull();
    void push(char item);
    char pop();
    char peek();
    void clear();
}
//Stack2 인터페이스를 구현한다.
class ArrayStack1 implements Stack2{

    private int top; //맨 위의 데이터를 가리키는 역할
    private int stackSize; // 스택의 사이즈를 가리키는 역할
    private char stackArr[]; // 데이터를 담을 배열 선언

    //스택을 생선하는 생성자
    public ArrayStack1(int stackSize){
        top=-1;//스택 포인터를 초기화
        this.stackSize=stackSize;//스택 사이즈 대입
        stackArr=new char[this.stackSize];//스택 생성
    }
    @Override
    //isEmpty()는 boolean 타입임.
    public boolean isEmpty() {
        return (top==-1);//top이 -1이라면 비어있는 스택
    }

    @Override
    public boolean isFull() {
        return (top==this.stackSize-1);//스택 포인터가 스택의 마지막 인덱스와 동일한지 판단
    }

    @Override
    public void push(char item) {
        //넣기전에 먼저 배열이 다 차있는지 확인해야한다.
        if(isFull()){
            System.out.println("Stack is full!!");
        }else{
            //배열의 다음 인덱스에 데이터를 넣는다.
            stackArr[++top]=item;
            System.out.println("inserted item :"+item);
        }
    }

    @Override
    public char pop() {
        //빼기전에 먼저 배열이 비어있는지 확인해야한다.
        if(isEmpty()){
            System.out.println("Deleting fail!! Stack is empty!");
            //그리고 0을 리턴해줘야한다.
            return 0;
        }else{
            System.out.println("Deleting item : "+stackArr[top]);
            //배열의 해당 인덱스의 데이터를 리턴하고 인덱스를 -1 한다.
            return stackArr[top--];
        }
    }

    @Override
    public char peek() {
        //peek 메소드도 pop 메소드와 마찬가지로 데이터가 비어있는지 확인해야한다.
        if(isEmpty()){
            System.out.println("Peeking fail! Stack is empty");
            return 0;
        }else{
            System.out.println("Peeked item :"+ stackArr[top]);
            //얘는 인덱스를 -1을 안해준다.
            return stackArr[top];
        }
    }

    @Override
    public void clear() {
        //먼저 비어있는지 확인해야한다.
        if(isEmpty()){
            System.out.println("Stack is already empty!");
        }else{

            top =-1;//스택 포인터를 초기화한다.
            stackArr=new char[this.stackSize];//배열을 새로 만든다.????
            System.out.println("Stack is clear!");
        }

    }
    //스택에 저장된 모든 데이터를 출력
    public void printStack(){
        //출력하기 전에 먼저 비어있는지 확인하기
        if(isEmpty()){
            System.out.println("Stack is empty!");
        }else{
            System.out.println("Stack elements: ");
            //배열의 0부터 top 인덱스까지의 배열 데이터를 출력한다.
            for(int i =0;i<=top;i++){
                System.out.println(stackArr[i]+" ");
            }
            System.out.println();
        }
    }
}

public class Main117 {
    public static void main(String[] args) {
        int stackSize=5;
        //stackSize만큼 ArrayStack1의 객체를 만든다.
        ArrayStack1 arrStack = new ArrayStack1(stackSize);

        arrStack.push('A');
        arrStack.printStack();

        arrStack.push('B');
        arrStack.printStack();

        arrStack.push('C');
        arrStack.printStack();

        arrStack.pop();
        arrStack.printStack();

        arrStack.pop();
        arrStack.printStack();

        arrStack.peek();
        arrStack.printStack();

        arrStack.clear();
        arrStack.printStack();

    }
}
