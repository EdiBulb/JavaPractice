package homework;

public class exam05 {

    //전역 변수
    static int var = 100;
    public static void main(String[] args) {
        //지역 변수
        int var = 0;
        System.out.println(var);

        //지역 변수
        int sum = addFunction(10,20);
        System.out.println(sum);
    }

    static int addFunction(int num1,int num2){
        //지역 변수
        int hap;
        hap = num1 +num2 + var;
        return hap;
    }
}