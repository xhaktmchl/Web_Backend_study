package lec15_constructor;

public class ObjectClass {
	public int num;
	
	
	// ����� ���� ������
	public ObjectClass(String s,int i) {
		System.out.println("---ObjectClass constructor ---");
		System.out.println(i+s);
	}
	
	
	// this Ű����� ���� ��ü�� ����Ŵ
	public ObjectClass(int num) {
		this.num = num; // ��ü ������ �μ��� �޴� ���� ��ü ������ ����
	}
}
