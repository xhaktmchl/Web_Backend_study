package lec10_for_while;

import java.util.Scanner;

public class lec10_for {
	public static void main(String[] args) {
		Scanner inputNum = new Scanner(System.in);
		int score = inputNum.nextInt();
		
		
		for(int i=0;i<10;i++) {
			System.out.println(score*i);
		}
	}
}
