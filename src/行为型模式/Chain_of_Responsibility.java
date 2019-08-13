package 行为型模式;

/*
 * 责任链模式：避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，
 * 将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。
个人总结：在Handler类里面聚合自己，形成一条Handler链（或树、环等），
并且可以将请求往下一个Handler传递（只允许传给另一个，而不允许传给多个）。例子：Struts拦截器，Filter过滤器
 */
public class Chain_of_Responsibility {

	public static void main(String[] args) {
		ResponsibilityHandler handler1 = new ResponsibilityHandler("handler1");
		ResponsibilityHandler handler2 = new ResponsibilityHandler("handler2");
		ResponsibilityHandler handler3 = new ResponsibilityHandler("handler3");
		handler1.setResponsibilityHandler(handler2);
		handler2.setResponsibilityHandler(handler3);
		handler1.operator();// 操作请求会沿着这条链传递下去，
	}
}

// 责任处理器/接收器
class ResponsibilityHandler {
	// 聚合自己，构成一条责任链
	private ResponsibilityHandler responsibilityHandler = null;
	private String name;

	public ResponsibilityHandler(String name) {
		this.name = name;
	}

	public ResponsibilityHandler next() {
		return this.responsibilityHandler;
	}

	public void setResponsibilityHandler(ResponsibilityHandler responsibilityHandler) {
		this.responsibilityHandler = responsibilityHandler;
	}

	public void operator() {
		System.out.println(name + " is handler!");
		if (this.next() != null) {
			// 将请求发送到下一个责任接收器
			next().operator();
		}
	}
}
