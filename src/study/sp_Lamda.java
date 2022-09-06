package study;

/*람다함수란?
* 람다 함수는 프로그래밍 언어에서 사용되는 개념으로 익명함수를 지칭하는 용어이다.
* 쉽게 말하면, 함수를 단순하게 표현하는 방식이다.*/

/*람다의 특징
* 람다 함수는 이름을 가질 필요가 없다.*/

/*익명함수
* 익명함수란 말 그래도 함수의 이름이 없는 함수이다.*/

import java.util.Objects;

/*람다의 장단점
* 장점
* 1. 코드의 간결성 - 불필요한 반복문의 삭제가 가능하다.
* 2. 지연 연산 수행 -
* 3. 병렬 처리 가능
*
* 단점
* 1. 람다식의 호출이 까다롭다.
* 2. 람다 stream 사용 시 단순 for문 혹은 while 문 사용 시 성능이 떨어진다.
* 3. 불필요하게 너무 사용하게 되면 오히려 사독성이 떨어진다.*/
interface Consumer<T>{
    void accept(T t);

    default Consumer<T> andThen(Consumer<? super T>after){
        Objects.requireNonNull(after);
        return (T t) -> {accept(t); after.accept(t);};
    }
}

interface Function<T,R>{
    R apply(T t);

    default <V> Function<V,R> compose(Function<? super V,? extends T> before){
        Objects.requireNonNull(before);
        return (V v)-> apply(before.apply(v));
    }

    default <V> Function<T,V> andThen(Function<? super R,? extends V>after){
        Objects.requireNonNull(after);
        return (T t)-> after.apply(apply(t));
    }

    static <T> Function<T,T> identity(){
        return t->t;
    }
}

interface Predicate<T>{
    boolean test(T t);

    default Predicate<T> and(Predicate<? super T>other){
        Objects.requireNonNull(other);
        return (t)->test(t)&&other.test(t);
    }

    default Predicate<T> negate(){
        return (t) -> !test(t);
    }

    default Predicate<T> or(Predicate<? super T>other){
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }

    static <T> Predicate<T> isEqual(Object targetRef){
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }
}
public class sp_Lamda {

    public static void main(String[] args) {
//
//        //기존의 익명함수
//        MyLambdaFunction lambdaFunction = (int a,int b)-> a>b ? a: b;
//        System.out.println(lambdaFunction.max(3,5));

//        Consumer<String> consumer = (str) -> System.out.println(str.split(" ")[0]);
//        consumer.andThen(System.out::println).accept("Hello World");
//
//        Function<String, Integer> function = str -> str.length();
//        function.apply("Hello World");
        Predicate<String> predicate = (str) -> str.equals("Hello World");
        predicate.test("Hello World");

    }
}




















