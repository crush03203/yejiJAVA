package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tulips {

	public static void main(String[] args) throws IOException {
		// 원본 파일경로
		String oriFilePath = "D:\\D_Other\\Tulips.jpg";
		// 복사될 파일경로
		String copyFilePath = "D:\\D_Other\\복사본_Tulips.jpg";

		// 파일객체생성
		File oriFile = new File(oriFilePath);
		// 복사파일객체생성
		File copyFile = new File(copyFilePath);

		FileInputStream fis = new FileInputStream(oriFile); // 읽을파일
		FileOutputStream fos = new FileOutputStream(copyFile); // 복사할파일

		int fileByte = 0;
		// fis.read()가 -1 이면 파일을 다 읽은것
		// 자원사용종료
		while ((fileByte = fis.read()) != -1) {
			fos.write(fileByte);
		}
		fis.close();
		fos.close();

	}
}


/**
 * 
 */


