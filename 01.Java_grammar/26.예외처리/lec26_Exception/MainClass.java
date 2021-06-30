package lec26_Exception;

public class MainClass {
	public static void main(String[] args) {
		int a=10;
		int b=0;
		int c=0;
		
		System.out.println(" --before exception---");
		
		//  ����ó��
		// try �ϰ� �ɼ� ����Ű
		try {
			c = a/b; // ���� �ڵ�
		} catch (Exception e) { // ����ó���ڵ�
			e.printStackTrace(); // � �������� ��� �޼���
			String msg = e.getMessage(); // �޽��� ���� �޼���
			System.out.println("msg :"+msg);
		} finally { // 
			System.out.println("���� ������� �ݵ�� ����");
		}
		
		System.out.println(" --after exception---");
	}
}
