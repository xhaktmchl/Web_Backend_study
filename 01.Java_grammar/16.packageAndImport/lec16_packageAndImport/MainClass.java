package lec16_packageAndImport;

import otherPackage.OtherClass; // otherPackage ��Ű�� Ŭ���� import // ��Ű��.Ŭ����
import otherPackage.*; // �ܺ� ��Ű���� ��� Ŭ���� import

public class MainClass {
	public static void main(String[] args) {
		OtherClass other = new OtherClass(); // �ܺο��� ������ ��ü ����
		
		
		// static ���� ��� 
		StaticClass class1 = new StaticClass();
		StaticClass class2 = new StaticClass();
		// ���δٸ� ��ü������ static ���� ������� ���� �� ���
		class1.countsum(1);
		class2.countsum(2);
	}
	
}
