package kr.or.ddit.basic;

/*
 * 은행의 입출금을 스레드로 처리하는 예제
 * */
public class T16SyncAccountTest {
	public static void main(String[] args) {

	}

}

//은행의 입출금을 관리하는 클래스(공유객체)
class SyncAccount {
	private int balance;

	public int getBalance() {
		return balance;
	}

	// 입금 처리를 수행하는 메서드
	public void deposit(int money) {
		balance += money;
	}

	// 출금 처리하는 메서드(출금 성공 : true, 출금 실패: false 반환)
	// 동기화 영역에서 호출하는 메서드도 동기화 처리를 해 주여야 한다.
	public boolean withdraw(int money) {
		if (balance >= money) {
			// 잔액이 많을 경우...

			for (int i = 1; i <= 1000000000; i++) {
			}
			balance -= money;
			System.out.println("메서드 안에서 balance =" + getBalance());
			return true;

		} else {
			return false;
		}
	}
}

//은행 업무를 처리하는 스레드
class BankThread extends Thread {
	private SyncAccount sAcc;

	public BankThread(SyncAccount sAcc) {
		this.sAcc = sAcc;

	}

	@Override
	public void run() {
		boolean result = sAcc.withdraw(6000); // 6000dnjs dlscnf
		System.out.println("스레드안에서 result =" + result + ", balance = " + sAcc.getBalance());

	}
}
