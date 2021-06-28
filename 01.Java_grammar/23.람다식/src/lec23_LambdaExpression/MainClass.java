package lec23_LambdaExpression;

public class MainClass {
	public static void main(String[] args) {
		// ���ٽ� �Ű������� ���๮ ������ �ۼ�
		// (�Ű�����) -> {�޼��� ����};
		LambdaInterface1 li1 = (String s1,String s2,String s3)->{System.out.println(s1+""+s2+""+s3);}; // ���ٽ��� {}���� ; ������ ��
		li1.method("hello","java","world");
		
		// �Ű������� 1���̰ų� �ڷ����� ������ �ڷ��� ����
		LambdaInterface2 li2 = (s1) -> {System.out.println(s1);};
		li2.method("�ڷ��� 1������ ����");
		
		// ���๮�� 1���� ��� {} ��������
		LambdaInterface2 li3 = (s1)-> System.out.println(s1);
		li3.method("���๮ 1���� {} ����");
		
		// �Ű����� ���๮�� 1���� () {} ���� ����
		LambdaInterface2 li4 = s1-> System.out.println(s1);
		li4.method("�Ű����� ���๮�� 1���� () {} ���� ����");
		
		// �Ű����� ������ () �� �ۼ�
		LambdaInterface3 li5 = ()->System.out.println("�Ķ���� ����");
		
		// ��ȯ���� �ִ� ���
		LambdaInterface4 li6 = (int x,int y)-> { // �Ű�����-> �Լ�����
			// ���๮ ����
			int result = x+y;
			return result;
		};
		System.out.println(li6.method(1, 2)); 
		
		// ������� �������̽� ��ü ������
		li6 = (int x,int y)-> { // �Ű�����-> �Լ�����
			// ���๮ ������
			int result = x-y;
			return result;
		};
		System.out.println(li6.method(1, 2)); 
		
	}
} 
