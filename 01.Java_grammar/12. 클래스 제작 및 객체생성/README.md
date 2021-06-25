
##12-1 클래스 제작

- 멤버변수선언생성자 생성메소드 정의

- public 은 전역 변수 느낌



실습)

package lec12_class;

public class Bicycle {

	// 멤버 변수

	public String color; // public 은 전역변수 느낌

	public String gear;

	public int price;

	// 인수 있는 생성자 

	public Bicycle(String col,int pri) {

		System.out.println("Bicycle constructor");

		color = col; // 어차피 객체 안 이어서 Bicycle참조 없어야 함

		price = pri;

	}

	// 메소드

		public void run() {

			System.out.println("run method");

		}

		public void stop() {

			System.out.println("stop method");

		}

		public void info() {

			System.out.println("color:"+ color);

			System.out.println("gear:"+ gear);

			System.out.println("price:"+ price);

		}

}



##12-2 객체생성





실습)

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



##12-3 생성자

인수 없는 경우인수 있는 경우

: 클래스 안에서 생성자에 인수 선언 -> 메인 클래스에서 객체 생성시 생성자에 인수 값 넣어야 함

예)

// 인수 있는 생성자 

	public Bicycle(String col,int pri) {

		System.out.println("Bicycle constructor");

		color = col; // 어차피 객체 안 이어서 Bicycle참조 없어야 함

		price = pri;

	}

