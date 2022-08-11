package supplement;

public class ThrowsDemo {
    public static void main(String[] args) {
        try{
            ThrowsDemo td=new ThrowsDemo();
            td.test();
        }catch (ArithmeticException e){
            System.out.println("aaaaaa");
        }
    }
    public void test() throws ArithmeticException{
        System.out.println(3/0);
    }
}
