package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import boardUtil.boardUtil;


/**
 * 위의 테이블을 작성하고 게시판을 관리하는
다음 기능들을 구현하시오.

기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
 
------------------------------------------------------------

게시판 테이블 구조 및 시퀀스(DB쿼리)

create table jdbc_board(
    board_no number not null,  -- 번호(자동증가)
    board_title varchar2(100) not null, -- 제목
    board_writer varchar2(50) not null, -- 작성자
    board_date date not null,   -- 작성날짜
    board_content clob,     -- 내용
    constraint pk_jdbc_board primary key (board_no));
create sequence board_seq
    start with 1   -- 시작번호
    increment by 1; -- 증가값

----------------------------------------------------------

// 시퀀스의 다음 값 구하기
//  시퀀스이름.nextVal

 *
 */
public class boardMain {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner scan = new Scanner(System.in);

	/**
	 * 메뉴를 출력하는 메서드
	 */

	public void displayMenu() {
		// 구현 기능 전체 목록 출력, 새글작성, 수정, 삭제, 검색
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체목록 출력");
		System.out.println("  2. 새 글 작성");
		System.out.println("  3. 글 수정");
		System.out.println("  4. 글 삭제");
		System.out.println("  5. 검색");
		System.out.println("  6. 작업 끝");
		System.out.println("---------------------------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	private void start() {
		int choice;
		do {
			displayMenu(); //메뉴출력
			choice = scan.nextInt(); //메뉴번호 입력받기
			switch(choice) {
			case 1 : //전체목록 출력
				selectAllboard();
				break;
			case 2 : //새글 작성
				insertboard();
				break;
			case 3 : //글 수정
				updateboard();
				break;
			case 4: //글 삭제
				deleteboard();
				break;
			case 5: //글 검색
				serchboard();
				break;
			case 6: //작업끝
				System.out.println("작업 끝");
				break;
			
			default : 
				System.out.println("번호를 잘못입력 다시 입력");
				
			}
		} while(choice != 6);

	}
	
//	  board_no number not null,  -- 번호(자동증가)
//	    board_title varchar2(100) not null, -- 제목
//	    board_writer varchar2(50) not null, -- 작성자
//	    board_date date not null,   -- 작성날짜
//	    board_content clob,     -- 내용
	
	//전체목록출력
	private void selectAllboard() {
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println(" 번호\t제목\t작성자\t작성날짜\t내용");
		System.out.println("---------------------------------------");
		
		try {
			conn = boardUtil.getConnection();
			
			String sql = " select * from JDBC_BOARD ";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String boardNo = rs.getString("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardWriter = rs.getString("BOARD_WRITER");
				String boardDate = rs.getString("BOARD_DATE");
				String boardContent =rs.getString("BOARD_CONTENT");
				
				System.out.println(boardNo + "\t" 
						+ boardTitle + "\t"
						+ boardWriter + "\t"
						+ boardDate + "\t"
						+ boardContent + "\t");
		} 
			System.out.println("=================================");
			System.out.println("출력작업 끝");
		
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			boardUtil.close(conn, stmt, pstmt, rs);
		}
	}

	//새글작성
	private void insertboard() {
//		boolean exist = false; //존재하는지 존재하지 않는 지 
		
		System.out.print("제목 >> ");
		String boardTitle = scan.next();
		
		System.out.print("작성자 >> ");
		String boardAuthor = scan.next();
		
		scan.nextLine(); //버퍼 비우기
				
		System.out.print("내용 >> ");
		String boardText = scan.nextLine();
	
		
		try {
			conn = boardUtil.getConnection();
			String sql = "insert into JDBC_BOARD"
					+ " (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CONTENT) "
					+ " values (board_seq.nextVal, ?, ?, sysdate, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,boardTitle); 
			pstmt.setString(2,boardAuthor); 
			pstmt.setString(3,boardText); 
			
			int cnt = pstmt.executeUpdate();
			
			//업데이트가 되면 1이 cnt에 담긴다
			if(cnt>0 ) {
				System.out.println("글 작성 완료");
			} else {
				System.out.println("글 작성 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			boardUtil.close(conn, stmt, pstmt, rs);
		}
	}
	

	 //글수정
	private void updateboard() {
		boolean exist = false;
		
		String boardNo = "";
		this.selectAllboard();
		
			System.out.println();
			System.out.println("수정 할 글 번호를 입력하세요");
			System.out.println("글 번호 >> ");
			
			boardNo = scan.next();
			
	}

	//글 삭제
	private void deleteboard() {
		
		this.selectAllboard();
		System.out.println();
		System.out.println("삭제할 글 목록을 입력하세요 ");
		String boardNo = scan.next();
		
		try {
			
 			conn = boardUtil.getConnection();
			String sql = "delete from jdbc_board where Board_no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, boardNo);
			
			int cnt = pstmt.executeUpdate();
			if(cnt > 0 ) {
				System.out.println(boardNo + "번글 삭제가 완료 되었습니다.");
			} else {
				System.out.println(boardNo + "번글 삭제 실패");
			}
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			boardUtil.close(conn, stmt, pstmt, rs);
		}
	}

	// 글 검색
	private void serchboard() {
		
	}
//////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		boardMain boardMain = new boardMain();
		boardMain.start();
	}
}
