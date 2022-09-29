package kr.or.ddit.basic;

import java.io.Serializable;

//@PrintAnnotation에 붙이면 에러가 남 왜냐하면 
//@PrintAnnotation 설정할 때 메소드에만 붙일 수 있다고 선언했기 때문에
//@PrintAnnotation를 붙이고 싶다면 메소드 외에 type도 넣어준다
public class Service implements Serializable{
	
	@PrintAnnotation
	public void method1() throws Exception {
		System.out.println("메서드1에서 출력되었습니다.");
	}
	
	@PrintAnnotation(value = "%")
	public void method2() {
		System.out.println("메서드2에서 출력되었습니다.");
	}

	@PrintAnnotation(value = "#", count = 25)
	public void method3() {
		System.out.println("메서드3에서 출력되었습니다.");
	}

}
 