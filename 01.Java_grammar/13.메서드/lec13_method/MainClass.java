package lec13_method;

public class MainClass {
	public static void main(String[] args) {
		
		// ��ü ����
		ChildClass child = new ChildClass();
		// �Ӽ����� �ʱ�ȭ
		child.age = 10;
		child.name = "choi";
		child.gender = "male";
		
				
		// �޼��� ȣ��
		child.getInfo(); // �л��� �������
		child.setInfo("Kim","female",15); // �л� �Ӽ����� ���� �޼���
		
		child.getInfo(); // �л��� �������
	}
}
