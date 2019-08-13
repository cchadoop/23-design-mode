package 结构型模式;

/*
 * 享元模式：运用共享技术有效地支持大量细粒度的对象。
	个人总结：重用现有的同类对象，若未找到匹配的对象，则创建新对象。
	例如，数据库的连接池。减少对象的创建，降低系统内存，提高效率。
 */
import java.util.HashMap;

public class Flyweight {

	public static void main(String[] args) {
		// red Circle默认存在，所以拿的时候不用new
		Circle circle = CircleFactory.getCircle("red");
		circle.draw();
		for (int i = 0; i < 2; i++) {
			// 第一次拿的时候需要new green Circle，第二次拿的时候不用new
			circle = CircleFactory.getCircle("green");
			circle.draw();
		}
	}
}

class Circle {
	private String color;

	public Circle(String color) {
		this.color = color;
	}

	public void draw() {
		System.out.println(color + " Circle!");
	}
}

class CircleFactory {
	private static final HashMap<String, Circle> circleMap = new HashMap<String, Circle>();
	static {
		// 初始化，存放red Circle
		circleMap.put("red", new Circle("red"));
	}

	public static Circle getCircle(String color) {
		Circle circle = (Circle) circleMap.get(color);
		// Map如果不存在该颜色的Circle，则新建
		if (circle == null) {
			circle = new Circle(color);
			circleMap.put(color, circle);
			System.out.println("new a circle of color: " + color);
		}
		// 如果存在，则返回Map中的对象
		return circle;
	}
}