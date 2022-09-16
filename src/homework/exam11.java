package homework;

public class exam11 {
    public static void main(String[] args) {
        Animal animal;

        animal = new Tiger();
        animal.move();

        animal = new Eagle();
        animal.move();
        System.out.println("b684002 byeonghun");

        //다형성 ; 자신의 서브 클래스에서 생선한 인스턴스도 클래스 변수에 대입할 수 있는 것
        // 다형성을 하면 뭐가 좋지?

    }
}
