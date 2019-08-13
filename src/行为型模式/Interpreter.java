package 行为型模式;

/*
 * 解释器模式：给定一个语言，定义它的文法表示，并定义一个解释器，这个解释器使用该标识来解释语言中的句子。
个人总结：自己定义一种语言或表达式（附对应的解释器），用来表示一些复杂的频繁发生的行为。
例如：正则表达式的解释，sql语句的解释。使用场景极少，会引起效率、性能、维护等问题。
AbstractExpression: 抽象表达式
TerminalExpression: 终结符表达式
NonterminalExpression: 非终结符表达式
Context: 环境类
 */
import java.util.HashMap;
import java.util.Map;

public class Interpreter {

	public static void main(String[] args) {
		Context context = new Context();
		// 创建自定义变量
		Variable a = new Variable();
		Variable b = new Variable();
		// 创建常量 3
		Constant c = new Constant(3);
		// 给变量赋值
		context.put(a, 5).put(b, 1);
		// 构建语法树（自定义表达式：a+b+3）
		Expression exp = new Add(new Add(a, b), c);
		// 解释表达式a+b+3
		int result = exp.interpret(context);
		System.out.println("a+b+3 = " + result);
	}
}

// 表达式(所有表达式角色继承该接口，自带解释器)
interface Expression {
	// 解释器，解释角色所需参数存储在Context类中
	public int interpret(Context context);
}

// 构件环境类，包含解释器之外的一些全局信息，一般是 HashMap。
class Context {
	private Map<Variable, Integer> valueMap = new HashMap<Variable, Integer>();

	public Context put(Variable x, int y) {
		valueMap.put(x, y);
		return this;
	}

	public int get(Variable x) {
		int value = (Integer) valueMap.get(x);
		return value;
	}
}

// 终结符表达式角色--常量
class Constant implements Expression {
	private int a;

	public Constant(int a) {
		this.a = a;
	}

	public int interpret(Context context) {
		return a;
	}
}

// 终结符表达式角色--变量
class Variable implements Expression {
	public int interpret(Context context) {
		return context.get(this);
	}
}

// 非终结符表达式角色--运算符(+)
class Add implements Expression {
	private Expression x, y;

	public Add(Expression x, Expression y) {
		this.x = x;
		this.y = y;
	}

	public int interpret(Context context) {
		return x.interpret(context) + y.interpret(context);
	}
}
