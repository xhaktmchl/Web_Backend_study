package lec26_Exception;

public class MainClass02 {
	public static void main(String[] args) {
		MainClass02 mainClass02 = new MainClass02();
		
		try {
			mainClass02.firstMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void firstMethod() throws Exception{
		secondMethod(); // ���ܹ߻� -> MainClass02 �� ���� �ѱ�
	}
	public void secondMethod() throws Exception{
		thirdMethod(); // ���ܹ߻� -> firstMethod �� ���� �ѱ�
	}
	public void thirdMethod() throws Exception {
		System.out.println(10/0); // ���ܹ߻� -> secondMethod �� ���� �ѱ�
	}
}
