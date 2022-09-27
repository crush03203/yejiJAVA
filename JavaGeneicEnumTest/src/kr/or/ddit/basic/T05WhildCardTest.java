package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T05WhildCardTest {

	// 장바구니 항목 조회를 위한 메서드(모든 항목)
	public static void displayCartItemInfo(Cart<?> cart) {

		System.out.println("= 음식류 장바구니 항목 리스트  =");
		for (Object item : cart.getList()) {
			System.out.println(item);
		}
		System.out.println("--------------------------");
	}

	// 장바구니 항목 조회를 위한 메서드(음료나 그 하위 항목)
	public static void displayCartItemInfo2(Cart<? extends Drink> cart) {

		System.out.println("= 음료나 그 하위 항목 장바구니 항목 리스트  =");
		for (Object item : cart.getList()) {
			System.out.println(item);
		}
		System.out.println("--------------------------");
	}

	// 장바구니 항목 조회를 위한 메서드(고기류나 그 상위 항목)
	public static void displayCartItemInfo3(Cart<? super Meat> cart) {

		System.out.println("= 고기류나 그 상위 항목 장바구니 항목 리스트  =");
		for (Object item : cart.getList()) {
			System.out.println(item);
		}
		System.out.println("--------------------------");
	}

	public static void main(String[] args) {
		Cart<Food> foodCart = new Cart<>();
		foodCart.add(new Meat("돼지고기", 5000));
		foodCart.add(new Meat("소고기", 25000));
		foodCart.add(new Juice("토마토주스", 1000));
		foodCart.add(new Coffee("아메리카노", 1500));

		Cart<Meat> meatCart = new Cart<>();
		meatCart.add(new Meat("돼지고기", 5000));
		meatCart.add(new Meat("소고기", 25000));
//		meatCart.add(new Juice("토마토주스", 1000)); //오류남 미트가 아니니깐
//		meatCart.add(new Coffee("아메리카노", 1500)); //오류남 미트가 아니니깐

		Cart<Drink> drinkCart = new Cart<>();
//		drinkCart.add(new Meat("돼지고기", 5000)); //오류남 음료가 아님
//		drinkCartt.add(new Meat("소고기", 25000)); //오류남 음료가 아님
		drinkCart.add(new Juice("토마토주스", 1000));
		drinkCart.add(new Coffee("아메리카노", 1500));

		/////////////////////////////////////////////////
		displayCartItemInfo(foodCart); // 뭐가와도 상관 없음 오류 안남
		displayCartItemInfo(meatCart);
		displayCartItemInfo(drinkCart);

//		displayCartItemInfo2(foodCart); //드링크 카트기 때문에 드링크랑 드링크 하위만 가능하다
//		displayCartItemInfo2(meatCart);
		displayCartItemInfo2(drinkCart);

		displayCartItemInfo3(foodCart); // 드링크만 오류남 이유는 미트나 미트상위만 가능하기 때문에
		displayCartItemInfo3(meatCart);
//		displayCartItemInfo3(drinkCart);

	}

}

class Food {
	private String name; // 음식이름
	private int price; // 가격

	public Food(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return this.name + "(" + this.price + "원)";
	}
}

class Meat extends Food {

	public Meat(String name, int price) {
		super(name, price);
	}

}

class Drink extends Food {

	public Drink(String name, int price) {
		super(name, price);
	}

}

class Juice extends Drink {

	public Juice(String name, int price) {
		super(name, price);
	}
}

class Coffee extends Drink {

	public Coffee(String name, int price) {
		super(name, price);
	}

}

//장바구니 클래스
class Cart<T> {
	private List<T> list = new ArrayList<T>();

	public List<T> getList() {
		return list;
	}

	public void add(T item) {
		list.add(item);
	}
}
