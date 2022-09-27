package game;

import java.util.Random;
import java.util.Scanner;

import common.HomeMenu;
import common.ScannerUtil;

public class Rgame {
	public int init() {
		Random random = new Random();
		Scanner scanner = ScannerUtil.scanner();

		// 1부터 100까지 숫자
		int ranNum = random.nextInt(100) + 1;
		System.out.println("❌⭕❌⭕❌⭕❌⭕랜덤 잭팟 게임 START(1~100까지)❌⭕❌⭕❌⭕❌⭕");
		int answer;
		while (true) {
			System.out.println("\t☠☠☠☠ SELECT Number:  ☠☠☠☠");
			answer = scanner.nextInt();
			if (answer == ranNum) {
				System.out.println("\n\t🐽🐽🐽🐽 축하합니다 🐽🐽🐽🐽 \n\t돼지돼지 마법에서 풀렸습니다😍😍");
				System.out.println("\n❌⭕❌⭕❌⭕❌⭕❌⭕❌⭕❌⭕❌⭕❌⭕❌⭕❌⭕❌⭕❌⭕❌⭕❌⭕❌⭕");
				break;
			} else if (answer > ranNum) {
				System.out.println("👇👇더 작은 수를 입력해주세요... \n");
			} else {
				System.out.println("👆👆더 큰 수를 입력해주세요... \n");
			}
			
		}
		
		System.out.println();
	    System.out.println("다시 하시겠습니까?    [1.네,다시할게요] [2.아니요,나갈게요]");
	    int answer2 = scanner.nextInt();
	    if(answer2==1) {
	    	return HomeMenu.RGAME.getMenu();
	    }
		return HomeMenu.GAME.getMenu();
	}

}