package self_study;

public class Button {
    //인터페이스 타입 필드
    OnclickListener listener;

    void setOnclickListener(OnclickListener listener){
        this.listener = listener;
    }

    //구현 객체의 onClick() 메서드 호출한다.
    void touch(){
        listener.onClick();
    }


    //중첩 인터페이스
    interface OnclickListener{
        void onClick();
    }
}
