package order;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import afood.FoodApplication;
import food.FoodVO;
import join.CustomerVO;

public class OrderDAO {
	private static OrderDAO instance = new OrderDAO();
    public static OrderDAO getInstance() {
        return instance;
    }
    
    private OrderDAO() {}
    
    private JdbcTemplate template = FoodApplication.getTemplate();
    
    public FoodVO selectOrder(String menuId) {  //주문
		try {
			return template.queryForObject(
					"SELECT menu_ca, menu_id, menu_int, menu_name, menu_price FROM foodmenu where menu_id like '%' || ? || '%'", new BeanPropertyRowMapper<>(FoodVO.class), menuId);
        } catch (DataAccessException e) {
        	return null;
        }
    }
    
    public int insertOrder(CustomerVO vo, String menuId) {  //1이 나오면 들어간거?
        return template.update("INSERT INTO FOODORDER(ORDER_ID, MEM_ID, MENU_ID, MENU_PRICE, ORDER_QTY, ORDER_STATE, ORDER_DATE)"
        		+ "VALUES((SELECT NVL(MAX(ORDER_ID)+1, TO_CHAR(SYSDATE,'YYYYMMDD')||'001') FROM FOODORDER WHERE SUBSTR(ORDER_ID,1,8) = TO_CHAR(SYSDATE,'YYYYMMDD')),"
        		+ "?,?,(SELECT menu_price FROM foodmenu where menu_id = ?),1,'배달전',sysdate)", vo.getMemId(), menuId, menuId);
    }
    
    public int modifyState(String orderId) {
        return template.update("update foodorder set order_state = '배달완료' where order_id = ?",orderId);
    }

  
    public List<OrderVO> findOrder(CustomerVO vo) {  //주문정보출력
    	return template.query("SELECT A.ORDER_ID, B.MEM_NAME, C.MENU_NAME, C.MENU_PRICE, A.ORDER_STATE, TO_CHAR(A.ORDER_DATE,'YYYY/MM/DD') ORDER_DATE FROM  FOODORDER A, FOODMEM B, FOODMENU C WHERE B.MEM_ID = A.MEM_ID AND A.MENU_ID = C.MENU_ID AND A.MENU_PRICE = C.MENU_PRICE AND A.MEM_ID = ? ",new BeanPropertyRowMapper<>(OrderVO.class), vo.getMemId());
    }
    public List<OrderVO> findAllOrder(String serchAllOrder) {  //전체 회원 주문정보 출력
        return template.query("SELECT A.ORDER_ID, B.MEM_NAME, A.MEM_ID, A.MENU_ID,  C.MENU_NAME, C.MENU_PRICE, A.ORDER_STATE, TO_CHAR(A.ORDER_DATE,'YYYY/MM/DD') ORDER_DATE FROM  FOODORDER A, FOODMEM B, FOODMENU C WHERE B.MEM_ID = A.MEM_ID AND A.MENU_ID = C.MENU_ID AND A.MENU_PRICE = C.MENU_PRICE ORDER BY 1 desc",new BeanPropertyRowMapper<>(OrderVO.class));
     }
    public List<OrderVO> beforeDelivery(String serchAllOrder) {  //배달전주문출력
        return template.query("SELECT A.ORDER_ID, B.MEM_NAME, A.MEM_ID, A. MENU_ID, C.MENU_NAME,C.MENU_PRICE,A.ORDER_STATE,TO_CHAR(A.ORDER_DATE,'YYYY/MM/DD') ORDER_DATE FROM FOODORDER A, FOODMEM B, FOODMENU C WHERE B.MEM_ID = A.MEM_ID AND A.MENU_ID = C.MENU_ID AND A.MENU_PRICE = C.MENU_PRICE AND A.order_state = '배달전'",new BeanPropertyRowMapper<>(OrderVO.class));
     }

}

