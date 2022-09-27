package review;

import java.util.Objects;

public class ReviewVO {

	private int rvNo;
	private String memId;
	private String memName;
	private String rvContent;
	private String rvDate;
	
	public ReviewVO() {
	}

	public ReviewVO(int rvNo, String memId, String memName, String rvContent, String rvDate) {
		super();
		this.rvNo = rvNo;
		this.memId = memId;
		this.memName = memName;
		this.rvContent = rvContent;
		this.rvDate = rvDate;
	}

	public int getRvNo() {
		return rvNo;
	}

	public void setRvNo(int rvNo) {
		this.rvNo = rvNo;
	}

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

	public String getRvContent() {
		return rvContent;
	}

	public void setRvContent(String rvContent) {
		this.rvContent = rvContent;
	}

	public String getRvDate() {
		return rvDate;
	}

	public void setRvDate(String rvDate) {
		this.rvDate = rvDate;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewVO reviewVO = (ReviewVO) o;
        return Objects.equals(rvNo, reviewVO.rvNo) &&Objects.equals(memId, reviewVO.memId) && memName == reviewVO.memName 
        		&& Objects.equals(rvContent, reviewVO.rvContent) && Objects.equals(rvDate, reviewVO.rvDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rvNo, memId, memName, rvContent, rvDate);
    }
    

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReviewVO{");
        sb.append(", RV_NO='").append(rvNo).append('\'');
        sb.append(", MEM_ID='").append(memId).append('\'');
        sb.append(", MEM_NAME='").append(memName).append('\'');
        sb.append(", RV_CONTENT=").append(rvContent);
        sb.append(", RV_DATE=").append(rvDate);
        sb.append('}');
        return sb.toString();
    }

}
