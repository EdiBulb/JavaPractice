package self_study;

class Student{
    String name;
    Student(String name){
        this.name = name;
    }
    public boolean equals(Object obj){

        Student s = (Student) obj;
        return this.name == s.name;
    }
}

public class ObjectDemo {
    public static void main(String[] args) {

        String s3 = new String("ss");
        String s4 = new String("ss");
        String s5 = new String("s5");

        System.out.println(s3.equals(s4));
        System.out.println(s3==s4);
        System.out.println(s3.equals(s5));
    }
}
