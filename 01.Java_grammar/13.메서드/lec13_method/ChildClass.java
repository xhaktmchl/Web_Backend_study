package lec13_method;

public class ChildClass {
	// ���� ����
	public String name;
	public String gender;
	public int age;
	
	// ������
	public ChildClass() {
		System.out.println("ChildClass constructor");
	}
	
	// �޼���
	public void setInfo(String na,String gen,int ag) { // �л��� �̸� ���� ���� ������ ���� �޼���
		System.out.println("-------setInfo start0---------");
		
		name = na;
		gender = gen;
		age = ag;
	}
	public void getInfo() { // �л��� �̸� ���� ���� ���� ��� �޼���
		System.out.println(" --- getInfo start ---");
		System.out.println("name:"+name);
		System.out.println("gender:"+gender);
		System.out.println("age:"+age);

	}
	
	private void secrete() { // private ������ �޼���
		System.out.println("-- private method--");
	}
}
