package homework;

interface clickListener{
    public void print();
}

public class exam13 {
    public static void main(String[] args) {
        clickListener listener = (new clickListener() {
            @Override
            public void print() {
                System.out.println("클릭 리스너입니다.");
            }
        });

        System.out.println("b684002 byeonghun");
    }
}
