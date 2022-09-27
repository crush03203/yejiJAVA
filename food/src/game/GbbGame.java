package game;

import java.util.Random;
import java.util.Scanner;

import common.HomeMenu;
import common.ScannerUtil;

public class GbbGame {
   public int init() {
      Random random = new Random();
      String[] gbb = {"가위","바위","보"};
      int computer = random.nextInt(3);
      Scanner scanner = ScannerUtil.scanner();
      
      System.out.println("✌👊🖐✌👊🖐✌👊🖐가위 바위 보 게임 START✌👊🖐✌👊🖐✌👊🖐");
      System.out.println("\n✌1.가위✌           👊2.바위👊           🖐3.보🖐");
      System.out.println("\n✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊✌👊🖐✌👊🖐✌👊🖐✌👊");
      System.out.println();
      System.out.print("숫자를 선택하세요: ");
      int human = scanner.nextInt();
      String car = "\t     쩝쩝박사: " + gbb[computer]+ ", 당신: " + gbb[human-1];
      System.out.println();
      System.out.println("\n✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊✌👊🖐✌👊🖐✌👊🖐✌👊🖐");
      System.out.println();
      if(computer==human-1) {
         System.out.println(car);
         System.out.println();
         System.out.println("\t\t🤷‍♀️‍무승부 입니다🤷‍♀️");
         System.out.println("\n✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊✌👊🖐✌👊🖐✌👊🖐✌👊");

      } else if((computer==0&&human==3) || (computer==1&&human==1) || (computer==2&&human==2)) {
         System.out.println(car);
         System.out.println();
         System.out.println("\t\t😈쩝쩝박사 승리😈 \n\n\t  당신은 🐽돼지돼지 마법에🐽 걸렸습니다. ");
         System.out.println("\n✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊✌👊🖐✌👊🖐✌👊🖐✌👊");

      } else {
         System.out.println(car);
         System.out.println();
         System.out.println("\t=========You win🎈=========");
         System.out.println("\n✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊🖐✌👊✌👊🖐✌👊🖐✌👊🖐✌👊");

      }
      System.out.println();
      System.out.println("다시 하시겠습니까?    [1.네,다시할게요] [2.아니요,나갈게요]");
      int answer = scanner.nextInt();
      if(answer==1) {
    	  return HomeMenu.GGAME.getMenu();
      }
      return HomeMenu.GAME.getMenu();
   }
}