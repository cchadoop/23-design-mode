package 行为型模式;

/*
 * 访问者模式：主要将数据结构与数据操作分离
 */
public class VisitorDemo {
	public static void main(String[] args) {
		Element elementA = new ElementA();
		elementA.accept(new ConcreteVisitorA());
	}
}

// element
interface Element {
	public void accept(Visitor2 visitor);
}

class ElementA implements Element {
	private ElementA elementA = null;

	@Override
	public void accept(Visitor2 visitor) {
		visitor.visitElementA(elementA);
	}

	public void operationA() {
		System.out.println("elementA is visited");
	}

}

class ElementB implements Element {
	private ElementB elementB;

	@Override
	public void accept(Visitor2 visitor) {
		visitor.visitElementB(elementB);
	}

	public void operationB() {
		System.out.println("elementB is visited");
	}

}

abstract class Visitor2 {
	public void visitElementA(ElementA elementA) {
	}

	public void visitElementB(ElementB elementB) {
	}
}

class ConcreteVisitorA extends Visitor2 {
	@Override
	public void visitElementA(ElementA elementA) {
		super.visitElementA(elementA);
		elementA = new ElementA();
		elementA.operationA();
	}

	@Override
	public void visitElementB(ElementB elementB) {
		super.visitElementB(elementB);
		elementB.operationB();
	}
}
