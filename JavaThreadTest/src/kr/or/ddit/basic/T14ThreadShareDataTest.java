package kr.or.ddit.basic;

/*
 * 원주율을 계산하는 스레드가 있고, 계산된 원주율을 출력하는 스레드가 있다.
 * 원주율을 계산한 후 이 값을 출력하는 프로그램을 작성하시오.
 * (이때 원주율을 저장하는 객체가 필요하다.)
 * */
public class T14ThreadShareDataTest {

	public static void main(String[] args) {
		ShareData sd= new ShareData();
		CalcPIThread cth = new CalcPIThread(sd);
		PrintPIThread pth = new PrintPIThread(sd);
		
		cth.start();
		pth.start();
	}
}

class ShareData {
	private double result; // 원주율이 저장될 변수
	private boolean isOk = false; // 원주율 계산 완료여부 확인용.

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

}

//원주율 계산을 위한 스레드 클래스
class CalcPIThread extends Thread {

	private ShareData sd;

	public CalcPIThread(ShareData sd) {
		this.sd = sd;
	}

	@Override
	public void run() {
		/*
		 * 원주율 = (1/1 - 1/3 + /5 - 1/7 + 1/9 .....) * 4;
		 * 			1  -  3  +  5 -  7  +  9 => 분모
		 * 			0	  1     2    3     4 => 분모를 2로 나눈 몫
		 * */

		double sum = 0.0;
		for (int i = 1; i < 15000000; i += 2) {
			if (((i / 2) % 2) == 0) {

			} else {
				sum -= (1.0 / i);
			}
		}
		sd.setResult(sum * 4);
		sd.setOk(true); // 원주율 계산이 완료되었음을 나타냄
	}

}

//계산된 원주율을 출력하는 스레드
class PrintPIThread extends Thread {

	private ShareData sd;

	public PrintPIThread(ShareData sa) {
		this.sd = sd;

	}

	@Override
	public void run() {
		while (true) {
			// 원주율 계산이 완료 될때까지 기다린다.
			if (sd.isOk()) {
				break;
			}
		}

		System.out.println();
		System.out.println("계산된 원주율 : " + sd.getResult());
		System.out.println("       PI : " + Math.PI);

	}

}
