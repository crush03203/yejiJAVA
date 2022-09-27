package order;

import java.util.List;

import food.FoodVO;
import join.CustomerVO;

public class OrderService {
	private static OrderService instance = new OrderService();
    public static OrderService getInstance() {
        return instance;
    }
    private OrderService() {}

    private OrderDAO dao = OrderDAO.getInstance();
    
    
    public FoodVO selectOrder(String menuId) {
    	return dao.selectOrder(menuId);
    }
    
    public int insertOrder(CustomerVO vo, String menuId) {
        int result = 0;
        result = dao.insertOrder(vo, menuId);
        return result;
    }
    public List<OrderVO> findOrder(CustomerVO vo) {
		return dao.findOrder(vo);
	}
    
    public int modifyState(String orderId) {
        return dao.modifyState(orderId);
    }
   
    //전체 회원 주문 정보 출력
    public List<OrderVO> findAllOrder(String serchAllOrder) {
       return dao.findAllOrder(serchAllOrder);
    }
    public List<OrderVO> beforeDelivery(String serchAllOrder) {
    	return dao.beforeDelivery(serchAllOrder);
    }



}
