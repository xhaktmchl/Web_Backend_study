package lec8;

import java.util.Arrays;

public class Lec8_arraymemory {
	public static void main(String[] args) {
		
		// �迭 �⺻ �Ӽ�
		int[] ar1 = {1,2,3,4,5,6};
		int[] ar2 = null;
		int[] ar3 = null;
		
		// �迭 ����
		System.out.println(ar1.length);
		
		// ���� �迭 ���ڷ� ���
		System.out.println(Arrays.toString(ar1));
		
		// �迭 ��� ����
		ar3 = Arrays.copyOf(ar1,ar1.length); // Arrays �� ���� ��
		System.out.println("ar3 = "+ ar3); // ar3�� ���� ������ ��ü �ּ� 
		
		//  �迭 ���۷���
		ar2 = ar1;
		System.out.println("ar1 = "+ ar1); // ��ü �ڷ����� �ּ� ����
		System.out.println("ar2 = "+ ar2);
		System.out.println("ar3 = "+ ar3); // ar3�� ���� ������ ��ü �ּ� 
		
		// ������ �迭
		int[][] ar4 = new int[3][2]; // 3�� 2�� �迭 ���� // int[] �� ������ ǥ�� �� ��
		ar4[0][1] = 10;
		System.out.println(ar4[0]);
		System.out.println(Arrays.toString(ar4[0]));
	}
}
