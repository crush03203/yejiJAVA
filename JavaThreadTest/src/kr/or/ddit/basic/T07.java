package kr.or.ddit.basic;
/*
 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 * 
 * 컴퓨터와 가위 바위 보는 난수를 이용하여 구하고
 * 사용자의 가위 바위 보는 showInputDialog()메서드를 이용하여 입력
 * 받는다
 * 
 * 입력시간은 5초로 제한하고 카운트 다운을 진행한다.
 * 5초안에 입력이 없으면 게임을 진 것으로 처리한다.
 * 
 * 5초안에 입력이 완료되면 승패를 출력한다.
 * 
 * 결과예시)
 * ===결 과===
 * 컴퓨터 : 가위
 * 당 신  : 바위
 * 결 과  : 당신이 이겼습니다.
 * 
 * */
import java.util.Random;

import javax.swing.JOptionPane;

public class T07 {

	// 입력여부를 확인하기 위한 변수 선언(모든 스레드에서 공통으로 사용할 변수)
	public static boolean inputCheck = false;

	public static void main(String[] args) {

		Thread th1 = new Data();
		th1.start();

		Thread th2 = new Count();
		th2.start();

	}
}

// 데이터 입력을 받는 스레드 클래스
class Data extends Thread {

	   @Override
	   public void run() {
	      String str = JOptionPane.showInputDialog("가위 바위 보 게임~!");
	      System.out.println("입력한 값은 " + str + "입니다.");

	      Random random = new Random();
	      int c = random.nextInt(3);
	      String result = "";
	      String[] str2 = { "가위", "바위", "보" };
	      String computer = str2[c];

	      if (str.equals(computer)) {
	         result = "비겼습니다.";
	      } else if (str.equals("가위") && computer.equals("보") || str.equals("바위") && computer.equals("가위")
	            || str.equals("보") && computer.equals("바위")) {
	         result = "당신 승리!";
	      } else {
	         result = "컴퓨터 승리!";
	      }
	      System.out.println("=== 결 과 ===");
	      System.out.println("당신 : " + str);
	      System.out.println("컴퓨터: " + str2[c]);
	      System.out.println("결과: " + result);

	      T07.inputCheck = true;

	   }
	}

class Count extends Thread {

	@Override
	public void run() {

		for (int i = 5; i >= 1; i--) {
			if (T06ThreadTest.inputCheck == true) {
				return;
			}
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.exit(0); //프로그램 종료
	}
}