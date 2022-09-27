package join;

public class CustomerVO {
	private String memId; //고객아이디
    private String memPw; //고객비밀번호
	private String memName; //고객이름
	private String memAdd;
	private String memHp; //고객폰번호
	private String memMail; //고객 메일주소
	private String memRole;
	   
	public CustomerVO(){}; 
	
	public CustomerVO(String memId) {
		this.memId = memId;
	}

	public CustomerVO(String memId, String memPw) {
		this.memId = memId;
	    this.memPw = memPw;
	 }
	
	public CustomerVO(String memId, String memPw, String memName, String memAdd, String memHp, String memMail) {
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memAdd = memAdd;
		this.memHp = memHp;
		this.memMail = memMail;
	}


	public CustomerVO(String memId, String memPw, String memName, String memAdd, String memHp, String memMail, String memRole) {
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memAdd = memAdd;
		this.memHp = memHp;
		this.memMail = memMail;
		this.memRole = memRole;
	}
	 
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}
	
	public String getMemAdd() {
		return memAdd;
	}

	public void setMemAdd(String memAdd) {
		this.memAdd = memAdd;
	}
	
	public String getMemHp() {
		return memHp;
	}

	public void setMemHp(String nenHp) {
		this.memHp = nenHp;
	}

	public String getMemMail() {
		return memMail;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}

	public String getMemRole() {
		return memRole;
	}

	public void setMemRole(String memRole) {
		this.memRole = memRole;
	}

	public void invalidate() {
	     this.memId = null;
	     this.memPw = null;
	     this.memName = null;
	     this.memAdd = null;
	     this.memHp = null;
	     this.memMail = null;
	     this.memRole = null;
	}

	@Override
	public String toString() {
		return "CustomerVO [memId=" + memId + ", memPw=" + memPw + ", memName=" + memName + ", memAdd=" + memAdd
				+ ", memHp=" + memHp + ", memMail=" + memMail + ", memRole=" + memRole + "]";
	}

}
