package lec13_method;

public class MainClass {
	public static void main(String[] args) {
		
		// 객체 생성
		ChildClass child = new ChildClass();
		// 속성변수 초기화
		child.age = 10;
		child.name = "choi";
		child.gender = "male";
		
				
		// 메서드 호출
		child.getInfo(); // 학생의 정보출력
		child.setInfo("Kim","female",15); // 학생 속성변수 대입 메서드
		
		child.getInfo(); // 학생의 정보출력
	}
}
