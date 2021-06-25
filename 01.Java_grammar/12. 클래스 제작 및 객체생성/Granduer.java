package lec12_class;

public class Granduer {
	// 멤버 변수 
	public String color;
	public String gear;
	public int price;
	
	// 생성자
	public Granduer() { // 클래스 이름과 같은 Granduer 먼저 치고 ctrl+space 하면 생성자 자동생성
		System.out.println("Granduer constructor");
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
