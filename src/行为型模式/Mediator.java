package 行为型模式;

/*
 * 中介者模式：用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，
 * 从而使其耦合松散，而且可以独立地改变它们之间的交互。
个人总结：中介者对象，用来封装关联对象之间的交互操作，使关联对象之间耦合度松散；
例如，MVC模式中"控制器"就是"模型"和"视图"的中介者；
与适配器模式的区别：适配器模式为了桥接互不兼容的接口，中介者为了分离原始结构和交互行为。
 */
public class Mediator {

	public static void main(String[] args) {
		User1 user1 = new User1("小明");
		User2 user2 = new User2("小红");
		UserMediator userMediator = new UserMediator(user1, user2);
		userMediator.introduceYourselves();
	}
}

class User1 {
	private String name;

	public String getName() {
		return name;
	}

	public User1(String name) {
		this.name = name;
	}
}

class User2 {
	private String name;

	public String getName() {
		return name;
	}

	public User2(String name) {
		this.name = name;
	}
}

// 中介者，用来封装User1与User2的交互操作
class UserMediator {
	private User1 user1;
	private User2 user2;

	// 将User1与User2传入它们的中介者
	public UserMediator(User1 user1, User2 user2) {
		this.user1 = user1;
		this.user2 = user2;
	}

	public void introduceYourselves() {
		System.out.println("Hello " + user1.getName() + ",I'm " + user2.getName());
		System.out.println("Hi " + user2.getName() + ",My name is " + user1.getName());
	}
}
