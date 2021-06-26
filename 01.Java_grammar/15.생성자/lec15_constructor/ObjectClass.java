package lec15_constructor;

public class ObjectClass {
	public int num;
	
	
	// 사용자 정의 생성자
	public ObjectClass(String s,int i) {
		System.out.println("---ObjectClass constructor ---");
		System.out.println(i+s);
	}
	
	
	// this 키워드는 현재 객체를 가리킴
	public ObjectClass(int num) {
		this.num = num; // 객체 생성시 인수로 받는 변수 객체 변수에 저장
	}
}
