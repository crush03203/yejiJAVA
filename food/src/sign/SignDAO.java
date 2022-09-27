package sign;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import afood.FoodApplication;
import join.CustomerVO;


public class SignDAO {
	private static SignDAO instance = new SignDAO();

	public static SignDAO getInstance() {
		return instance;
	}
	private SignDAO() {}

	private JdbcTemplate template = FoodApplication.getTemplate();

	public CustomerVO findUser(CustomerVO vo) {
		try {
			return template.queryForObject(
					"SELECT MEM_ID, MEM_PW, MEM_NAME, MEM_ADD, MEM_HP, MEM_MAIL, MEM_ROLE FROM FOODMEM WHERE MEM_ID = ? AND MEM_PW = ?",
				    new BeanPropertyRowMapper<>(CustomerVO.class), vo.getMemId(), vo.getMemPw());
        } catch (DataAccessException e) {
        	return null;
        }
    }
}


