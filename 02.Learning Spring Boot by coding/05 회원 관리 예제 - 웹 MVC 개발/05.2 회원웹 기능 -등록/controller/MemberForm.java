package hello.hellospring.controller;

//웹 등록 화면에서 데이터를 전달 받을 폼 객체
public class MemberForm {
    private String name; // 스프링이 웹에서 input 태그에 입력된 name 으로 연결 됨

    // 단축키 컨트롤+인서트 : gettet setter 자동완성
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
