package lec12_class;

public class Granduer {
	// ��� ���� 
	public String color;
	public String gear;
	public int price;
	
	// ������
	public Granduer() { // Ŭ���� �̸��� ���� Granduer ���� ġ�� ctrl+space �ϸ� ������ �ڵ�����
		System.out.println("Granduer constructor");
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
