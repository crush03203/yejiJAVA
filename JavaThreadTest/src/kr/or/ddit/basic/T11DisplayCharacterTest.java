package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sound.sampled.LineListener;

public class T11DisplayCharacterTest {
	/*
	 * 3개(명)의 스레드가 각각 알파벳 대문자를 출력하는데 출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성하기.
	 * 
	 */

	static int currRank = 1; // 현재의 순위정보

	public static void main(String[] args) {
		List<DisPlayCharacter> disCharList = new ArrayList<DisPlayCharacter>();
		disCharList.add(new DisPlayCharacter("홍길동"));
		disCharList.add(new DisPlayCharacter("이순신"));
		disCharList.add(new DisPlayCharacter("강감찬"));

		for (Thread th : disCharList) {
			th.start();
		}
		for (Thread th : disCharList) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Collections.sort(disCharList);
		
		System.out.println("경기 끝...");
		System.out.println("---------------------");
		System.out.println("경기 결과");
		System.out.println();
		System.out.println("======================");
		System.out.println("순위\t:\t이름");
		System.out.println("---------------------");
		for (DisPlayCharacter dc : disCharList) {
			System.out.println(dc.getRank() + "\t:\t" + dc.getName());
		}
	}

}

//알파벡 대문자 출력하는 스레드
class DisPlayCharacter extends Thread implements Comparable<DisPlayCharacter> {

	private String name;
	private int rank;

	public DisPlayCharacter(String name) {
		super(name);
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public void run() {

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(name + "의 출력 문자 : " + ch);

			try {
				// sleep() 시간을 200~500사이의 난수로 한다.
				Thread.sleep((int) (Math.random() * 301 + 200));
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

		}
		System.out.println(name + "출력 끝...");
		setRank(T11DisplayCharacterTest.currRank++);
	}

	@Override
	public int compareTo(DisPlayCharacter o) {

		return new Integer(this.getRank()).compareTo(o.getRank());
	}
}
