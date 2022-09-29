package food;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import afood.FoodApplication;

public class FoodDAO {
	private static FoodDAO instance = new FoodDAO();
    public static FoodDAO getInstance() {
        return instance;
    }
    private FoodDAO() {}
    
    private JdbcTemplate template = FoodApplication.getTemplate();

    public List<FoodVO> findAll(String searchWord) {
        return template.query("SELECT menu_ca, menu_int, menu_name, menu_price FROM foodmenu", new BeanPropertyRowMapper<>(FoodVO.class));
    }
    
    
    public List<FoodVO> findKR(String searchKR) {
        return template.query("SELECT menu_id, menu_int, menu_name, menu_price FROM foodmenu WHERE menu_ca = '한식'", new BeanPropertyRowMapper<>(FoodVO.class));
    }
    
    public List<FoodVO> findUS(String searchUS) {
        return template.query("SELECT menu_id, menu_int, menu_name, menu_price FROM foodmenu WHERE menu_ca = '양식'", new BeanPropertyRowMapper<>(FoodVO.class));
    }
    
    public List<FoodVO> findJP(String searchJP) {
        return template.query("SELECT menu_id, menu_int, menu_name, menu_price FROM foodmenu WHERE menu_ca = '일식'", new BeanPropertyRowMapper<>(FoodVO.class));
    }
    
}
