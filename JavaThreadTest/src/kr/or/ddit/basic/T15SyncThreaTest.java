package kr.or.ddit.basic;

public class T15SyncThreaTest {

	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		WorkerThread th1 = new WorkerThread("1번 스레드", sObj);
		WorkerThread th2 = new WorkerThread("2번 스레드", sObj);
		
		th1.start();
		th2.start();
		
	}

}

//공통으로 사용할 객체
class ShareObject {
	private int sum = 0;

	public void add() {
		for (int i = 0; i < 1000000000; i++) {} //시간떄우기용

			int n = sum;
			n += 10;
			sum = n;

			System.out.println(Thread.currentThread().getName() + "합계: " + sum);

		}
	}

	// 작업을 수행할 스레드
	class WorkerThread extends Thread {
		private ShareObject sObj;

		public WorkerThread(String name, ShareObject sobj) {
			super(name);
			this.sObj = sobj;
		}

		@Override
		public void run() {
			for (int i = 1; i <= 10; i++) {
				sObj.add();
			}
		}
	}


