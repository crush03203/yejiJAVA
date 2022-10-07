package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class T11FileEncodingTest {
	public static void main(String[] args) throws IOException {
		//디자인 패턴 中  데코레이터?데코레이션? 패턴
	/**
	 * OutputStreamWriter => 바이트기반 출력용 객체를 문자기반 출력용
	 * 			객체로 변환하는 보조스트림
	 * 	=> 이객체도 출력할 때 '인코딩방식'을 지정해서 출력할 수 있다.
	 * 
	*/

		// 키보드로 입력한 내용을 파일로 저장하는 데
		//out_utf8.txt 파일은 'utf-8'인코딩 방식으로
		//out_ansi.txt 파일은'ms949'인코딩 방식으로 저장하시오.
		
		InputStreamReader isr = new InputStreamReader(System.in);
		
		//파일 출력용
		FileOutputStream fos1 = 
				new FileOutputStream("d:/D_Other/out_utf8.txt");
		FileOutputStream fos2 = 
				new FileOutputStream("d:/D_Other/out_ansi.txt");
	
		OutputStreamWriter osw1 = 
				new OutputStreamWriter(fos1,"UTF-8");
		OutputStreamWriter osw2 = 
				new OutputStreamWriter(fos2,"MS949");
		
		int data = 0;
		while((data = isr.read()) != -1) {
			osw1.write(data);
			osw2.write(data);
			
		}
	
		System.out.println("작업완료...");
		
		isr.close();
		osw1.close();
		osw2.close();
	
	}
}
