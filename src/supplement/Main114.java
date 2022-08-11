package supplement;

class FoolException extends Exception{

}
public class Main114 {

    public void sayNick(String nick) throws FoolException{
       // try {
            if("fool".equals(nick)){
                throw new FoolException();

            }
            System.out.println("당신의 별명은 "+nick+"입니다.");
      //  }catch (FoolException e){
     //       System.out.println("FoolException이 발생했습니다.");
        //}

    }

    public static void main(String[] args) {

        Main114 sample = new Main114();
//        sample.sayNick("fool");
//        sample.sayNick("genious");
    }
}
