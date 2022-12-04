package self_study;



public class Debug {

    public static void main(String[] args) {
        System.out.println("Start");
        function1();
        System.out.println("END");

    }

    static void function1(){
        System.out.println("111");
        Person person = new Person("A",30);
        person.run();
        function2();
        System.out.println("111");
    }
    static void function2(){
        System.out.println("function2");
    }
}
class Person{
    private String name;
    private int age;
    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    void run(){
        System.out.println("today...run...");
        System.out.println("i am"+this.name+"...");
        System.out.println("run... hard...");
    }
}