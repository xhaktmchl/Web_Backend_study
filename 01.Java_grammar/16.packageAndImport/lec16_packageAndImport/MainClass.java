package lec16_packageAndImport;

import otherPackage.OtherClass; // otherPackage 패키지 클래스 import // 패키지.클래스
import otherPackage.*; // 외부 패키지의 모든 클래스 import

public class MainClass {
	public static void main(String[] args) {
		OtherClass other = new OtherClass(); // 외부에서 가져온 객체 생성
		
		
		// static 변수 사용 
		StaticClass class1 = new StaticClass();
		StaticClass class2 = new StaticClass();
		// 서로다른 객체이지만 static 변수 사용으로 공유 합 계산
		class1.countsum(1);
		class2.countsum(2);
	}
	
}
