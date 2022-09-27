package review;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import afood.FoodApplication;

//DAO(Date Access Object) : 라클아 데이터 다오
//Service와 DB사이에서 데이터를 전달(VO에 담아서..)
public class ReviewDAO { 

	private static ReviewDAO instance = new ReviewDAO();
    public static ReviewDAO getInstance() { //껍데기
        return instance;
    }
    
    //review 테이블에 데이터를 select
    private ReviewDAO() {}
    
    //Jdbc : Java Databace Connectivity 템플릿을 사용해보자
    private JdbcTemplate template = FoodApplication.getTemplate();

    
//    리뷰리스트 조회 
    public List<ReviewVO> findReview() {
    	//쿼리 입력, 실행
//    	System.out.print("\n 리뷰 다오  - 전체 리뷰 출력[findReview] 호출됨 ");
    	return template.query("SELECT RV_NO, MEM_ID, MEM_NAME, RV_CONTENT, to_char(rv_date,'yyyy/mm/dd') rv_date FROM FOODREVIEW order by 5 desc", new BeanPropertyRowMapper<>(ReviewVO.class));
    }
    
//    리뷰 등록
    public int addReview(String commant, String id, String name) {
    	//쿼리 입력, 실행
    	// 현재 날짜 구하기        
    	LocalDate now = LocalDate.now();        
    	// 포맷 정의      
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");        
    	// 포맷 적용       
    	String formatedNow = now.format(formatter);        
    	// 결과 출력       
//    	System.out.println(formatedNow);  
    	
//    	System.out.print("\n 리뷰 다오  - 전체 리뷰 등록[addReview] 호출됨  : 파라미터-->"+ id +" " +name+ " "+ formatedNow);
    	return template.update("INSERT INTO foodreview (rv_no, mem_id, mem_name, rv_content, rv_date) VALUES ((select max(nvl(rv_no, 1)) + 1 from foodreview), ?,?,?,?)", id, name,commant ,formatedNow );
    }
    
//    리뷰 삭제
    public int deleteReview(String reviewId) {
    	//쿼리 입력, 실행
//    	System.out.print("\n 리뷰 다오  - 리뷰 삭제[deleteReview] 호출됨  : 파라미터-->"+ reviewId );

        return template.update("delete from foodreview where rv_no = ? ", reviewId);
    }
    
}