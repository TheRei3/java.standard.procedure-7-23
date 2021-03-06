package ex7no23;

import java.util.Vector;

class Product3{
	int price;
	int bonusPoint;
	
	Product3(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
	
	Product3() {
		price = 0;
		bonusPoint = 0;
	}
}

class Tv3 extends Product3 {

	Tv3() { super(100); }
	
	public String toString() { return "Tv";}
}

class Computer3 extends Product3 {
	Computer3() { super(200); }
	
	public String toString() { return "Computer";}
}

class Audio3 extends Product3 {

	Audio3() { super(50); }
	
	public String toString() { return "Audio";}
}


class buyer3 {
	int money = 1000;
	int bounsPoint = 0;
	Vector item = new Vector();
	
	void buy(Product3 p) {
		if(money < p.price) {
			System.out.println("??‘?΄ λΆ?μ‘±ν?¬ λ¬Όκ±΄? ?΄ ? ??΅??€.");
			return;
		}
		
		money -= p.price;
		bounsPoint += p.bonusPoint;
		item.add(p);
		System.out.println(p + "?/λ₯? κ΅¬μ??¨?΅??€.");
	}
	
	void refund(Product3 p) {
		if(item.remove(p)) {
			money += p.price;
			bounsPoint -= p.bonusPoint;
			System.out.println(p+"?.λ₯? λ°ν??¨?΅??€.");
		}else {
			System.out.println("κ΅¬μ??  ? ? μ€? ?΄?Ή ? ??΄ ??΅??€.");
		}
	
	}
	
	void summary() {
		int sum = 0;
		String itemList = "";
		
		for(int i =0; i < item.size() ; i++){
			Product3 p = (Product3) item.get(i);
			sum += p.price;
			itemList += (i==0) ? "" + p : ", " + p ;
		}
		
		System.out.println("κ΅¬μ??  λ¬Όν? μ΄κΈ?‘?? "+ sum + "λ§μ???€.");
		System.out.println("κ΅¬μ??  ? ??? "+ itemList + "???€.");
	}
}

public class ex7no23 {  //  368p
	public static void main(String[] args) {
		buyer3 b = new buyer3();
		Tv3 tv = new Tv3();
		Computer3 com = new Computer3();
		Audio3 audio = new Audio3();
		
		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.summary();
		System.out.println();
		b.refund(com);
		b.summary();
		
	}

}
