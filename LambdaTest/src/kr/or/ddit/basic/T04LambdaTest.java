package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T04LambdaTest {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("홍길동1");
		list.add("홍길동2");
		list.add("홍길동3");
		list.add("홍길동4");
		list.add("홍길동5");
		
		//원래 이렇게 해도 됨
//		for(String str : list) {
//			System.out.println(str);
//		}
		
		//이것도 가능!
		list.forEach((name)->{System.out.println(name);});
		System.out.println("------------------------------");
		list.forEach(name-> System.out.println(name));
	}
}
