package join;

import java.util.List;

import common.HomeMenu;

public class JoinController {

   private static JoinController instance = new JoinController();

   public static JoinController getInstance() {
      return instance;
   }

   private JoinController() {
   }

   private JoinService service = JoinService.getInstance();

   public JoinController(JoinService service) {
      this.service = service;
   }

   public int join(CustomerVO vo) {
      try {
         if (service.join(vo) == 1) {
            return HomeMenu.HOME.getMenu();
         }
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("알수 없는 오류가 발생하였습니다.");
         return HomeMenu.JOIN.getMenu();
      }
      return HomeMenu.HOME.getMenu();
      
   }
   public List<CustomerVO> findCustomer(String serchAllOrder) {
	      return service.findCustomer(serchAllOrder);
	   }

}