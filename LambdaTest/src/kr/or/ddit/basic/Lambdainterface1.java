package kr.or.ddit.basic;

@FunctionalInterface
public interface Lambdainterface1 {
	// 반환값이 없고 매개변수도 없는 추상메서드
	public void test();
//	public void test2();// 이거 생성하면 오류남
}

@FunctionalInterface
interface Lambdainterface2 {
	// 반환값이 없고 매개변수는 있는 추상메서드
	public void test(int a);
}

@FunctionalInterface
interface Lambdainterface3 {
	// 반환 값도 있고 매개변수도 있는 추상메서드
	public int test(int a, int b);
}
