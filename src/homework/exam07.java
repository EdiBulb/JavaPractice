package homework;

public class exam07 {
    public static void main(String[] args) {
        Car myCar1 = new Car("빨강",0);
//        myCar1.color = "빨강";
//        myCar1.speed = 0;

        Car myCar2 = new Car("파랑",0);
//        myCar2.color = "파랑";
//        myCar2.speed = 0;

        Car myCar3 = new Car("초록",0);
//        myCar3.color = "초록";
//        myCar3.speed = 0;

        myCar1.upSpeed(50);
        System.out.println("자동차 1의 색상은 "+myCar1.getColor()
            +"이며, 속도는 "
            +myCar1.getSpeed() + "km입니다.");

        myCar2.downSpeed(20);

        System.out.println("자동차 2의 색상은 "+ myCar2.getColor()
            +"이며, 속도는 "
            +myCar1.getSpeed() + "km입니다.");

        myCar3.upSpeed(250);
        System.out.println("자동차 3의 색상은 "+ myCar3.getColor()
            +"이며, 속도는 "
            +myCar3.getSpeed() + "km입니다.");
    }
}