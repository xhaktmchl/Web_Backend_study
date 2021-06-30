package lec26_Exception;

public class MainClass {
	public static void main(String[] args) {
		int a=10;
		int b=0;
		int c=0;
		
		System.out.println(" --before exception---");
		
		//  예외처리
		// try 하고 옵션 단축키
		try {
			c = a/b; // 예외 코드
		} catch (Exception e) { // 예외처리코드
			e.printStackTrace(); // 어떤 예외인지 출력 메서드
			String msg = e.getMessage(); // 메시지 추출 메서드
			System.out.println("msg :"+msg);
		} finally { // 
			System.out.println("예외 상관없이 반드시 실행");
		}
		
		System.out.println(" --after exception---");
	}
}
