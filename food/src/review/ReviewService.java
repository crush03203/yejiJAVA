package review;

import java.util.List;

//서비스 : 비즈니스로직(기능). Controller(요청 수렴)에서 고객의 요청을 받아 Service로 구현
public class ReviewService {
	// 싱글톤 객체 생성
	private static ReviewService instance = new ReviewService();

	public static ReviewService getInstance() {
		return instance;
	}

	private ReviewService() {
	}

	// DAO객체 주입하여 service에서 dao객체를 사용.
	private ReviewDAO dao = ReviewDAO.getInstance();

	// 전체리뷰 출력
	public List<ReviewVO> findReview() {
		return dao.findReview();
	}

	// 리뷰 등록
	public int addReview(String commant, String id, String name){
		return dao.addReview(commant, id, name);
	}

	// 리뷰 삭제
	public int deleteReview(String reviewId) {
		return dao.deleteReview(reviewId);
	}
}
