package Exercise04;

import java.util.Scanner;

/**
 * 사용자로부터 5과목의 점수를 입력받아 평균을 구하는 프로그램을 작성하여 보자. 
 * 평균 점수로 학점을 계산하여 출력한다.(평균 점수는 소숫점 둘째자리까지만 출력)
 * 평균 점수가 90점 이상이면 A, 
 * 80점 이상 90점 미만이면 B, 
 * 70점 이상 80점 미만이면 C, 
 * 60점 이상 70점 미만이면 D, 
 * 60점 미만이면 F로 계산한다.
 *
 */
public class Exercise43 {
	public static void main(String[] args) {
		
		//입력
		Scanner scanner = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		System.out.print("프로그래밍 기초: ");
		int basic = scanner.nextInt();
		
		System.out.print("데이터베이스: ");
		int dB = scanner.nextInt();
		
		System.out.print("화면 구현: ");
		int screen = scanner.nextInt();
		
		System.out.print("애플리케이션 구현: ");
		int applications= scanner.nextInt();
		
		System.out.print("머신러닝 : ");
		int machine= scanner.nextInt();
		
		//처리
		int total = basic + dB + screen + applications + machine;
		double average = total/5.0;
		String credit ="";
		
		if(average >= 90) {
			credit = "A";
		} else if(average >=80) {
			credit = "B";
		} else if(average >=70) {
			credit = "C";
		} else if(average >=60) {
			credit = "D";
		} else {
			credit= "F";
		}
				
		//출력
		System.out.println("총점: " + total);
		System.out.println("평균: " + average);
		System.out.println("학점: " + credit);
	}

}
