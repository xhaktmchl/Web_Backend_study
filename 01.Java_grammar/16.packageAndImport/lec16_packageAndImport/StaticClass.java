package lec16_packageAndImport;

public class StaticClass {
	// static ����
	static int sum=0;
	
	// ������
	public StaticClass() {
		
	}
	
	// ������ static ������ �̿��� ���� ���ϴ� �޼��� 
	public void countsum(int n) {
		System.out.println(" -- count sum ---");
		sum+=n;
		System.out.println(sum);
	}
}
