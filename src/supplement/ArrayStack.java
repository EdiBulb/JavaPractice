package supplement;

//스택에 반드시 있어야하는 것들을 interface로 규제함
interface Stack1{
    boolean isEmpty();
    boolean isFull();
    void push(char item);
    char pop();
    char peek();
    void clear();
}
public class ArrayStack implements Stack1{
    private int top;
    private int stackSize;
    private char stackArr[];

    //스택을 생성하는 생성자
    public ArrayStack(int stackSize){
        //스택 포인터 top을 초기화한다.
        top=-1;
        //매개변수로 받은 stacksize를 변수에 넣는다.
        this.stackSize=stackSize;
        //stacksize 크기만큼의 char형 배열을 생성한다.
        stackArr=new char[this.stackSize];
    }
    @Override
    //스택이 비어있는 상태인지 확인하는 메소드
    public boolean isEmpty() {
        //스택 포인터가 -1인 경우에 데이터가 없는 상태이므로 true, 아닌 경우 false를 리턴한다.
        return (top==-1);
    }

    @Override
    //스택이 가득찬 상태인지 확인하는 메소드
    public boolean isFull() {
        //스택 포인터가 스택의 마지막 인덱스와 동일하다면 true, 아니라면 false
        return (top==this.stackSize-1);
    }

    @Override
    //스택에 데이터 추가 메서드
    public void push(char item) {
        //스택이 꽉 찼으면
        if(isFull()){
            System.out.println("Stack is full");
        }
        //스택이 다 차지 않았으면
        else{
            //스택 포인터가 가리키는 다음 인덱스에 데이터 추가.
            stackArr[++top]=item;
            System.out.println("inserted item:"+item);
        }
    }

    @Override
    //스택 최상위 데이터 추출 후 삭제
    public char pop() {
        if(isEmpty()){
            System.out.println("Deleting fail. Stack is empty");
            return 0;
        }
        else{
            System.out.println("Deleted item:"+stackArr[top]);
            return stackArr[top--];
        }
    }

    @Override
    //스택 최상위 데이터 추출
    public char peek() {
        if(isEmpty()){
            System.out.println("Peeking fail. Stack is empty");
            return 0;
        }
        else{
            System.out.println("Peeking item : "+stackArr[top]);
            return stackArr[top];
        }

    }

    @Override
    //스택 초기화
    public void clear() {
        if(isEmpty()){
            System.out.println("Stack is already empty");
        }
        else{
            top =-1;
            stackArr = new char[this.stackSize];
            System.out.println("Stack is clear");
        }

    }

    //스택에 저장된 모든 데이터 출력 메소드
    public void printStack(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            System.out.print("Stack elements:");
            for(int i=0;i<=top;i++){
                System.out.print(stackArr[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int stackSize=5;

        ArrayStack arrStack = new ArrayStack(stackSize);

        arrStack.push('A');
        arrStack.printStack();

        arrStack.push('B');
        arrStack.printStack();

        arrStack.push('C');
        arrStack.printStack();

        arrStack.pop();
        arrStack.printStack();

        arrStack.peek();
        arrStack.printStack();

        arrStack.clear();
        arrStack.printStack();

    }
}
