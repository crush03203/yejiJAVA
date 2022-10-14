package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.util.JDBCUtil3;
import sun.security.jca.GetInstance;

public class MemberDaoImple implements IMemberDao {
	
	private static IMemberDao memDao;
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	private MemberDaoImple() {
	}
	
	public static IMemberDao getInstance() {
		if(memDao == null) {
			memDao = new MemberDaoImple();
		}
		return memDao;
	}
	
	
	@Override
	public int insertMember(MemberVO mv) {

		int cnt = 0;

		try {

			conn = JDBCUtil3.getConnection(); // 커넥션 가져오기

			String sql = " insert into mymember " + " (MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR, REG_DT)"
					+ " values (?, ?, ?, ?, sysdate)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMemId());
			pstmt.setString(2, mv.getMemName());
			pstmt.setString(3, mv.getMemTel());
			pstmt.setString(4, mv.getMemAddr());

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public boolean checkMember(String memID) {

		boolean exist = false;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "select count(*) as cnt " + " from mymember " + " where mem_id = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memID);

			rs = pstmt.executeQuery();

			int cnt = 0;

			while (rs.next()) { // 한 번 도니까 while 안쓰고 if 써도 됨
				cnt = rs.getInt("cnt");
			}

			if (cnt > 0) {
				exist = true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return exist;
	}

	@Override
	public int updateMember(MemberVO mv) {

		int cnt = 0;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = " update mymember" + " set mem_name = ?," + "     mem_tel = ?," + "     mem_addr = ?"
					+ " where mem_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMemName());
			pstmt.setString(2, mv.getMemTel());
			pstmt.setString(3, mv.getMemAddr());
			pstmt.setString(4, mv.getMemId());

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();

			String sql = "delete from mymember where mem_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<MemberVO> selectAllMember() {

		List<MemberVO> memList = new ArrayList<MemberVO>();
		try {

			conn = JDBCUtil3.getConnection();

			String sql = "select * from mymember";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				MemberVO mv = new MemberVO();
				mv.setMemId(rs.getNString("mem_id"));
				mv.setMemName(rs.getString("mem_name"));
				mv.setMemTel(rs.getString("mem_tel"));
				mv.setMemAddr(rs.getString("mem_addr"));

				memList.add(mv);
			}
			System.out.println("--------------------------------------");
			System.out.println("출력 작업 끝.");

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<MemberVO>();

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "select * from mymember where 1=1 ";
			if(mv.getMemId() != null 
					&& !mv.getMemId().equals("")) {
				sql += " and mem_id = ? ";
			}
			if(mv.getMemName() != null 
					&& !mv.getMemName().equals("")) {
				sql += " and mem_name = ? ";
			}
			if(mv.getMemTel() != null 
					&& !mv.getMemTel().equals("")) {
				sql += " and mem_tel = ? ";
			}
			if(mv.getMemAddr() != null 
					&& !mv.getMemAddr().equals("")) {
				sql += "and MEM_addr like '%'|| ? || '%' ";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			int index = 1;
			if(mv.getMemId() != null 
					&& !mv.getMemId().equals("")) {
				pstmt.setString(index++,mv.getMemId());
			}
			if(mv.getMemName() != null 
					&& !mv.getMemName().equals("")) {
				pstmt.setString(index++,mv.getMemName());
			}
			if(mv.getMemTel() != null 
					&& !mv.getMemTel().equals("")) {
				pstmt.setString(index++,mv.getMemTel());
			}
			if(mv.getMemAddr() != null 
					&& !mv.getMemAddr().equals("")) {
				pstmt.setString(index++,mv.getMemAddr());
			}
			
			//싱글톤 객체를 하나만 생성할 수 있는 것
			
			
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				MemberVO mv2 = new MemberVO();
				mv2.setMemId(rs.getNString("mem_id"));
				mv2.setMemName(rs.getString("mem_name"));
				mv2.setMemTel(rs.getString("mem_tel"));
				mv2.setMemAddr(rs.getString("mem_addr"));

				memList.add(mv2);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return memList;
	}

}