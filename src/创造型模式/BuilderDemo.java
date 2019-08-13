package 创造型模式;

/*
 * 建造者模式：将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。
	个人总结：将一些不会变的基本组件，通过builder，组合，构建复杂对象，实现分离
 */
public class BuilderDemo {

	public static void main(String[] args) {
		PriceBuilder priceBuilder = new PriceBuilder();
		System.out.println("Car1和Car2:" + priceBuilder.Car1AndCar2());
		System.out.println("Car1和Bus:" + priceBuilder.Car1AndBus());
		System.out.println("Car1和Car2:" + priceBuilder.descCar1AndCar2());
	}
}

// 基本组件
interface Car {
}

// 基本组件1
class Car1 implements Car {
	int price = 20;
	String color = "blue";
}

// 基本组件2
class Car2 implements Car {
	int price = 90;
	String color = "white";
}

// 基本组件3
class Bus {
	int price = 500;
	String color = "red";
}

class PriceBuilder {
	// car1和car2的总价格
	public int Car1AndCar2() {
		int priceOfCar1 = new Car1().price;
		int priceOfCar2 = new Car2().price;
		return priceOfCar1 + priceOfCar2;
	}

	// car1和bus的总价格
	public int Car1AndBus() {
		int priceOfCar1 = new Car1().price;
		int priceOfBus = new Bus().price;
		return priceOfCar1 + priceOfBus;
	}

	public String descCar1AndCar2() {
		String str = "";
		String strCar1 = new Car1().color;
		String strCar2 = new Car2().color;
		str = strCar1 + "---" + strCar2;
		return str;
	}
}
