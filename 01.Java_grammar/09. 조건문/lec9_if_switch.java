package lec9_if;

import java.util.Scanner;

public class lec9_if_switch {
	public static void main(String[] args) {
		Scanner inputNum = new Scanner(System.in);
		int score = inputNum.nextInt();
		
		switch(score) {
		case 90:
			System.out.println("������ "+score+"��");
			break;
			
		case 80:
			System.out.printf("������ %d��",score);
			break;
		}
	}
	
	
}
