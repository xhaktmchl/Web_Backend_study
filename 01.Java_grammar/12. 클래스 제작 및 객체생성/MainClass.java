package lec12_class;

public class MainClass {
	public static void main(String[] args) {
		
		// �����ڷ� ��ü ���� = �޸� �Ҵ�
		Granduer mycar = new Granduer(); // ��ü�� c����� ����ü�� ������ �Լ��� ���Ե� ����ü�� ����
		
		// ��������
		mycar.color = "red";
		mycar.gear = "5";
		mycar.price = 1000;
		
		//��ü�� �޼ҵ� ����
		mycar.run();
		mycar.stop();
		mycar.info();
		
		//////////////////////////////////////////////////////
		
		// �μ� �ִ� ��ü ����
		Bicycle mycar2 = new Bicycle("blue",200);
		
		// ��������
		mycar.gear = "2"; // ������ ������ �����ڿ��� �ʱ�ȭ �� / �ʿ�� ����
		
		//��ü�� �޼ҵ� ����
		mycar2.run();
		mycar2.stop();
		mycar2.info();
		
	}
}
