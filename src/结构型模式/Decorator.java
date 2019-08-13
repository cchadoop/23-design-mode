package 结构型模式;

/*
 * 装饰器模式：动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。
	个人总结：创建类的装饰类，对被装饰类增强功能。装饰模式是继承的一个替代模式。
 */
public class Decorator {

	public static void main(String[] args) {
		Animals2 dog = new AnimalsDecorator(new Dog2());
		dog.run();
	}
}

interface Animals2 {
	public void run();
}

// 被装饰类
class Dog2 implements Animals2 {
	@Override
	public void run() {
		System.out.println("dog run!");
	}
}

// 装饰类
class AnimalsDecorator implements Animals2 {
	private Animals2 animals;

	// 动态装饰，参数为Animals接口，传入什么实现就装饰什么实现
	// 继承不能做到这一点，继承的功能是静态的，不能动态增删。
	public AnimalsDecorator(Animals2 animals) {
		this.animals = animals;
	}

	@Override
	// 装饰run()方法
	public void run() {
		animals.run();
		System.out.println("fast!");
	}
}
