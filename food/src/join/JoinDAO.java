package join;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import afood.FoodApplication;

public class JoinDAO {
   private static JoinDAO instance = new JoinDAO();

   public static JoinDAO getInstance() {
      return instance;
   }

   private JoinDAO() {
   }

    private JdbcTemplate template = FoodApplication.getTemplate();

    public int join(CustomerVO vo) {
        return template.update("INSERT INTO FOODMEM (MEM_ID, MEM_PW, MEM_NAME, MEM_ADD, MEM_HP, MEM_MAIL) VALUES (?, ?, ?, ?, ?, ?)", 
              vo.getMemId(), vo.getMemPw(), vo.getMemName(), vo.getMemAdd(), vo.getMemHp(), vo.getMemMail() );
    }          
    public List<CustomerVO> findCustomer(String serchAllOrder) {
        return template.query("SELECT MEM_ID, MEM_PW, MEM_NAME, MEM_ADD, MEM_HP, MEM_MAIL, MEM_ROLE from foodmem where mem_role ='회원'", new BeanPropertyRowMapper<>(CustomerVO.class));
    }
}