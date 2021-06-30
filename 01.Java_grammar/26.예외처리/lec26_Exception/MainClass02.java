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
		secondMethod(); // 예외발생 -> MainClass02 로 예외 넘김
	}
	public void secondMethod() throws Exception{
		thirdMethod(); // 예외발생 -> firstMethod 로 예외 넘김
	}
	public void thirdMethod() throws Exception {
		System.out.println(10/0); // 예외발생 -> secondMethod 로 예외 넘김
	}
}
