package food;

import java.util.List;

public class FoodController {
	private static FoodController instance = new FoodController();
    public static FoodController getInstance() {
        return instance;
    }
    private FoodController() {}

    private FoodService service = FoodService.getInstance();
    

    //전체 메뉴
    public List<FoodVO> selectFoodList(String searchWord) {
        return service.findAll(searchWord);
     }
    //분류별 메뉴
	public List<FoodVO> findKR(String searchKR) {
		return service.findKR(searchKR);
	}
	public List<FoodVO> findUS(String searchUS) {
		return service.findUS(searchUS);
	}
	public List<FoodVO> findJP(String searchJP) {
		return service.findJP(searchJP);
	}
}
