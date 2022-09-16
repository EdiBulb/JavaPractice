package homework;

interface iAnimal{
    abstract void eat();
}

public class exam12 {
    public static void main(String[] args) {
        iCat cat = new iCat();
        cat.eat();

        iTiger tiger = new iTiger();
        tiger.move();
        tiger.eat();
        System.out.println("b684002 byeonghun");
    }

    static class iCat implements iAnimal{

        @Override
        public void eat() {
            System.out.println("like fish");
        }
    }

    static class iTiger extends Animal implements iAnimal{
        void move(){
            System.out.println("move with 4 legs");
        }

        @Override
        public void eat() {
            System.out.println("eat wild pig");
        }

    }
}
