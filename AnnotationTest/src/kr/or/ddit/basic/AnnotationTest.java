package kr.or.ddit.basic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationTest {

	public static void main(String[] args) {

		// 선언된 메서드 목록을 조회하고, 메서드를 실행해보기
		Method[] MethodArr = Service.class.getDeclaredMethods();

		for (Method m : MethodArr) {

			Annotation[] annos = m.getDeclaredAnnotations();
			for (Annotation anno : annos) {

				if (anno.annotationType().getSimpleName()
						.equals("PrintAnnotation")) {

				}
			}

		}

	}

}
