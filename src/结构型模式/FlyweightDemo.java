package 结构型模式;

import java.util.HashMap;

/*	享元模式：减少资源浪费，如连接池
 * 	Flyweight: 抽象享元类
	ConcreteFlyweight: 具体享元类
	UnsharedConcreteFlyweight: 非共享具体享元类
	FlyweightFactory: 享元工厂类
 */
public class FlyweightDemo {
	public static void main(String[] args) {
		int extrinsic = 22;
		Flyweight2 flyweightX = FlyweightFactory.getFlyweight("X");
		flyweightX.operate(++extrinsic);

		Flyweight2 flyweightY = FlyweightFactory.getFlyweight("Y");
		flyweightY.operate(++extrinsic);

		Flyweight2 flyweightZ = FlyweightFactory.getFlyweight("Z");
		flyweightZ.operate(++extrinsic);

		Flyweight2 flyweightReX = FlyweightFactory.getFlyweight("X");
		flyweightReX.operate(++extrinsic);

		Flyweight2 unsharedFlyweight = new UnsharedConcreteFlyweight("X");
		unsharedFlyweight.operate(++extrinsic);
	}
}

abstract class Flyweight2 {

	// 内部状态
	public String intrinsic;
	// 外部状态
	protected final String extrinsic;

	// 要求享元角色必须接受外部状态
	public Flyweight2(String extrinsic) {
		this.extrinsic = extrinsic;
	}

	// 定义业务操作
	public abstract void operate(int extrinsic);

	public String getIntrinsic() {
		return intrinsic;
	}

	public void setIntrinsic(String intrinsic) {
		this.intrinsic = intrinsic;
	}
}

class ConcreteFlyweight extends Flyweight2 {
	public ConcreteFlyweight(String extrinsic) {
		super(extrinsic);
	}

	@Override
	public void operate(int extrinsic) {
		System.out.println("具体Flyweight:" + extrinsic);
	}
}

class UnsharedConcreteFlyweight extends Flyweight2 {
	public UnsharedConcreteFlyweight(String extrinsic) {
		super(extrinsic);
	}

	@Override
	public void operate(int extrinsic) {
		System.out.println("不共享的具体Flyweight:" + extrinsic);
	}
}

class FlyweightFactory {

	// 定义一个池容器
	private static HashMap<String, Flyweight2> pool = new HashMap<>();

	// 享元工厂
	public static Flyweight2 getFlyweight(String extrinsic) {
		Flyweight2 flyweight = null;

		if (pool.containsKey(extrinsic)) { // 池中有该对象
			flyweight = pool.get(extrinsic);
			System.out.print("已有 " + extrinsic + " 直接从池中取---->");
		} else {
			// 根据外部状态创建享元对象
			flyweight = new ConcreteFlyweight(extrinsic);
			// 放入池中
			pool.put(extrinsic, flyweight);
			System.out.print("创建 " + extrinsic + " 并从池中取出---->");
		}
		return flyweight;
	}
}