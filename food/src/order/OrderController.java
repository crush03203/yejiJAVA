package order;

import java.util.List;

import afood.FoodApplication;
import food.FoodVO;
import join.CustomerVO;

public class OrderController {

	private static OrderController instance = new OrderController();

	public static OrderController getInstance() {
		return instance;
	}

	private OrderController() {
	}

	private OrderService service = OrderService.getInstance();

	private CustomerVO session = FoodApplication.getSession();

	public FoodVO selectOrder(String menuId) { // 메뉴아이디 저장
		FoodVO custom = service.selectOrder(menuId);
		if (custom == null) {
			return null;
		}
		return custom;
	}

	public int insertOrder(String menuId) { // 주문정보를 저장
		CustomerVO vo = new CustomerVO();
		vo.setMemId(session.getMemId());
		vo.setMemName(session.getMemName());
		return service.insertOrder(vo, menuId);
	}

	public List<OrderVO> findOrder() {
		CustomerVO vo = new CustomerVO();
		vo.setMemId(session.getMemId());
		return service.findOrder(vo);
	}

	public int modifyState(String orderId) {
		return service.modifyState(orderId);
	}

	public List<OrderVO> findAllOrder(String serchAllOrder) {// 전체회원 주문 정보 출력
		return service.findAllOrder(serchAllOrder);

	}
	public List<OrderVO> beforeDelivery(String serchAllOrder) {//배달상태변경 전
		return service.beforeDelivery(serchAllOrder);
		
	}

}
