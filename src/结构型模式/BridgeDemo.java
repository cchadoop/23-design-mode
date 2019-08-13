package 结构型模式;

/*
 * 桥接模式就是将抽象部分和实现部分隔离开来
 * 	Abstraction：抽象类  将实现类作为该抽象类的成员变量
	RefinedAbstraction：扩充抽象类
	Implementor：实现类接口   
	ConcreteImplementor：具体实现类
 */
public class BridgeDemo {
	public static void main(String[] args) {
		Abstraction abstraction = new RefindedAbstraction();
		abstraction.setImplementor(new ConcreateImplementorA());
		abstraction.operation();
	}
}

interface Implementor {
	public void operation();
}

class ConcreateImplementorA implements Implementor {

	@Override
	public void operation() {
		System.out.println("ConcreateImplementorA");
	}
}

class ConcreateImplementorB implements Implementor {

	@Override
	public void operation() {
		System.out.println("ConcreateImplementorB");
	}
}

abstract class Abstraction {
	private Implementor implementor;

	public Implementor getImplementor() {
		return implementor;
	}

	public void setImplementor(Implementor implementor) {
		this.implementor = implementor;
	}

	protected void operation() {
		implementor.operation();
	}
}

class RefindedAbstraction extends Abstraction {
	@Override
	protected void operation() {
		super.operation();
	}
}
