package supplement;

public class FinallyTest {
    public static void main(String[] args) {
        try{
            System.out.println(3/0);
            System.out.println("2");
        }catch (Exception e){
            System.out.println("3/0은 할 수 없습니다.");
        }finally {
            System.out.println("finally{}블록은 예외와 상관없이 실행되어야할 부분입니다.");
        }
    }
}
