package lec12_class;

public class Bicycle {
	// ��� ����
	public String color; // public �� �������� ����
	public String gear;
	public int price;
	
	// �μ� �ִ� ������ 
	public Bicycle(String col,int pri) {
		System.out.println("Bicycle constructor");
		
		color = col; // ������ ��ü �� �̾ Bicycle���� ����� ��
		price = pri;
		
	}
	
	// �޼ҵ�
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
