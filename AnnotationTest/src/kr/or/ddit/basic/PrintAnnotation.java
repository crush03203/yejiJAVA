package kr.or.ddit.basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Annotation 에 대하여 (=주석)
 * 
 * 프로그램 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로
 * 포함시킨 것(JDK1.5 부터 지원)
 * 
 * 주석처럼 프로그램에 영향을 미치지 않으면서도 다른 프로그램에게 유용한 
 * 정보를 제공함.
 * 
 * 종류 : 1. 표준 애너테이션
 * 		2. 메타  애너테이션(애너테이션을 위한 애너테이션, 즉 애너테이션을 
 * 		정의할 때 사용하는 애너테이션)
 * 
 * 애너테이션 요소의 규칙 
 * 	1. 요소의 타입은 기본형, String, enum, annotation(또 다른 annotation), class만 허용함
 *  2. ()안에 매개변수를 선안할 수 없다.
 *  3. 예외를 선언할 수 없다
 *  4. 요소의 타입에 타입 파라미터(재너릭타입글자)를 사용할 수 없다. 		
 * */

//@Target(ElementType.METHOD) //적용 대상 지정함. //메소드에만 되도록 지정
@Target({ElementType.METHOD,ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME) // 유지기간 지정함. (기본 : class)Retention : 유지하다 
public @interface PrintAnnotation {
	//int id = 100; //상수선언 가능. static final int id = 100;
	String value() default "-"; //value는 String 타입이다를 정의한다 default "-";부분은 안써도 되긴 함
	int count() default 20; //괄호 안에 아무것도 넣어서는 안됨 어떻게 보면 메소드 같지만 메소드 아님
	//왜 이렇게 쓰는지는 문법이니깐 그냥 외워야함
	//재너릭 타입 글자 public @interface PrintAnnotation<T> { 이런식으로 쓰면 안된다는 듯
	
}
