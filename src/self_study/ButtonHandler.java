package self_study;

public class ButtonHandler {

    Button endButton = new Button();
    Button startButton = new Button();

    Button.OnclickListener listener = new Button.OnclickListener() {
        @Override
        public void onClick() {
            System.out.println("프로그램을 종료합니다.");
        }
    };

    ButtonHandler(){
        //위 필드에서 생성한 익명구현 객체로 endButton Listener 세팅
        endButton.setOnclickListener(listener);

        //startButton Listener 세팅하는 메서드 호출과 동시에 익며 구현 객체 정의하기
        startButton.setOnclickListener(new Button.OnclickListener() {
            @Override
            public void onClick() {
                System.out.println("프로그램을 시작합니다.");
            }
        });
    }
}
