package 行为型模式;

/*
 * 迭代器模式（Iterator），提供一种方法顺序访问一个聚合对象中的各种元素，而又不暴露该对象的内部表示。
 * (1)迭代器角色（Iterator）:定义遍历元素所需要的方法，
 * 一般来说会有这么三个方法：取得下一个元素的方法next()，判断是否遍历结束的方法hasNext()），移出当前对象的方法remove(),
(2)具体迭代器角色（Concrete Iterator）：实现迭代器接口中定义的方法，完成集合的迭代。
(3)容器角色(Aggregate):  一般是一个接口，提供一个iterator()方法，
例如java中的Collection接口，List接口，Set接口等
(4)具体容器角色（ConcreteAggregate）：就是抽象容器的具体实现类，
比如List接口的有序列表实现ArrayList，List接口的链表实现LinkList，Set接口的哈希列表的实现HashSet等。
 */
public class IteratorDemo2 {
	public static void main(String[] args) {
		List list = new ConcreteAggregate();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		Iterator2 it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

// 定义迭代器角色(Iterator)
interface Iterator2 {
	public boolean hasNext();

	public Object next();

	public Object remove(int index);
}

// 定义具体迭代器角色(Concrete Iterator)
class ConcreteIterator implements Iterator2 {
	private List list;
	private int index;

	public ConcreteIterator(List list) {
		super();
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		if (index >= list.getSize()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		Object object = list.get(index);
		index++;
		return object;
	}

	@Override
	public Object remove(int index) {
		return null;
	}
}

// 定义容器角色(Aggregate)
// 定义集合可以进行的操作
interface List {
	public void add(Object obj);

	public Object remove(int index);

	public Object get(int index);

	public Iterator2 iterator();

	public int getSize();
}

// 定义具体容器角色(ConcreteAggregate)
class ConcreteAggregate implements List {

	private Object[] list;
	private int size = 0;
	private int index = 0;

	public ConcreteAggregate() {
		index = 0;
		size = 0;
		list = new Object[100];
	}

	@Override
	public void add(Object obj) {
		list[index++] = obj;
		size++;
	}

	@Override
	public Object get(int index) {
		return list[index];
	}

	@Override
	public Iterator2 iterator() {
		return new ConcreteIterator(this);
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public Object remove(int index) {
		return null;
	}

}
