package lec8;

import java.util.Arrays;

public class Lec8_arraymemory {
	public static void main(String[] args) {
		
		// 배열 기본 속성
		int[] ar1 = {1,2,3,4,5,6};
		int[] ar2 = null;
		int[] ar3 = null;
		
		// 배열 길이
		System.out.println(ar1.length);
		
		// 숫자 배열 문자로 출력
		System.out.println(Arrays.toString(ar1));
		
		// 배열 요소 복사
		ar3 = Arrays.copyOf(ar1,ar1.length); // Arrays 가 에러 남
		System.out.println("ar3 = "+ ar3); // ar3는 새로 생성된 객체 주소 
		
		//  배열 레퍼런스
		ar2 = ar1;
		System.out.println("ar1 = "+ ar1); // 객체 자료형은 주소 저장
		System.out.println("ar2 = "+ ar2);
		System.out.println("ar3 = "+ ar3); // ar3는 새로 생성된 객체 주소 
		
		// 다차원 배열
		int[][] ar4 = new int[3][2]; // 3행 2열 배열 생성 // int[] 는 포인터 표시 인 듯
		ar4[0][1] = 10;
		System.out.println(ar4[0]);
		System.out.println(Arrays.toString(ar4[0]));
	}
}
