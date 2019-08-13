/*
 * 桥接模式：将抽象部分与实现部分分离，使它们都可以独立的变化。
	个人总结：通过对Bridge类的调用，实现了对同一接口下不同实现类的调用；建立一个继承于同一抽象的不同实现类之间的关联关系，这个关系由Bridge类桥接起来。
 */
package 结构型模式;

public class Bridge {

	public static void main(String[] args) {
		AnimalsBridge bridge = new AnimalsBridge(new Dog());
		bridge.method();
	}
}

// 接口
interface Animals {
	public void method();
}

// 实现1
class Cat implements Animals {
	@Override
	public void method() {
		System.out.println("this is cat!");
	}
}

// 实现2
class Dog implements Animals {
	@Override
	public void method() {
		System.out.println("this is dog!");
	}
}

// 将Animals接口下的不同实现，
// 通过桥接模式使它们在抽象层建立一个关联关系。
// 实现之间独立变化，减少耦合
class AnimalsBridge {
	private Animals animals;

	public AnimalsBridge(Animals animals) {
		this.animals = animals;
	}

	public void method() {
		animals.method();
	}
}
