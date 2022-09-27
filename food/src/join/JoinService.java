package join;

import java.util.List;

public class JoinService {

	public static final int CustomerVO = 0;
	private static JoinService instance = new JoinService();

	public static JoinService getInstance() {
		return instance;
	}

	private JoinService() {
	}

	private JoinDAO dao = JoinDAO.getInstance();
	
	public List<CustomerVO> findCustomer(String serchAllOrder) {
	      return dao.findCustomer(serchAllOrder);
	   }

	public int join(CustomerVO vo) {
		return dao.join(vo);
	}

}