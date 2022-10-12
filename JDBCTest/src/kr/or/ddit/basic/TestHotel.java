package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.JDBCUtil2;

/**
 * 문제)

호텔 운영을 관리하는 프로그램 작성.(DB 이용)
 - 키값은 방번호 
 
실행 예시)

**************************
호텔 문을 열었습니다.
**************************

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 1 <-- 입력

어느방에 체크인 하시겠습니까?
방번호 입력 => 101 <-- 입력

누구를 체크인 하시겠습니까?
이름 입력 => 홍길동 <-- 입력
체크인 되었습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 1 <-- 입력

어느방에 체크인 하시겠습니까?
방번호 입력 => 102 <-- 입력

누구를 체크인 하시겠습니까?
이름 입력 => 성춘향 <-- 입력
체크인 되었습니다

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 3 <-- 입력

방번호 : 102, 투숙객 : 성춘향
방번호 : 101, 투숙객 : 홍길동

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 2 <-- 입력

어느방을 체크아웃 하시겠습니까?
방번호 입력 => 101 <-- 입력
체크아웃 되었습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 1 <-- 입력

어느방에 체크인 하시겠습니까?
방번호 입력 => 102 <-- 입력

누구를 체크인 하시겠습니까?
이름 입력 => 허준 <-- 입력
102방에는 이미 사람이 있습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 2 <-- 입력

어느방을 체크아웃 하시겠습니까?
방번호 입력 => 101 <-- 입력
101방에는 체크인한 사람이 없습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 3 <-- 입력

방번호 : 102, 투숙객 : 성춘향

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 4 <-- 입력

**************************
호텔 문을 닫았습니다.
**************************
*/

/* 호텔운영 프로그램 테이블 생성 스크립트 */
/*create table hotel_mng (
    room_num number not null,  -- 방번호
    guest_name varchar2(10) not null -- 투숙객 이름
);


 */
public class TestHotel {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in); 
	
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("*******************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("*******************************************");
		System.out.print("메뉴선택 => ");
	
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	public void start(){
		
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			
			switch(choice){
				case 1 :  // 체크인
					checkIn();
					break;

				case 2 :  // 체크아웃
					chechOut();
					break;

				case 3 :  // 객실상태
					roomstate();
					break;

				case 4 :  // 업무종료
					System.out.println("**************************");
					System.out.println("호텔 문을 닫았습니다.");
					System.out.println("**************************");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=4);
	}
	
//////////////////////////////////////////////////////////////
	
	//객실상태
	private void roomstate() {
		try {
			conn = JDBCUtil2.getConnection();
			
			String sql = "select * from HOTEL_MNG";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int ROOM_NUM = rs.getInt("ROOM_NUM");
				String GUEST_NAME = rs.getNString("GUEST_NAME");
				
				System.out.println("방번호: " + ROOM_NUM +
						", 투숙객 : " + GUEST_NAME);
			
			
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil2.close(conn, stmt, pstmt, rs);
		}
		
	}
	
	//체크아웃
	private void chechOut() {
		
		System.out.println();	
		System.out.println("어느방을 체크아웃 하시겠습니까?");	
		System.out.print("방번호 입력 => ");
		
		int ROOM_NUM = scan.nextInt();
		
		try {
			conn = JDBCUtil2.getConnection();
			
			String sql = "delete from HOTEL_MNG where ROOM_NUM = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ROOM_NUM);

			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("체크아웃 되었습니다.");
				
			} 
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil2.close(conn, stmt, pstmt, rs);
		}
		
	}
	
	//체크인
	private void checkIn() {
		
		boolean exist = false;
		int ROOM_NUM = 0;
		String GUEST_NAME = "";
		
		do {
			System.out.print("방번호 입력 => ");
			ROOM_NUM = scan.nextInt();
			
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.print("이름 입력 => ");
			GUEST_NAME = scan.next();
			
			exist = checkMember(ROOM_NUM);
		
			//이미 예약된 방인지
		if(exist) {
			System.out.println(ROOM_NUM + "방에는 이미 사람이 있습니다.");
			return;
		} 
	} while(exist);
		
		try {

			conn = JDBCUtil2.getConnection(); //커넥션 가져오기
			String sql = "insert into HOTEL_MNG " 
					+ " (ROOM_NUM, GUEST_NAME) " 
					+ " values (?, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,ROOM_NUM);
			pstmt.setString(2,GUEST_NAME);
			
			int cnt  = pstmt.executeUpdate();
		
		if(cnt > 0 ) {
				System.out.println("체크인되었습니다.");
			} else {
				System.out.println(ROOM_NUM + "방에는 이미 사람이 있습니다.");
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}  finally {
			JDBCUtil2.close(conn,stmt,pstmt,rs);
		}
	}

		
	/**
	 * ROOM_NUM 이용하여 방에 회원이 존재하는 지 체크하기 위한 메서드
	 * @param ROOM_NUM 체크할 회원 ID
	 * @return 존재하면 true, 존재하지 않으면 flase 
	 */
	
private boolean checkMember(int ROOM_NUM) {
		
		boolean exist = false;
		
		try {
			conn = JDBCUtil2.getConnection();
			
			String sql = "select count(*) as cnt "  
						 + "from HOTEL_MNG "  
						 + "where ROOM_NUM = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ROOM_NUM);
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
			if(cnt > 0 ) {
				exist = true;
			} 
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil2.close(conn, stmt, pstmt, rs);
		}
		return exist;
	}

//////////////////////////////메인 실행//////////////////////////////

	public static void main(String[] args) {
		TestHotel testHotel = new TestHotel();
		testHotel.start();
		
	}
}
















