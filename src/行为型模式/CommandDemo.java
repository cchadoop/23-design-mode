package 行为型模式;

/*
 * 命令模式：将一个请求封装成一个对象，从而使您可以用不同的请求对客户进行参数化。
个人总结：三种角色（调用者→接受者→命令）；解耦行为请求者和行为实现着，实现请求和执行分开；调用者选择命令发布，命令指定执行者。
Command: 抽象命令类
ConcreteCommand: 具体命令类
Invoker: 调用者
Receiver: 接收者
Client:客户类
 */
import java.util.ArrayList;
import java.util.List;

public class CommandDemo {

	public static void main(String[] args) {
		Receiver receiver = new Receiver("小明");
		// 指定命令的执行者
		Command shootCommand = new ShootCommand(receiver);
		Command otherCOmmand = new OtherCommand(receiver);
		Invoker invoker = new Invoker();
		invoker.addCommands(shootCommand);
		invoker.addCommands(otherCOmmand);
		invoker.sendCommands();
	}
}

// 命令
interface Command {
	public void execute();
}

// 射击命令
class ShootCommand implements Command {
	private Receiver receiver;

	public ShootCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	public void execute() {
		System.out.println("shootCommand is execute:");
		receiver.action();
	}
}

// 其他命令
class OtherCommand implements Command {
	private Receiver receiver;

	public OtherCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	public void execute() {
		System.out.println("otherCommand is execute:");
		receiver.action();
	}
}

// 命令接受者（士兵）
class Receiver {
	public String name;

	public Receiver(String name) {
		this.name = name;
	}

	// 行动，执行命令
	public void action() {
		System.out.println(name + " received the command!");
	}
}

// 命令调用者（司令官）
class Invoker {
	private List<Command> commandList = new ArrayList<Command>();

	public void addCommands(Command command) {
		this.commandList.add(command);
	}

	// 发出命令
	public void sendCommands() {
		for (Command command : commandList) {
			command.execute();
			System.out.println();
		}
		commandList.clear();
	}
}
