package lec14_objectAndMemory;

public class MainClass {
	public static void main(String[] args) { // ���� �Լ�
		// ��ü ����
		ObjectClass object1 = new ObjectClass();
		ObjectClass object2 = new ObjectClass();
		ObjectClass object3 = new ObjectClass();
		
		// ���� ������ ��ü�� �ּҰ� �ٸ���
		System.out.println("object1: "+object1);
		System.out.println("object2: "+object2);
		System.out.println("object3: "+object3);
		
		// ��ü�� null ����
		object1 = null;
		System.out.println("object1: "+object1);
		object1.getInfo(); // ��ü���� ������ ����µ� ȣ���ϸ� ���� �߻�

	}
}
