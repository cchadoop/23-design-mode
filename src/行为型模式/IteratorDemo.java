package 行为型模式;

/*
 * 迭代器模式：提供一种方法顺序访问一个聚合对象中各个元素, 而又无须暴露该对象的内部表示。
个人总结：Java中的iterator的简单实现原理。
将聚合类中遍历各个元素的行为分离出来，封装成迭代器，让迭代器来处理遍历的任务；使简化聚合类，同时又不暴露聚合类的内部。
 */
public class IteratorDemo {

	public static void main(String[] args) {
		MyContainer myContainer = new MyContainer();
		Iterator iterator = myContainer.getIterator();
		while (iterator.hashNext())
			System.out.println(iterator.next());
	}
}

// 迭代器接口
interface Iterator {
	public boolean hashNext();

	public Object next();
}

// 容器接口
interface Container {
	public Iterator getIterator();
}

// 自定义容器（聚合类）
class MyContainer implements Container {
	public String names[] = { "Robert", "John", "Julie", "Lora" };

	@Override
	public Iterator getIterator() {
		return new MyIterator();
	}

	// 自定义迭代器，迭代器类定义为容器类的内部类
	private class MyIterator implements Iterator {
		int index = 0;

		// 自定义遍历规则
		@Override
		public boolean hashNext() {
			if (index < names.length)
				return true;
			return false;
		}

		@Override
		public Object next() {
			if (this.hashNext())
				return names[index++];
			return null;
		}
	}
}
