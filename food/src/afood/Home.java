package afood;

import common.HomeMenu;
import common.MenuNotFoundException;
import food.FoodController;
import game.GbbGame;
import game.Rgame;
import join.JoinController;
import order.OrderController;
import review.ReviewController;
import sign.SignController;

public class Home {
	private FoodController foodController = FoodController.getInstance();
	private OrderController orderController = OrderController.getInstance();
	private ReviewController reveiwController = ReviewController.getInstance();
	private SignController signController = SignController.getInstance();
	private JoinController joinController = JoinController.getInstance();
	private FoodView view = FoodView.getInstance();
	private GbbGame ggame = new GbbGame();
	private Rgame rgame = new Rgame();

	public void initialize() {
		home(view.init());
	}

	private void home(int number) {
		loop: while (true) {
			try {
				HomeMenu menu = HomeMenu.findMenu(number);
				System.out.print(menu.getMenuString());
				switch (menu) {
				case HOME:
				case MAIN:
				case CATE:
				case MANAGER:
				case GAME:
					number = view.getMenu();
					break;
				case JOIN:
					number = view.join(joinController);
					break;
				case LOGIN:
					number = view.login(signController);
					break;
                    case LOGOUT:
                        number = signController.signOut();
                        break;
				case FOOD_LIST:
					number = view.getFoodList(foodController);
					break;
				case FOOD_KR:
					number = view.getFoodKR(foodController);
					break;
				case FOOD_US:
					number = view.getFoodUS(foodController);
					break;
				case FOOD_JP:
					number = view.getFoodJP(foodController);
					break;
				case REVIEW_LIST:
					number = view.getReviewTotal(reveiwController);
					break;
				case REVIEW_INSERT:
					number = view.reviewPage(reveiwController);
					break;
                case REVIEW_DLEETE:
                    number = view.getReviewTotal(reveiwController);
                    number = view.deleteReview(reveiwController);
                    break;
				case INSERT_ORDER:
					number = view.insertOrder(orderController);
					break;
				case GETORDER:
					number = view.getOrder(orderController);
					break;
				case MODIFY_STATE:
					number = view.beforeDelivery(orderController);
					number = view.modifyState(orderController);
					break;
				case GETORDER_ALL:
					number = view.getAllOrder(orderController);
					break;
				case FIND_CUSTOMER:
		               number = view.findCustomer(joinController);
		               break;
				case GGAME:
					number = ggame.init();
					break;
				case RGAME:
					number = rgame.init();
					break;
				case QUIT:
					break loop;
				case RANDOM_MENU:
		               number = view.randomMenu(orderController);
		               break;
					
				}
			} catch (MenuNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.print(HomeMenu.HOME.getMenuString());
				break;
			}
			System.out.println();
		}
	}
}
