package review;

import java.util.List;

//고객의 요청을 여기서 수렴하여 Service(기능) 로직 수행
public class ReviewController {
	// 싱글톤 객체 생성
	private static ReviewController instance = new ReviewController();

	public static ReviewController getInstance() {
		return instance;
	}

	private ReviewController() {
	}

	// ReviewService 객체 생성
	private ReviewService service = ReviewService.getInstance();

	// 리뷰목록출력
	public List<ReviewVO> findAll() {
		return service.findReview();
	}

	// 리뷰생성출력
	public int addReview(String commant, String id, String name) {
		return service.addReview(commant, id, name);
	}

	// 리뷰삭제출력 
	public int deleteReview(String reviewId) {
		return service.deleteReview(reviewId);
	}
}
