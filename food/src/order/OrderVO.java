package order;

public class OrderVO {
	private String orderId; 
	private String memId;
	private String memName;  
	private String menuName;  
	private int menuId;
	private int menuPrice;  
	private int orderQty;
	private String orderState;
	private String orderDate;  
	
	public OrderVO() {
	}
	
	public OrderVO(String orderId, String memId, String memName, String menuName, int menuId, int menuPrice, int orderQty, String orderState,
			String orderDate) {
		this.orderId = orderId;
		this.memId = memId;
		this.memName = memName;
		this.menuName = menuName; 
		this.menuId = menuId;
		this.menuPrice = menuPrice;
		this.orderQty = orderQty;
		this.orderState = orderState;
		this.orderDate = orderDate;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memId == null) ? 0 : memId.hashCode());
		result = prime * result + ((memName == null) ? 0 : memName.hashCode());
		result = prime * result + menuId;
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + menuPrice;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + orderQty;
		result = prime * result + ((orderState == null) ? 0 : orderState.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderVO other = (OrderVO) obj;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		if (memName == null) {
			if (other.memName != null)
				return false;
		} else if (!memName.equals(other.memName))
			return false;
		if (menuId != other.menuId)
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (menuPrice != other.menuPrice)
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderQty != other.orderQty)
			return false;
		if (orderState == null) {
			if (other.orderState != null)
				return false;
		} else if (!orderState.equals(other.orderState))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderVO [orderId=" + orderId + ", memId=" + memId + ", memName=" + memName + ", menuName=" + menuName
				+ ", menuId=" + menuId + ", menuPrice=" + menuPrice + ", orderQty=" + orderQty + ", orderState="
				+ orderState + ", orderDate=" + orderDate + "]";
	}
	
	
	
	
}
