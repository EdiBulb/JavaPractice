package supplement;

class Test{
    public void test(String a, String b) throws NumberFormatException{
        try {
            int sum = Integer.parseInt(a)+Integer.parseInt(b);
            System.out.println("문자로 입력받은 "+a+","+b+"의 합은 "+sum+"입니다.");

        }catch (NumberFormatException e){
            System.out.println("숫자형 문자가 아닙니다. 형변환 안됨");
            throw e;
        }
    }
}
public class java30 {
    public static void main(String[] args) {
        Test test = new Test();
        try {
            test.test("1","ㄱ");

        }catch (NumberFormatException e){
            System.out.println("입력하신 값은 숫자가 아닙니다.");
        }

    }
}
