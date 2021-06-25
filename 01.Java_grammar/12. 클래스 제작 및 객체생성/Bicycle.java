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
