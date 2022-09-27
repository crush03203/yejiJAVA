package sign;

import afood.FoodApplication;
import common.HomeMenu;
import join.CustomerVO;

public class SignController {
	private static SignController instance = new SignController();
	public static SignController getInstance() {
		return instance;
	}
	private SignController() {}

	private SignService service = SignService.getInstance();

	private CustomerVO session = FoodApplication.getSession();

	public CustomerVO signIn(CustomerVO vo) {
		CustomerVO custom = service.findUser(vo);
		if(custom==null) {
			return null;
		}
		session.setMemId(custom.getMemId());
		session.setMemName(custom.getMemName());
		return custom;
	}
	
	public int signOut() {
		// 세션 초기화
		session.invalidate();
		return HomeMenu.HOME.getMenu();
	}
}
