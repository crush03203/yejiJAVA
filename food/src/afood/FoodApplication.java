package afood;

import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import join.CustomerVO;
import oracle.jdbc.pool.OracleDataSource;

public class FoodApplication {
	private static CustomerVO session = new CustomerVO();
    private static JdbcTemplate template = new JdbcTemplate();

    public static void main(String[] args) {
        new Home().initialize();
    }
    
    public static CustomerVO getSession() {
        return session;
    }
    public static JdbcTemplate getTemplate() {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL("jdbc:oracle:thin:@192.168.35.13:1521:xe");
            dataSource.setUser("FOOD");
            dataSource.setPassword("java");
            template.setDataSource(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return template;
    }
}

