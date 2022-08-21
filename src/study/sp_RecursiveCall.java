package study;

/*재귀 호출 공부*/

/*재귀 호출이란?
*   재귀 알고리즘이란 어떠한 문제를 자기 자신을 호출하여 해결하는 과정을 말한다.
*
* */

public class sp_RecursiveCall {
    //재귀 예제 1 - StackOverFlow 발생
    static void printHelloInfinite(){
        System.out.println("hello");
        printHelloInfinite();
    }

    //재귀 예저 2 - 종료 조건이 있는 재귀 메소드
    static void printHello(int endNum){
        if (endNum>0){
            System.out.println("Hello "+endNum);
            printHello(endNum-1);
        }
    }

    //재귀 예제 3 - Factorial(계승) -> 손으로 해볼 것
    static int factorial(int i){
        if(i==1) return 1;
        else return i*factorial(i-1);
    }

    //재귀 예제 4  - Fibonacci 수 구하기
    static int getNthFibonacciNumber(int n){
        if(n<2) return n;
        else return getNthFibonacciNumber(n-2)+getNthFibonacciNumber(n-1);
    }

    //재귀 예제 5 - Fibonacci 수열 출력
    static int num1 = 0;
    static int num2 = 1;
    static int num3 = 0;
    static void printFibonacciNumber(int count){
        if(count>1){
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;

            System.out.println(num3 + " ");
            printFibonacciNumber(count-1);
        }
    }

    //HelloWorld 반복 출력
    public static void HelloWorld(int n){
        if(n==0) return;
        System.out.println("HelloWorld");
        HelloWorld(n-1);
    }

    //1+N까지의 합 출력
    public static int PlusPlus(int n){
        if(n==0) return 0;
        return n+=PlusPlus(n-1);
    }

    //피보나치 수열 구하기
    public static int Fibonacci(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        else return Fibonacci(n-1)+Fibonacci(n-2);
    }

    //배열에서 최대값 찾기
    //문제 : 이해 완벽히 안됌!!!!!!
    public static int ArraySort(int[]a,int n){ //크기가 N인 경우 최대값을 가져오는 메서드 선언
        int x;
        if(n==1) return a[0];
        else x = ArraySort(a,n-1);

        if(x>a[n-1]) return x;
        else return a[n-1];
    }

    //배열의 합 계산하기


    public static void main(String[] args) {
//        printHelloInfinite();//예제 1
//        printHello(5); //예제 2

//        System.out.println("5!="+factorial(5)); //예제 3
//        System.out.println("10th Fibonacci number is "+getNthFibonacciNumber(10)); //예제 4

//        //예제 5
//        int num =10;
//        System.out.println("0 1 ");
//        printFibonacciNumber(num);

//        //HelloWorld 출력
//        HelloWorld(10); //n번 HelloWorld를 출력한다.

//        //1+N까지의 합계 출력
//        int N =5;
//        System.out.println("1부터 "+N+"까지의 합계 : "+PlusPlus(N));

//        //피보나치 수열 구하기
//        int n =10;
//        for(int i=0;i<n;i++){
//            System.out.print(Fibonacci(i)+" ");
//        }

        //배열에서 최대값 찾기
        int arr[] = {0,80,60,40,20,100};
        System.out.println(ArraySort(arr,3));

    }
}
