package 行为型模式;

/*
 * 状态模式：允许对象在内部状态发生改变时改变它的行为，对象看起来好像修改了它的类。
	个人总结：对象具有多种状态，且每种状态具有特定的行为；应用场景: 行为随状态改变而改变的场景。
	代码形式似乎也和哪种设计模式相似，还是那句话，设计模式提倡的是思想，而不是形式。
	Context: 环境类
	State: 抽象状态类
	ConcreteState: 具体状态类
 */
public class StateDemo {

	public static void main(String[] args) {
		QQContext context = new QQContext();
		// 设置状态，不同的状态对应不同的行为
		context.setState(new OnlineState());
		context.getState().getMessage();
		context.setState(new StealthState());
		context.getState().getMessage();
	}
}

// State: 抽象状态类
interface State {
	public void getMessage();
}

// ConcreteState: 具体状态类
// 在线状态（状态对象）
class OnlineState implements State {
	// 在线状态下的行为
	public void getMessage() {
		System.out.println("在线中，对好友可见！");
	}
}

// 隐身状态（状态对象）
class StealthState implements State {
	// 隐身状态下的行为
	public void getMessage() {
		System.out.println("隐身中，对好友不可见！");
	}
}

// Context： 环境类
// QQ的登陆状态类
class QQContext {
	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
