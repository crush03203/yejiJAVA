package afood;

import java.util.Random;
import java.util.Scanner;

import common.HomeMenu;
import common.ScannerUtil;
import food.FoodController;
import food.FoodVO;
import join.CustomerVO;
import join.JoinController;
import order.OrderController;
import review.ReviewController;
import sign.SignController;

public class FoodView {
	private static FoodView instance = new FoodView();
	private CustomerVO session = FoodApplication.getSession();

	private FoodView() {
	}

	public static FoodView getInstance() {
		return instance;
	}

	private Scanner scanner = ScannerUtil.scanner();

	public int init() {
		System.out.println(
				"π¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βπβΆμ©μ©λ°μ¬βπ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³");
		System.out.println("\n");
		System.out.println("  \t\t\t  βββββ βββββ βββββ βββββ ");
		System.out.println("  \t\t\t  βββββ βββββ βββββ βββββ ");
		System.out.println("  \t\t\t  βββββ ββ ββ ββ ββ  ββββ ");
		System.out.println("  \t\t\t  βββββ ββ ββ ββ ββ  ββββ ");
		System.out.println("  \t\t\t  ββ    βββββ βββββ βββββ ");
		System.out.println("  \t\t\t  ββ    βββββ βββββ βββββ ");
		System.out.println("\n             99%μ μ μ±μ΄λ¦Όκ³Ό 1%μ λΈνμ°λ‘ μ΅μ μ λ€νκ² μ΅λλ€.(βΉΪ‘βΉ )//\n");
		System.out.println(
				"π¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³π©βππ¨βπ³");
		System.out.print(HomeMenu.HOME.getMenuString());

		return scanner.nextInt();
	}

	public int getMenu() {
		return scanner.nextInt();
	}

	public int login(SignController controller) {
		int number;
		System.out.println();
		System.out.print("μμ΄λ: ");
//        String memId = scanner.nextLine(); // nextLine λ»κ·Έ!
		String memId = scanner.next();
		System.out.print("ν¨μ€μλ: ");
		String memPw = scanner.next();
		CustomerVO vo = controller.signIn(new CustomerVO(memId, memPw));

		if (vo != null) {
			System.out.println("\n" + vo.getMemName() + "λπ©βπ λ‘κ·ΈμΈλμμ΅λλ€π");
			System.out.println("============================================================================");
			if (memId.equals("AAA")) {
				number = HomeMenu.MANAGER.getMenu();
			} else {
				number = HomeMenu.MAIN.getMenu();
			}

		} else {
			System.out.println("λ‘κ·ΈμΈ μ λ³΄κ° μΌμΉνμ§ μμ΅λλ€..π₯μμ΄λμ λΉλ°λ²νΈλ₯Ό νμΈνμΈμ.");
			System.out.println("============================================================================");
			number = HomeMenu.HOME.getMenu();
		}
		return number;
	}

	public int join(JoinController controller) {
		int number;
		System.out.print("μμ΄λ: ");
		String memId = scanner.next();
		scanner.nextLine();
		System.out.print("μ΄λ¦: ");
		String memName = scanner.nextLine();
		System.out.print("μ£Όμ: ");
		String memAdd = scanner.nextLine();
		System.out.print("μ νλ²νΈ: ");
		String memHp = scanner.nextLine();
		System.out.print("ν¨μ€μλ: ");
		String memPw = scanner.nextLine();
		System.out.print("λ©μΌμ£Όμ: ");
		String memMail = scanner.nextLine();
		System.out.println();
		number = controller.join(new CustomerVO(memId, memPw, memName, memAdd, memHp, memMail));
		if (number == HomeMenu.HOME.getMenu()) {
			System.out.println("πνμκ°μμ΄ μλ£λμμ΅λλ€π");
			System.out.println();
			System.out.println("============================================================================");
		} else {
			System.out.print("βνμ κ°μ μ€ν¨β λ€μ νμκ°μμ νμκ² μ΅λκΉ?(y λλ nμ μλ ₯): ");
			System.out.println();
			System.out.println("============================================================================");
			String inputFlag = scanner.nextLine();
			if (inputFlag.equalsIgnoreCase("y")) {
				number = HomeMenu.JOIN.getMenu();
			} else {
				number = HomeMenu.HOME.getMenu();
			}
		}
		return number;
	}
	
	public int getFoodList(FoodController controller) { // λΉνμ μ μ²΄ λ©λ΄ μΆλ ₯
		System.out.println("π₯λ©λ΄π₯ π₯κ°κ²©π₯π₯μΉ΄νκ³ λ¦¬π₯\t      π₯λ©λ΄μκ°π₯");
	    controller.selectFoodList("").forEach(foodVO -> {
	    	System.out.printf("%-5s\t%-7d\t%-5s\t%-20s\n", foodVO.getMenuName(), foodVO.getMenuPrice(),
	        foodVO.getMenuCa(), foodVO.getMenuInt());
	    });
	    System.out.println();
	    System.out.println("============================================================================");
	    return HomeMenu.HOME.getMenu();
	}

	public int getFoodKR(FoodController controller) { // νμ λ©λ΄ μΆλ ₯
		System.out.println("π₯λ²νΈπ₯π₯λ©λ΄π₯   π₯κ°κ²©π₯\t    π₯λ©λ΄μκ°π₯");
		controller.findKR("").forEach(foodVO -> {
			System.out.printf("%1s\t%s\t%d\t%s\n", foodVO.getMenuId(), foodVO.getMenuName(), foodVO.getMenuPrice(),
					foodVO.getMenuInt());
		});
		return HomeMenu.INSERT_ORDER.getMenu();
	}

	public int getFoodUS(FoodController controller) { // μμ λ©λ΄ μΆλ ₯
		System.out.println("π₯λ²νΈπ₯π₯λ©λ΄π₯   π₯κ°κ²©π₯\t    π₯λ©λ΄μκ°π₯");
		controller.findUS("").forEach(foodVO -> {
			System.out.printf("%s\t%s\t%d\t%s\n", foodVO.getMenuId(), foodVO.getMenuName(), foodVO.getMenuPrice(),
					foodVO.getMenuInt());
		});
		return HomeMenu.INSERT_ORDER.getMenu();
	}

	public int getFoodJP(FoodController controller) { // μΌμ λ©λ΄ μΆλ ₯
		System.out.println("π₯λ²νΈπ₯π₯λ©λ΄π₯   π₯κ°κ²©π₯\t    π₯λ©λ΄μκ°π₯");
		controller.findJP("").forEach(foodVO -> {
			System.out.printf("%s\t%s\t%d\t%s\n", foodVO.getMenuId(), foodVO.getMenuName(), foodVO.getMenuPrice(),
					foodVO.getMenuInt());
		});
		return HomeMenu.INSERT_ORDER.getMenu();
	}

	//μ£Όλ¬Έ
	public int insertOrder(OrderController controller) {
		/*
		 * scan.nextInt ν scan.nextLine() νκΈ° μ , scan.nextLine() μ νλ² λ μμ±νμ¬ κ°νλ¬Έμ μ κ±°
		 */
		ScannerUtil.scanner().nextLine();
		String menuId = ScannerUtil.scanner().nextLine();
		int number;
		if(menuId.equals("1")) {
			number = HomeMenu.CATE.getMenu();
		} else {
			FoodVO vo = controller.selectOrder(menuId);
			System.out.printf("%s\t%s\t%d\t%s\t%s\n", vo.getMenuId(), vo.getMenuName(), vo.getMenuPrice(), vo.getMenuCa(),
					vo.getMenuInt());
	
			number = controller.insertOrder(menuId);
			if (number > 0) { // μ±κ³΅νλ©΄ 1
				System.out.println("\nμ£Όλ¬Έμ΄ μλ£λμμ΅λλ€. β€κ°μ¬ν©λλ€β€\n");
				System.out.println("============================================================================");
			} else {
				System.out.print("μ£Όλ¬Έ μ€ν¨! λ€μ μ£Όλ¬Ένμκ² μ΅λκΉ?(y λλ nμ μλ ₯): ");
				String inputFlag = scanner.nextLine();
				if (inputFlag.equalsIgnoreCase("y")) {
					number = HomeMenu.INSERT_ORDER.getMenu();
				} else {
					number = HomeMenu.MAIN.getMenu();
				}
			}
		}
		return number;
	}
	public int randomMenu(OrderController controller) {
	      /*
	       * scan.nextInt ν scan.nextLine() νκΈ° μ , scan.nextLine() μ νλ² λ μμ±νμ¬ κ°νλ¬Έμ μ κ±°
	       */
	      
	      int number;
	      System.out.println("λλ€λ©λ΄λ₯Ό μ£Όλ¬Ένμκ² μ΅λκΉ??             [1.λ€]   [2.μλμ€]");
	      int answer = ScannerUtil.scanner().nextInt();
	      if(answer == 1) {
	         Random random = new Random();
	         String[] menu = {"311","312","313","314","315","321","322","323","324","325","331","332","333","334","335"};
	         String menuId = menu[random.nextInt(15)];
	         FoodVO vo = controller.selectOrder(menuId);
	         System.out.printf("%s\t%s\t%d\t%s\t%s\n", vo.getMenuId(), vo.getMenuName(), vo.getMenuPrice(), vo.getMenuCa(),
	               vo.getMenuInt());
	         number = controller.insertOrder(menuId);
	         if (number > 0) { // μ±κ³΅νλ©΄ 0
	            System.out.println("\nμ£Όλ¬Έμ΄ μλ£λμμ΅λλ€. β€κ°μ¬ν©λλ€β€\n");
	            System.out.println("============================================================================");
	            number = HomeMenu.MAIN.getMenu();
	         } else {
	            System.out.print("μ£Όλ¬Έ μ€ν¨!");
	            number = HomeMenu.MAIN.getMenu();
	         }
	      } else {
	         number = HomeMenu.CATE.getMenu();
	      }
	      return number;
	   }
	
	public int getReviewTotal(ReviewController Controller) { // λ¦¬λ·° μ‘°ν
		
		System.out.println("");
		System.out.println("π₯μ£Όλ¬Έλ²νΈπ₯ π₯μμ΄λπ₯     π₯μ΄λ¦π₯             π₯λ¦¬λ·°π₯                π₯μ£Όλ¬ΈμΌμπ₯");
		Controller.findAll().forEach(ReviewVO -> {
			System.out.printf("%-7d\t%8s\t%-3s\t%-25s\t%-10s\n", ReviewVO.getRvNo(), ReviewVO.getMemId(), ReviewVO.getMemName(),
					ReviewVO.getRvContent(), ReviewVO.getRvDate());
		});
		System.out.println("============================================================================");
		if(session.getMemId()==null) {
			return HomeMenu.HOME.getMenu(); //λ‘κ·ΈμΈλμκ²½μ°
		} else {
			return HomeMenu.MAIN.getMenu(); //λ‘κ·ΈμΈμλμκ²½μ°
		}
	}

	public int reviewPage(ReviewController Controller) { // λ¦¬λ·° λ±λ‘
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
		System.out.println();
		System.out.print("λ¦¬λ·° λ΄μ© :");
		System.out.println("\n                                                                [1.λ€λ‘κ°κΈ°]");
		System.out.println("============================================================================");
//	      String memId = scanner.nextLine(); // nextLine λ»κ·Έ!
		String reviewText = scanner.nextLine();
		int result = 0;
		if(reviewText.equals("1")) {
			return HomeMenu.MAIN.getMenu();
		} else {
			try {
				result = Controller.addReview(reviewText, session.getMemId(), session.getMemName());
				if (result > 0) {
					System.out.println("βλ¦¬λ·°κ° λ±λ‘λμμ΅λλ€β");
				} else {
					System.out.println("λ¦¬λ·° λ±λ‘ μ€ν¨...π₯");
				}
			} catch (Exception e) {
				System.out.println("λ¦¬λ·° λ±λ‘ κ²°κ³Ό Error=========>>" + e + "\n");
			}
			return HomeMenu.MAIN.getMenu();
		}
	}

	public int deleteReview(ReviewController Controller) { // λ¦¬λ·° μ­μ 
		System.out.print("\nμ­μ ν  λ¦¬λ·° λ²νΈ : ");
		System.out.println("\n                                                                [1.λ€λ‘κ°κΈ°]");
		System.out.println("============================================================================");
		
		String str = ScannerUtil.scanner().next();
		int result = 0;
		if(str.equals("1")) {
			result = HomeMenu.MANAGER.getMenu();
		} else {
			try {
				result = Controller.deleteReview(str);
			} catch (Exception e) {
				System.out.println("λ¦¬λ·° μ­μ  κ²°κ³Ό Error=========>>" + e + "\n");
			}
			if (result > 0) {
				System.out.println("λ¦¬λ·°κ° μ­μ λμμ΅λλ€β");
				result = HomeMenu.MANAGER.getMenu();
			} else {
				System.out.println("λ¦¬λ·° μ­μ  μ€ν¨...π₯");
				result = HomeMenu.MAIN.getMenu();
			}
		}
		return result;
	}
	
	public int getOrder(OrderController controller) { // λ‘κ·ΈμΈ νμ μ£Όλ¬Έλ΄μ­μΆλ ₯
		System.out.println("π₯μ£Όλ¬Έλ²νΈπ₯      π₯μ΄λ¦π₯ π₯λ©λ΄π₯  π₯κ°κ²©π₯ π₯λ°°λ¬μνπ₯ π₯μ£Όλ¬ΈμΌμπ₯");
		controller.findOrder().forEach(OrderVO -> {
			System.out.printf("%s\t%s\t%s\t%d\t%s\t%s\n", OrderVO.getOrderId(), OrderVO.getMemName(), OrderVO.getMenuName(),
					OrderVO.getMenuPrice(),OrderVO.getOrderState() ,OrderVO.getOrderDate());
		});
		System.out.println("============================================================================");
		return HomeMenu.MAIN.getMenu();
	}
	
	public int getAllOrder(OrderController controller) { // μ μ²΄ νμ μ£Όλ¬Έλ΄μ­μΆλ ₯(κ΄λ¦¬μ)
		System.out.println("|μ£Όλ¬Έλ²νΈ|        |μ΄λ¦|   |μμ΄λ|        |μμλ²νΈ|  |λ©λ΄|   |κ°κ²©|  |λ°°λ¬μν|  |μ£Όλ¬ΈμΌμ|");
		controller.findAllOrder("").forEach(OrderVO -> {
			System.out.printf("%s\t%s\t%-8s\t%s\t%s\t%d\t%s\t%s\n", OrderVO.getOrderId(), OrderVO.getMemName(),
					OrderVO.getMemId(), OrderVO.getMenuId(), OrderVO.getMenuName(), OrderVO.getMenuPrice(),
					OrderVO.getOrderState(), OrderVO.getOrderDate());
		});
		System.out.println("==================================================================================");
		return HomeMenu.MANAGER.getMenu();
	}

	public int findCustomer(JoinController controller) { // μ μ²΄νμμ λ³΄ μΆλ ₯(κ΄λ¦¬μ)
		System.out.println("|μμ΄λ|         |μ΄λ¦|    |μ£Όμ|                           |μ νλ²νΈ|        |μ΄λ©μΌ|                 |λΉκ³ |");
		controller.findCustomer("").forEach(CustomerVO -> {
			System.out.printf("%-8s\t%-6s\t%-21s\t%-10s\t%-20s\t%s\n", CustomerVO.getMemId(), 
					CustomerVO.getMemName(), CustomerVO.getMemAdd(), CustomerVO.getMemHp(), CustomerVO.getMemMail(),
					CustomerVO.getMemRole());
		});
		System.out.println("======================================================================================================");
		
		return HomeMenu.MANAGER.getMenu();
	}

	public int beforeDelivery(OrderController controller) { // λ°°μ‘μ  μ μ²΄νμμ λ³΄ μΆλ ₯(κ΄λ¦¬μ)
		System.out.println(" |μ£Όλ¬Έλ²νΈ|       |μ΄λ¦|   |μμ΄λ|        |λ©λ΄λ²νΈ|  |λ©λ΄|   |κ°κ²©|   |λ°°λ¬μν|  |μ£Όλ¬ΈμΌμ|");
		controller.beforeDelivery("").forEach(OrderVO -> {
			System.out.printf("%-8s\t%s\t%-8s\t%s\t%s\t%d\t %s\t%s\n", OrderVO.getOrderId(), OrderVO.getMemName(),
					OrderVO.getMemId(), OrderVO.getMenuId(), OrderVO.getMenuName(), OrderVO.getMenuPrice(),
					OrderVO.getOrderState(), OrderVO.getOrderDate());
		});
		return HomeMenu.MAIN.getMenu();
	}
	
	public int modifyState(OrderController controller) { // λ°°λ¬μνλ³κ²½
		System.out.println();
		System.out.println("λ³κ²½ν  μ£Όλ¬Έλ²νΈ μλ ₯: ");
		System.out.println("                                                                 [1.λ€λ‘κ°κΈ°]");
		System.out.println("=====================================================================================");
		String orderId = ScannerUtil.scanner().next();
		System.out.println();
		int number;
		if(orderId.equals("1")) {
			number = HomeMenu.MANAGER.getMenu();
		} else {
			number = controller.modifyState(orderId);
			if (number > 0) {
				System.out.println("λ°°λ¬μνκ° λ³κ²½λμμ΅λλ€.");
			} else {
				System.out.println("λ³κ²½μ€ν¨");
				number = HomeMenu.MANAGER.getMenu();
			}
		}
		return HomeMenu.MANAGER.getMenu();
	}

}
