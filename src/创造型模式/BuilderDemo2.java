package 创造型模式;

import java.util.ArrayList;
import java.util.List;

/*
 * 构建者模式：将一个复杂对象的构建与表示分离，使得同样的构建过程可以创建不同的表示
 */
public class BuilderDemo2 {
	public static void main(String[] args) {

		Builder builder = new BuilderA();
		BuilderDirector director = new BuilderDirector(builder);
		Product product = director.build();
		product.show();

	}
}

class Product {
	private List<String> parts = new ArrayList<>();

	public void add(String partName) {
		parts.add(partName);
	}

	public void show() {
		for (String part : parts) {
			System.out.print(part);
		}
	}
}

abstract class Builder {
	protected abstract void buildPartA();

	protected abstract void buildPartB();

	protected abstract void buildPartC();

	protected abstract Product getResult();
}

class BuilderA extends Builder {
	private Product product = new Product();

	@Override
	protected void buildPartA() {
		product.add("A");
	}

	@Override
	protected void buildPartB() {
		product.add("B");
	}

	@Override
	protected void buildPartC() {
		product.add("C");
	}

	@Override
	protected Product getResult() {
		return product;
	}

}

class BuilderB extends Builder {
	private Product product;

	@Override
	protected void buildPartA() {
		product.add("X");
	}

	@Override
	protected void buildPartB() {
		product.add("Y");
	}

	@Override
	protected void buildPartC() {
		product.add("Z");
	}

	@Override
	protected Product getResult() {
		return product;
	}

}

class BuilderDirector {
	private Builder builder;

	public BuilderDirector(Builder builder) {
		this.builder = builder;
	}

	public Product build() {
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
		return builder.getResult();
	}
}
