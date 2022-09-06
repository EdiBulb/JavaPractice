package study;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class sp_Stream {
    public static void main(String[] args) {
        /*1.스트림 생성한다.*/
        List<String> list = Arrays.asList("a","b","c");

        Stream<String> listStream = list.stream();

        //배열로부터 스트림을 생성한다. -배열의 원소들을 소스로하는 Stream을 생성하기 위해서는 Stream의 of메소드 또는 Arrays의 stream메소드를 사용한다.
        Stream<String> stream = Stream.of("a","b","c");
        Stream<String> stream1 = Stream.of(new String[]{"a","b","c"});
        Stream<String> stream2 = Arrays.stream(new String[]{"a","b","c"});
        Stream<String> stream3 = Arrays.stream(new String[]{"a","b","c"},0,3);
        //원시 Stream 생성 - IntStream의 경우는 range()함수를 사용하여 기존의 for문을 대체할 수 있다.
        IntStream stream4 = IntStream.range(4,10);

        /*2.스트림 가공한다.
        * 생성한 Stream 객체에서 요소들을 가공하기 위해서는 중간 연산이 필요하다. 가공하기 단계의 파라미터로는 앞서 설명하였던 함수형 인터페이스들이 사용되며, 여러 개의 중간 연산이 연결되도록 반환값으로 Stream을 반환한다.*/
        //필터링
        //Filter는 Stream에서 조건에 맞는 데이터만을 정제하여 더 작은 컬렉션으로 만들어내는 연산이다. java에서는 filter함수의 인자로 함수형 인터페이스 predicate를 받고 있기 때문에,
        //boolean을 반환하는 람다식을 작성하여 filter 함수를 구현할 수 있다.
        //예를 들어, 어떤 String의 stream에서 a가 들어간 문자열만을 포함하도록 필터링하는 예제는 다음과 같이 작성할 수 있다.
        Stream<String> stream5 =
                list.stream()
                        .filter(name -> name.contains("a"));

        //데이터 변환 -Map
        //Map은 기존의 Stream 요소들을 변환하여 새로운 Stream을 형성하는 연산이다. 저장된 값을 특정한 형태로 변환하는데 주로 사용되며, Java에서는 map함수의 인자로 함수형 인터페이스 function을 받고있다.
        //예를 들어 String을 요소들로 갖는 Stream을 모두 대문자 String의 요소들로 변환하고자 할 때 map을 이용할 수 있다.


        Stream<File> fileStream = Stream.of(new File("Test1.java"),new File("Test2.java"),new File("Test3.java"));
        Stream<String> fileNameStream = fileStream.map(File::getName);

        //정렬 - Sorted
        //Stream의 요소들을 정렬하기 위해서는 sorted를 사용해야 하며, 파라미터로 Comparator를 넘길 수도 있다.
        //Comparator 인자 없이 호출할 경우에는 오름차순으로 정렬이 되며, 내림차순으로 정렬하기 위해서는 Comparator의 reverseOrder를 이용하면 된다.
        //예를 들어 어떤 Stream의 String 요소들을 정렬하기 위해서는 다음과 같이 sorted를 활용할 수 있다.
        List<String> list1 = Arrays.asList("Java","Scala","Groovy","Python","Go","Swift");

        Stream<String> stream6 = list1.stream()
                .sorted();

        Stream<String> stream7 = list.stream()
                .sorted(Comparator.reverseOrder());

        //중복 제거 - Distinct
        //Stream의 요소들에 중복된 데이터가 존재하는 경우, 중복을 제거하기 위해 distinct를 사용할 수 있다. distinct는 중복된 데이터를 검사하기 위해 Object의 equals()메소드를 사용한다.
        //예를 들어 중복된 Stream의 요소들을 제거하기 위해서는 아래와 같이 distinct()를 사용할 수 있다.
        List<String> list2 = Arrays.asList("Java","Scala","Groovy","Python","Go","Swift","Java");
        Stream<String>stream8 = list.stream()
                .distinct();

        //특정 연산 수행 - Peek
        //Stream의 요소들을 대상으로 Stream에 영향을 주지 않고 특정 연산을 수행하기 위한 Peek함수가 존재한다.
        //확인해본다 라는 뜻을 지닌 peek단어처럼, peek 함수는 Stream의 각각의 요소들에 대해 특정 작업을 수행할 뿐 결과에 영향을 주지 않는다.
        // 또한 peek함수는 파라미터로 함수형 인퍼테이스 consumer를 인자로 받는다.
        //예를 들어 어떤 stream의 요소들을 중간에 출력하기를 원할 때 다음과 같이 활용할 수 있다.
        int sum = IntStream.of(1,3,5,7,9)
                .peek(System.out::println)
                .sum();


    }
}
