package lec9_if;

import java.util.Scanner;

public class lec9_if_switch {
	public static void main(String[] args) {
		Scanner inputNum = new Scanner(System.in);
		int score = inputNum.nextInt();
		
		switch(score) {
		case 90:
			System.out.println("점수는 "+score+"점");
			break;
			
		case 80:
			System.out.printf("점수는 %d점",score);
			break;
		}
	}
	
	
}
