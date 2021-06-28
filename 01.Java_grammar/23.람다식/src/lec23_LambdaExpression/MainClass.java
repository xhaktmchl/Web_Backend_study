package lec23_LambdaExpression;

public class MainClass {
	public static void main(String[] args) {
		// 람다식 매개변수와 실행문 만으로 작성
		// (매개변수) -> {메서드 정의};
		LambdaInterface1 li1 = (String s1,String s2,String s3)->{System.out.println(s1+""+s2+""+s3);}; // 람다식을 {}묶고 ; 붙혀야 됨
		li1.method("hello","java","world");
		
		// 매개변수가 1개이거나 자료형이 같으면 자료형 생략
		LambdaInterface2 li2 = (s1) -> {System.out.println(s1);};
		li2.method("자료형 1개여서 생략");
		
		// 실행문이 1개일 경우 {} 생략가능
		LambdaInterface2 li3 = (s1)-> System.out.println(s1);
		li3.method("실행문 1개면 {} 생략");
		
		// 매개변수 실행문이 1개면 () {} 생략 가능
		LambdaInterface2 li4 = s1-> System.out.println(s1);
		li4.method("매개변수 실행문이 1개면 () {} 생략 가능");
		
		// 매개변수 없으면 () 만 작성
		LambdaInterface3 li5 = ()->System.out.println("파라미터 없음");
		
		// 반환값이 있는 경우
		LambdaInterface4 li6 = (int x,int y)-> { // 매개변수-> 함수정의
			// 실행문 정의
			int result = x+y;
			return result;
		};
		System.out.println(li6.method(1, 2)); 
		
		// 만들어진 인터페이스 객체 재정의
		li6 = (int x,int y)-> { // 매개변수-> 함수정의
			// 실행문 재정의
			int result = x-y;
			return result;
		};
		System.out.println(li6.method(1, 2)); 
		
	}
} 
