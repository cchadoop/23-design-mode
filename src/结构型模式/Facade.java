package 结构型模式;

/*
 * 外观模式：为子系统中的一组接口提供一个一致的界面，外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
	个人总结：在客户端和复杂系统之间再加一层，在这一层中将调用顺序、依赖关系等处理好。提供一个容易使用的外观层。
 */
public class Facade {

	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.put();
	}
}

class CPU {
	public void work() {
		// 复杂的操作
		System.out.println("CPU is working!");
	}
}

class Disk {
	public void put() {
		// 复杂的操作
		System.out.println("put in disk!");
	}
}

// 外观类,隐藏了系统的复杂性，提供简化的方法（访问系统的接口）
// 客户端不需要知道系统内部的复杂联系
class Computer {
	private CPU cpu;
	private Disk disk;

	public Computer() {
		cpu = new CPU();
		disk = new Disk();
	}

	public void work() {
		cpu.work();
	}

	public void put() {
		disk.put();
	}
}
