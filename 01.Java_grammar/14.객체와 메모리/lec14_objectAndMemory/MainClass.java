package lec14_objectAndMemory;

public class MainClass {
	public static void main(String[] args) { // 메인 함수
		// 객체 생성
		ObjectClass object1 = new ObjectClass();
		ObjectClass object2 = new ObjectClass();
		ObjectClass object3 = new ObjectClass();
		
		// 각각 생성된 객체의 주소가 다르다
		System.out.println("object1: "+object1);
		System.out.println("object2: "+object2);
		System.out.println("object3: "+object3);
		
		// 객체에 null 저장
		object1 = null;
		System.out.println("object1: "+object1);
		object1.getInfo(); // 객체와의 연결이 끊겼는데 호출하면 에러 발생

	}
}
