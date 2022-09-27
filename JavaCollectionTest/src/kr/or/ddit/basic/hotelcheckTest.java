package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class hotelcheckTest {
	private Scanner scan;
	private Map<String, HotelM> hotelcheckMap;

	public hotelcheckTest() {
		scan = new Scanner(System.in);
		hotelcheckMap = new HashMap<String, HotelM>();
	}

	// 메뉴를 출력하는 메서드
	public void displayMenu() {
		System.out.println();
		System.out.println("*******************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("*******************************************");
		System.out.print("메뉴선택 => ");
	}

	// 프로그램을 시작하는 메서드
	public void hotelStart() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");

		while (true) {
			displayMenu(); // 메뉴를 출력
			int menuNum = scan.nextInt(); // 메뉴 번호 입력
			switch (menuNum) {

			case 1: // 체크인
				checkIn();
				break;

			case 2: // 체크아웃
				checkOut();
				break;

			case 3: // 객실상태
				state();
				break;

			case 4: // 업무종료
				System.out.println("**************************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("**************************");
				return;

			default:
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} // swith문 끝

		} // while 문 끝

	}// hotelStart 끝

	private void state() {
		// 객실상태
		Set<String> keySet = hotelcheckMap.keySet();
		if (keySet.size() == 0) {
			System.out.println("등록된 전화번호가 존재하지 않습니다.");
		} else {
			Iterator<String> it = keySet.iterator();
			int cnt = 0;
			while (it.hasNext()) {
				String cunsomer = it.next();
				HotelM p = hotelcheckMap.get(cunsomer);
				System.out.println("방번호: " + p.getNum() +","+ "투숙객: " + p.getCunsomer());
			}
		}

	}

	private void checkOut() {
		// 체크아웃
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");

		System.out.print("방번호 입력 =>");
		String num = scan.next();

		// remove(key) => 삭제 성공하면 삭제된 value 값을 반환하고 실패하면 null을 리턴함
		if (hotelcheckMap.remove(num) == null) {
			System.out.println(num + "방에는 체크인한 사람이 없습니다.");
		} else {
			System.out.println("체크아웃 되었습니다.");
		}

	}

	private void checkIn() {
		// 체크인
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.println("방번호 입력 =>");
		String num = scan.next();

		if (hotelcheckMap.get(num) != null) {
			System.out.println(num + "방에는 이미 사람이 있습니다");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 =>");
		String cunsomer = scan.next();

		// 이미 체크인 한 사람인지 체크하기
		// get()메서드로 값을 가져올 때 가져올 자료가 없으면 null을 리턴한다.
		

		// new 체크인 할 사람
		HotelM p = new HotelM(num, cunsomer);
		hotelcheckMap.put(num, p);
		System.out.println(cunsomer + "님 체크인 되었습니다");
	}

	public static void main(String[] args) {

		new hotelcheckTest().hotelStart();
	}
}

class HotelM {
	private String num;
	private String cunsomer;

	public HotelM(String num, String cunsomer) {
		super();
		this.num = num;
		this.cunsomer = cunsomer;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCunsomer() {
		return cunsomer;
	}

	public void setCunsomer(String cunsomer) {
		this.cunsomer = cunsomer;
	}

	@Override
	public String toString() {
		return "HotelM [num=" + num + ", cunsomer=" + cunsomer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cunsomer == null) ? 0 : cunsomer.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelM other = (HotelM) obj;
		if (cunsomer == null) {
			if (other.cunsomer != null)
				return false;
		} else if (!cunsomer.equals(other.cunsomer))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}

}