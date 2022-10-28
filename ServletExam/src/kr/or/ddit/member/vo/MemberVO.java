package kr.or.ddit.member.vo;

import java.sql.Date;

//value Object : 데이터들을 담고있는 객체

/**
 * DB 테이블에 존재하는 컬럼이름을 기준으로 테이터를 객체화한 클래스
 * @author PC-12
 * 
 *DB테이블의 '컬럼'이 이 클래스의 '멤버변수'가 된다
 * <p>
 * DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.<br>
 * </p>
 *
 */
public class MemberVO {
	private String memId;
	private String memName;
	private String memTel;
	private String memAddr;
	
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	private Date regDate;

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memName=" + memName + ", memTel=" + memTel + ", memAddr=" + memAddr
				+ ", regDate=" + regDate + "]";
	}

	
	
	
	
	
}
