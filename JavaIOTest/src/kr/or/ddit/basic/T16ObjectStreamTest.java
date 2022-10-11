package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 객체 입출력 보조 스트림 예제(직렬화와 역직렬화)
 */
public class T16ObjectStreamTest {
	public static void main(String[] args) {

		// Member 인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("일지매", 30, "서울");
		Member mem3 = new Member("이몽룡", 40, "부산");
		Member mem4 = new Member("성춘향", 50, "광주");

		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(
							"d:/D_Other/memObj.bin")));
			// 쓰기작업
			oos.writeObject(mem1); // 직렬화
			oos.writeObject(mem2); // 직렬화
			oos.writeObject(mem3); // 직렬화
			oos.writeObject(mem4); // 직렬화

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									"d:/D_Other/memObj.bin")));
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
				// 읽어온 데이터를 원래의 객체형으로 변환 후 사용한다. //readObject()에서 역직렬화 start
				//데코레이션 패턴 참고
				Member mem = (Member) obj;
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAdd());
				System.out.println("--------------------------");
			}

		} catch (IOException ex) {
			//더 이상 읽어올 객체가 없으면 예외 발생함.
			System.out.println("출력 작업 완..");
			//ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

class Member implements Serializable {
	// 자바는 Serializable 인터페이스를 구현한 클래스만 직렬화 할 수 있도록 제한하고 있음.

	/**
	 * transient =>  직렬화가 되지 않을 멤버 변수에 지정한다.
	 * 			 (* static 필드도 직렬화 대상에서 제외된다.)
	 
	 *직렬화 대상이 아닌 멤버 변수는 기본값으로 저장된다.
	 *(참조형 변수 : null, 숫자형 변수 : 0)
	 *name , age에 transient를 붙이고 출력하면 null과 0이 출력됨 
	 *민감한 정보를 저장할 때/ 정보 저장할 때 저장하고 싶지 않은 정보는 transient를 붙여준다
	 *
	 */
	private transient String name;
	private transient int age;
	private String add;

	public Member(String name, int age, String add) {
		super();
		this.name = name;
		this.age = age;
		this.add = add;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

}
