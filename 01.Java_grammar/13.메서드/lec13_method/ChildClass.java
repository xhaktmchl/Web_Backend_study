package lec13_method;

public class ChildClass {
	// 변수 선언
	public String name;
	public String gender;
	public int age;
	
	// 선언자
	public ChildClass() {
		System.out.println("ChildClass constructor");
	}
	
	// 메서드
	public void setInfo(String na,String gen,int ag) { // 학생의 이름 나이 성별 변수값 대입 메서드
		System.out.println("-------setInfo start0---------");
		
		name = na;
		gender = gen;
		age = ag;
	}
	public void getInfo() { // 학생의 이름 나이 성별 정복 출력 메서드
		System.out.println(" --- getInfo start ---");
		System.out.println("name:"+name);
		System.out.println("gender:"+gender);
		System.out.println("age:"+age);

	}
	
	private void secrete() { // private 접근자 메서드
		System.out.println("-- private method--");
	}
}
