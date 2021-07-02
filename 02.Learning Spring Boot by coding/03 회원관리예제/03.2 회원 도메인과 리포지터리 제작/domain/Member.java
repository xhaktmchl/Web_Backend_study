package hello.hellospring.domain;

public class Member {
    // 멤버 변수
    public Long id; // 회웡 아이디
    public String name; // 회원 이름

    // 메서드
    public Long getId() { // ID 조회 메서드
        return id;
    }
    public void setId(Long id){ // ID 입력 메서드
        this.id = id;
    }
    public String getName(){ // 이름 조회 메서드
        return name;
    }
    public void setName(String name){ // 이름 저장 메서드
        this.name = name;
    }
}
