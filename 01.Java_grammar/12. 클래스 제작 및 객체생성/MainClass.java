package lec12_class;

public class MainClass {
	public static void main(String[] args) {
		
		// 생성자로 객체 생성 = 메모리 할당
		Granduer mycar = new Granduer(); // 객체는 c언어의 구조체와 같은데 함수가 포함된 구조체라 생각
		
		// 변수설정
		mycar.color = "red";
		mycar.gear = "5";
		mycar.price = 1000;
		
		//객체의 메소드 실행
		mycar.run();
		mycar.stop();
		mycar.info();
		
		//////////////////////////////////////////////////////
		
		// 인수 있는 객체 생성
		Bicycle mycar2 = new Bicycle("blue",200);
		
		// 변수설정
		mycar.gear = "2"; // 나머지 변수는 생성자에서 초기화 됨 / 필요시 변경
		
		//객체의 메소드 실행
		mycar2.run();
		mycar2.stop();
		mycar2.info();
		
	}
}
