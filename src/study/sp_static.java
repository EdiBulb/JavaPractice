package study;
/*보충 공부
* static에 대한 이해가 부족하여 예시를 들면서 공부한다.
* static 키워드를 통해 생성된 정적멤버들은 Heap영역이 아닌 static 영역에 할당한다.
* static영역에 할당된 메모리는 모든 객체가 공유하여 하나의 멤버를 어디서든지 참조할 수 있는 장점을 가지지만
* Garbage Collector의 관리 영역 밖에 존재하기에 Static 영역에 있는 멤버들은 프로그래므이 종료시까지 메모리가 할당된 채로 존재하게 된다.
* 그렇기에 Static을 너무 남발하게 되면 만들고자 하는 시스템 성능에 악영향을 줄 수 있다.
* */

/*Static 함수, 변수의 메모리 저장 위치
* 일반적으로 우리가 만드는 Class는 Static영역에 생성되고,
* new 연산을 통해 생성된 객체는 Heap영역에 생성된다.*/

/*판단기준 :
* 필드나 메소드를 생성 시 인스턴스로 생성할 것인지 정적으로 생성할 것인지에 대한 판단 기준은
* "공용으로 사용하느냐 아니냐"로 내리면 된다.
*
* 인스턴스 변수는 인스턴스가 생성될 때마다 생성되므로 인스턴스가 각기 다른 값을 가지지만,
* 정적 변수는 모든 인스턴스가 "하나의 저장공간"을 공유하기에 항상 같은 값을 가진다.
* */

/*사용 이유
* static은 전역적으로 쉽게 재사용하는 멤버나 잘 변하지 않는 변수나, 메소드를 사용할 때 주로 사용된다.
* 만들어 놓고 클래스 호출, 객체 생성을 따로 할 필요없이 바로 바로 사용할 수 있기 떄문에 사용성이 좋다.
* */

/*Static의 장점과 단점
* <장점>
* 1. Static이 메모리 측면에서 효율적일 수 있다는 점이다.
*   Static 메모리 영역에 저장되고 고정된 메모리 영역을 사용하기 때문에 매번 인스턴스를 생성하며 낭비되는 메모리를 줄일 수 있다.
* 2. 객체를 생성하지 않고 사용하기 때문에 속도가 빠르다는 것이다.
*   클래스가 메모리에 올라가는 시점에 생성되어 바로 사용이 가능하기에 속도 면에서 이점을 가진다.
*
* <단점>
* 1. 프로그램 종료시까지 메모리에 할당된 채로 존재한다.
*   우리가 만든 Class는 프로그램 실행 시 Static 영역에 생성된다.
*   그런데, Garbage Collector를 통해 수시로 관리를 받는 Heap영역과 다르게 Static영역은 Garbage Collector의 관리를 받지 않는다.
*   그래서 Static영역은 프로그램 종료시까지 메모리에 존재한다.
*   만약 프로그램에서 많은 Static을 사용하게 되면 종료시까지 메모리가 할당된 채로 존재하므로 프로그램 퍼포먼스에 악영향을 주게 된다.
*
* 2. Static이 객체지향적이지 못한다는 점이다.
*   Static은 따로 객체를 생성하지 않고 메모리의 Static영역에 할당된 곳에서 여러 클래스들이 데이터를 불러온다.
*   이러한 Static의 특징은 객체의 데이터들이 캡슐화되어야 한다는 객체지향 프로그래밍의 원칙으 위반한다.
*
* 3. Static 메서드는 interface를 구현하는데 사용될 수 없다는 점이다.
*   Static 메서드는 코드의 재사용성을 높여주는 자바의 유용한 객체지향적 기능(interface 등)을 사용하는 것을 방해한다.
* */


/*1. 정적 필드 사용 예시*/
class Number{
    static int num = 0;//클래스 필드
    int num2 =0;//인스턴스 필드
}

/*2. 정적 메서드 사용 예시*/
class Name{
    static void print(){ //클래스 메소드
        System.out.println("I'm Harry");
    }
    void print2(){ //인스턴스 메소드
        System.out.println("I'm soyoung");
    }
}


public class sp_static {

    /*일반 변수와 static 변수 생성*/
    int a =10;//
    static int static_b =11;

    /*일반 메서드와 static 메서드 생성*/
    public void call(){//
        System.out.println("call method");
    }
    public static void static_call(){
        System.out.println("static method call!!");
    }


    public static void main(String[] args) {

        /*객체를 만들어서 사용해야하는 일반 경우*/
        sp_static nst = new sp_static();//객체화
        System.out.println(nst.a);//10
        nst.call();//call method

        /*객체를 만들지 않아도 되는 static 경우*/
        System.out.println(static_b);//11
        static_call();//static method call!!


        /*1. 정적 필드 사용 예시*/
        Number number1 = new Number();
        Number number2 = new Number();

        number1.num++;
        number1.num2++;

        System.out.println(number2.num);//1
        System.out.println(number2.num2);//0

        /*2. 정적 메소드 사용 예시*/
        //인스턴스를 생성하지 않아도 호출이 가능
        Name.print();//I'm Harry

        Name name = new Name();//인스턴스 생성
        //인스턴스를 생성하여야만 print2() 호출이 가능
        name.print2();//I'm soyoung

        /*정리
        * 정적 메소드는 클래스가 메모리에 올라갈 때, 정적 메소드가 자동적으로 생성됩니다.
        * 그렇기에 정적 메소드는 인스턴스를 생성하지 않아도 호출을 할 수 있습니다.
        * 정적 메소드는 유틸리티 함수를 만드는데 유용하게 사용됩니다.*/
    }
}