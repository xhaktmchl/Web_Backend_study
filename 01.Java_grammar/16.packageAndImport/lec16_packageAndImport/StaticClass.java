package lec16_packageAndImport;

public class StaticClass {
	// static 변수
	static int sum=0;
	
	// 생성자
	public StaticClass() {
		
	}
	
	// 공유된 static 변수를 이용해 합을 구하는 메서드 
	public void countsum(int n) {
		System.out.println(" -- count sum ---");
		sum+=n;
		System.out.println(sum);
	}
}
