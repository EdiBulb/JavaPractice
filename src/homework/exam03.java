package homework;

public class exam03 {
    public static void main(String[] args) {
        int count = 85;
        if(count >=90){
            System.out.println("if : 합격 (장학생)");
        } else if(count >=60){
            System.out.println("if문 : 합격");
        } else{
            System.out.println("if문 : 불합격");
        }

        String s = new String("ssss");
        s.length();

        String str1 = "Asd"; // = new String("Asd"); //str1 = 0xAA;
        String str2 = "dgg"; // = new String("dgg"); //str2 = 0xAb;

        if(str1==str2) { ... } //xxx
        if(str1.equals(str2)) { ... }


        int[] arr = new int[5];
        arr.leng

        String[] att = new String[5];
        att.length

        int jumsu = (count/10)*10;
        switch (jumsu){
            case 100:
            case 90:
                System.out.println("switch문 : 합격(장학생)");
                break;
            case 80:
            case 70:
            case 60:
                System.out.println("switch문 : 합격");
                break;
            default:
                System.out.println("switch문 : 불합격");
        }
    }
}
