package supplement;

public class Outer {
    int a=10;
    static int b=20;

    public void print(){
        System.out.println("print");
    }

    class Inner{
        int c=30;

        public void foo(){
            System.out.println("foo()");
        }
    }

    class Sinner{
        int d=40;
        void bar(){
            System.out.println("bar()");
        }
        static void baz(){
            System.out.println("baz()");
        }
    }
}
