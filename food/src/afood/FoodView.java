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
				"👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓▶쩝쩝박사◀👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳");
		System.out.println("\n");
		System.out.println("  \t\t\t  ┏━━━┓ ┏━━━┓ ┏━━━┓ ┏━━━┓ ");
		System.out.println("  \t\t\t  ┃┏━━┛ ┃┏━┓┃ ┃┏━┓┃ ┗┓┏┓┃ ");
		System.out.println("  \t\t\t  ┃┗━━┓ ┃┃ ┃┃ ┃┃ ┃┃  ┃┃┃┃ ");
		System.out.println("  \t\t\t  ┃┏━━┛ ┃┃ ┃┃ ┃┃ ┃┃  ┃┃┃┃ ");
		System.out.println("  \t\t\t  ┃┃    ┃┗━┛┃ ┃┗━┛┃ ┏┛┗┛┃ ");
		System.out.println("  \t\t\t  ┗┛    ┗━━━┛ ┗━━━┛ ┗━━━┛ ");
		System.out.println("\n             99%의 정성어림과 1%의 노하우로 최선을 다하겠습니다.(╹ڡ╹ )//\n");
		System.out.println(
				"👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳👩‍🎓👨‍🍳");
		System.out.print(HomeMenu.HOME.getMenuString());

		return scanner.nextInt();
	}

	public int getMenu() {
		return scanner.nextInt();
	}

	public int login(SignController controller) {
		int number;
		System.out.println();
		System.out.print("아이디: ");
//        String memId = scanner.nextLine(); // nextLine 뻐그!
		String memId = scanner.next();
		System.out.print("패스워드: ");
		String memPw = scanner.next();
		CustomerVO vo = controller.signIn(new CustomerVO(memId, memPw));

		if (vo != null) {
			System.out.println("\n" + vo.getMemName() + "님👩‍🎓 로그인되었습니다🎉");
			System.out.println("============================================================================");
			if (memId.equals("AAA")) {
				number = HomeMenu.MANAGER.getMenu();
			} else {
				number = HomeMenu.MAIN.getMenu();
			}

		} else {
			System.out.println("로그인 정보가 일치하지 않습니다..😥아이디와 비밀번호를 확인하세요.");
			System.out.println("============================================================================");
			number = HomeMenu.HOME.getMenu();
		}
		return number;
	}

	public int join(JoinController controller) {
		int number;
		System.out.print("아이디: ");
		String memId = scanner.next();
		scanner.nextLine();
		System.out.print("이름: ");
		String memName = scanner.nextLine();
		System.out.print("주소: ");
		String memAdd = scanner.nextLine();
		System.out.print("전화번호: ");
		String memHp = scanner.nextLine();
		System.out.print("패스워드: ");
		String memPw = scanner.nextLine();
		System.out.print("메일주소: ");
		String memMail = scanner.nextLine();
		System.out.println();
		number = controller.join(new CustomerVO(memId, memPw, memName, memAdd, memHp, memMail));
		if (number == HomeMenu.HOME.getMenu()) {
			System.out.println("🎉회원가입이 완료되었습니다🎉");
			System.out.println();
			System.out.println("============================================================================");
		} else {
			System.out.print("❌회원 가입 실패❌ 다시 회원가입을 하시겠습니까?(y 또는 n을 입력): ");
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
	
	public int getFoodList(FoodController controller) { // 비회원 전체 메뉴 출력
		System.out.println("🥄메뉴🥄 🥄가격🥄🥄카테고리🥄\t      🥄메뉴소개🥄");
	    controller.selectFoodList("").forEach(foodVO -> {
	    	System.out.printf("%-5s\t%-7d\t%-5s\t%-20s\n", foodVO.getMenuName(), foodVO.getMenuPrice(),
	        foodVO.getMenuCa(), foodVO.getMenuInt());
	    });
	    System.out.println();
	    System.out.println("============================================================================");
	    return HomeMenu.HOME.getMenu();
	}

	public int getFoodKR(FoodController controller) { // 한식 메뉴 출력
		System.out.println("🥄번호🥄🥄메뉴🥄   🥄가격🥄\t    🥄메뉴소개🥄");
		controller.findKR("").forEach(foodVO -> {
			System.out.printf("%1s\t%s\t%d\t%s\n", foodVO.getMenuId(), foodVO.getMenuName(), foodVO.getMenuPrice(),
					foodVO.getMenuInt());
		});
		return HomeMenu.INSERT_ORDER.getMenu();
	}

	public int getFoodUS(FoodController controller) { // 양식 메뉴 출력
		System.out.println("🥄번호🥄🥄메뉴🥄   🥄가격🥄\t    🥄메뉴소개🥄");
		controller.findUS("").forEach(foodVO -> {
			System.out.printf("%s\t%s\t%d\t%s\n", foodVO.getMenuId(), foodVO.getMenuName(), foodVO.getMenuPrice(),
					foodVO.getMenuInt());
		});
		return HomeMenu.INSERT_ORDER.getMenu();
	}

	public int getFoodJP(FoodController controller) { // 일식 메뉴 출력
		System.out.println("🥄번호🥄🥄메뉴🥄   🥄가격🥄\t    🥄메뉴소개🥄");
		controller.findJP("").forEach(foodVO -> {
			System.out.printf("%s\t%s\t%d\t%s\n", foodVO.getMenuId(), foodVO.getMenuName(), foodVO.getMenuPrice(),
					foodVO.getMenuInt());
		});
		return HomeMenu.INSERT_ORDER.getMenu();
	}

	//주문
	public int insertOrder(OrderController controller) {
		/*
		 * scan.nextInt 후 scan.nextLine() 하기 전, scan.nextLine() 을 한번 더 작성하여 개행문자 제거
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
			if (number > 0) { // 성공하면 1
				System.out.println("\n주문이 완료되었습니다. ❤감사합니다❤\n");
				System.out.println("============================================================================");
			} else {
				System.out.print("주문 실패! 다시 주문하시겠습니까?(y 또는 n을 입력): ");
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
	       * scan.nextInt 후 scan.nextLine() 하기 전, scan.nextLine() 을 한번 더 작성하여 개행문자 제거
	       */
	      
	      int number;
	      System.out.println("랜덤메뉴를 주문하시겠습니까??             [1.네]   [2.아니오]");
	      int answer = ScannerUtil.scanner().nextInt();
	      if(answer == 1) {
	         Random random = new Random();
	         String[] menu = {"311","312","313","314","315","321","322","323","324","325","331","332","333","334","335"};
	         String menuId = menu[random.nextInt(15)];
	         FoodVO vo = controller.selectOrder(menuId);
	         System.out.printf("%s\t%s\t%d\t%s\t%s\n", vo.getMenuId(), vo.getMenuName(), vo.getMenuPrice(), vo.getMenuCa(),
	               vo.getMenuInt());
	         number = controller.insertOrder(menuId);
	         if (number > 0) { // 성공하면 0
	            System.out.println("\n주문이 완료되었습니다. ❤감사합니다❤\n");
	            System.out.println("============================================================================");
	            number = HomeMenu.MAIN.getMenu();
	         } else {
	            System.out.print("주문 실패!");
	            number = HomeMenu.MAIN.getMenu();
	         }
	      } else {
	         number = HomeMenu.CATE.getMenu();
	      }
	      return number;
	   }
	
	public int getReviewTotal(ReviewController Controller) { // 리뷰 조회
		
		System.out.println("");
		System.out.println("🥄주문번호🥄 🥄아이디🥄     🥄이름🥄             🥄리뷰🥄                🥄주문일자🥄");
		Controller.findAll().forEach(ReviewVO -> {
			System.out.printf("%-7d\t%8s\t%-3s\t%-25s\t%-10s\n", ReviewVO.getRvNo(), ReviewVO.getMemId(), ReviewVO.getMemName(),
					ReviewVO.getRvContent(), ReviewVO.getRvDate());
		});
		System.out.println("============================================================================");
		if(session.getMemId()==null) {
			return HomeMenu.HOME.getMenu(); //로그인됐을경우
		} else {
			return HomeMenu.MAIN.getMenu(); //로그인안됐을경우
		}
	}

	public int reviewPage(ReviewController Controller) { // 리뷰 등록
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
		System.out.println();
		System.out.print("리뷰 내용 :");
		System.out.println("\n                                                                [1.뒤로가기]");
		System.out.println("============================================================================");
//	      String memId = scanner.nextLine(); // nextLine 뻐그!
		String reviewText = scanner.nextLine();
		int result = 0;
		if(reviewText.equals("1")) {
			return HomeMenu.MAIN.getMenu();
		} else {
			try {
				result = Controller.addReview(reviewText, session.getMemId(), session.getMemName());
				if (result > 0) {
					System.out.println("✔리뷰가 등록되었습니다✔");
				} else {
					System.out.println("리뷰 등록 실패...😥");
				}
			} catch (Exception e) {
				System.out.println("리뷰 등록 결과 Error=========>>" + e + "\n");
			}
			return HomeMenu.MAIN.getMenu();
		}
	}

	public int deleteReview(ReviewController Controller) { // 리뷰 삭제
		System.out.print("\n삭제할 리뷰 번호 : ");
		System.out.println("\n                                                                [1.뒤로가기]");
		System.out.println("============================================================================");
		
		String str = ScannerUtil.scanner().next();
		int result = 0;
		if(str.equals("1")) {
			result = HomeMenu.MANAGER.getMenu();
		} else {
			try {
				result = Controller.deleteReview(str);
			} catch (Exception e) {
				System.out.println("리뷰 삭제 결과 Error=========>>" + e + "\n");
			}
			if (result > 0) {
				System.out.println("리뷰가 삭제되었습니다✂");
				result = HomeMenu.MANAGER.getMenu();
			} else {
				System.out.println("리뷰 삭제 실패...😥");
				result = HomeMenu.MAIN.getMenu();
			}
		}
		return result;
	}
	
	public int getOrder(OrderController controller) { // 로그인 회원 주문내역출력
		System.out.println("🥄주문번호🥄      🥄이름🥄 🥄메뉴🥄  🥄가격🥄 🥄배달상태🥄 🥄주문일자🥄");
		controller.findOrder().forEach(OrderVO -> {
			System.out.printf("%s\t%s\t%s\t%d\t%s\t%s\n", OrderVO.getOrderId(), OrderVO.getMemName(), OrderVO.getMenuName(),
					OrderVO.getMenuPrice(),OrderVO.getOrderState() ,OrderVO.getOrderDate());
		});
		System.out.println("============================================================================");
		return HomeMenu.MAIN.getMenu();
	}
	
	public int getAllOrder(OrderController controller) { // 전체 회원 주문내역출력(관리자)
		System.out.println("|주문번호|        |이름|   |아이디|        |음식번호|  |메뉴|   |가격|  |배달상태|  |주문일자|");
		controller.findAllOrder("").forEach(OrderVO -> {
			System.out.printf("%s\t%s\t%-8s\t%s\t%s\t%d\t%s\t%s\n", OrderVO.getOrderId(), OrderVO.getMemName(),
					OrderVO.getMemId(), OrderVO.getMenuId(), OrderVO.getMenuName(), OrderVO.getMenuPrice(),
					OrderVO.getOrderState(), OrderVO.getOrderDate());
		});
		System.out.println("==================================================================================");
		return HomeMenu.MANAGER.getMenu();
	}

	public int findCustomer(JoinController controller) { // 전체회원정보 출력(관리자)
		System.out.println("|아이디|         |이름|    |주소|                           |전화번호|        |이메일|                 |비고|");
		controller.findCustomer("").forEach(CustomerVO -> {
			System.out.printf("%-8s\t%-6s\t%-21s\t%-10s\t%-20s\t%s\n", CustomerVO.getMemId(), 
					CustomerVO.getMemName(), CustomerVO.getMemAdd(), CustomerVO.getMemHp(), CustomerVO.getMemMail(),
					CustomerVO.getMemRole());
		});
		System.out.println("======================================================================================================");
		
		return HomeMenu.MANAGER.getMenu();
	}

	public int beforeDelivery(OrderController controller) { // 배송전 전체회원정보 출력(관리자)
		System.out.println(" |주문번호|       |이름|   |아이디|        |메뉴번호|  |메뉴|   |가격|   |배달상태|  |주문일자|");
		controller.beforeDelivery("").forEach(OrderVO -> {
			System.out.printf("%-8s\t%s\t%-8s\t%s\t%s\t%d\t %s\t%s\n", OrderVO.getOrderId(), OrderVO.getMemName(),
					OrderVO.getMemId(), OrderVO.getMenuId(), OrderVO.getMenuName(), OrderVO.getMenuPrice(),
					OrderVO.getOrderState(), OrderVO.getOrderDate());
		});
		return HomeMenu.MAIN.getMenu();
	}
	
	public int modifyState(OrderController controller) { // 배달상태변경
		System.out.println();
		System.out.println("변경할 주문번호 입력: ");
		System.out.println("                                                                 [1.뒤로가기]");
		System.out.println("=====================================================================================");
		String orderId = ScannerUtil.scanner().next();
		System.out.println();
		int number;
		if(orderId.equals("1")) {
			number = HomeMenu.MANAGER.getMenu();
		} else {
			number = controller.modifyState(orderId);
			if (number > 0) {
				System.out.println("배달상태가 변경되었습니다.");
			} else {
				System.out.println("변경실패");
				number = HomeMenu.MANAGER.getMenu();
			}
		}
		return HomeMenu.MANAGER.getMenu();
	}

}
