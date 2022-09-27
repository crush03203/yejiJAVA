package food;

import java.util.List;

public class FoodService {
	private static FoodService instance = new FoodService();
    public static FoodService getInstance() {
        return instance;
    }
    private FoodService() {}

    private FoodDAO dao = FoodDAO.getInstance();
    
    //전체 메뉴
    public List<FoodVO> findAll(String searchWord) {
        return dao.findAll(searchWord);
     }
    //분류별 메뉴
	public List<FoodVO> findKR(String searchKR) {
		return dao.findKR(searchKR);
	}
	public List<FoodVO> findUS(String searchUS) {
		return dao.findUS(searchUS);
	}

	public List<FoodVO> findJP(String searchJP) {
		return dao.findJP(searchJP);
	}
	
}
