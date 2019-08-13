package 行为型模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Vistor: 抽象访问者。为该对象结构中的ConcreteElement的每一个类声明的一个操作。 
      ConcreteVisitor: 具体访问者。实现Visitor申明的每一个操作，每一个操作实现算法的一部分。 
     Element: 抽象元素。定义一个Accept操作，它以一个访问者为参数。 
      ConcreteElement: 具体元素 。实现Accept操作。 
     ObjectStructure: 对象结构。能够枚举它的元素，可以提供一个高层的接口来允许访问者访问它的元素。
 */
public class VisitorDemo2 {
	public static void main(String[] args) {
		Medicine a = new MedicineA("板蓝根", 11.0);
		Medicine b = new MedicineB("感康", 14.3);

		Presciption presciption = new Presciption();
		presciption.addMedicine(a);
		presciption.addMedicine(b);

		Visitor3 charger = new Charger();
		charger.setName("张三");

		Visitor3 workerOfPharmacy = new WorkerOfPharmacy();
		workerOfPharmacy.setName("李四");

		presciption.accept(charger);
		System.out.println("-------------------------------------");
		presciption.accept(workerOfPharmacy);
	}

}

abstract class Visitor3 {
	protected String name;

	public void setName(String name) {
		this.name = name;
	}

	public abstract void visitor(MedicineA a);

	public abstract void visitor(MedicineB b);
}

class Charger extends Visitor3 {
	@Override
	public void visitor(MedicineA a) {
		System.out.println("划价员：" + name + "给药" + a.getName() + "划价:" + a.getPrice());
	}

	@Override
	public void visitor(MedicineB b) {
		System.out.println("划价员：" + name + "给药" + b.getName() + "划价:" + b.getPrice());
	}
}

class WorkerOfPharmacy extends Visitor3 {

	@Override
	public void visitor(MedicineA a) {
		System.out.println("药房工作者：" + name + "拿药 ：" + a.getName());
	}

	@Override
	public void visitor(MedicineB b) {
		System.out.println("药房工作者：" + name + "拿药 ：" + b.getName());
	}
}

abstract class Medicine {
	protected String name;
	protected double price;

	public Medicine(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public abstract void accept(Visitor3 visitor);
}

class MedicineA extends Medicine {
	public MedicineA(String name, double price) {
		super(name, price);
	}

	@Override
	public void accept(Visitor3 visitor) {
		visitor.visitor(this);
	}
}

class MedicineB extends Medicine {
	public MedicineB(String name, double price) {
		super(name, price);
	}

	@Override
	public void accept(Visitor3 visitor) {
		visitor.visitor(this);
	}
}

class Presciption {
	List<Medicine> list = new ArrayList<>();

	public void accept(Visitor3 visitor) {
		Iterator<Medicine> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.next().accept(visitor);
		}
	}

	public void addMedicine(Medicine medicine) {
		list.add(medicine);
	}

	public void removeMedicine(Medicine medicine) {
		list.remove(medicine);
	}
}
