package 行为型模式;

/*
 * 模板方法模式：定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
	个人总结：将一些固定步骤、固定逻辑的方法封装成模板方法。调用模板方法即可完成那些特定的步骤。
	例如，spring中对Hibernate的事务管理，开启session、关闭session等固定步骤不需重复写，直接丢给一个实体保存。
 */
public class Template {

	public static void main(String[] args) {
		Game game = new FootballGame();
		game.play();
	}
}

abstract class Game {
	// 步骤1，初始化游戏
	abstract void initialize();

	// 步骤2，开始游戏
	abstract void startPlay();

	// ,步骤3，结束游戏
	abstract void endPlay();

	// 主方法，模板方法，设置为final，在抽象类中实现
	public final void play() {
		initialize();
		startPlay();
		endPlay();
	}
}

class FootballGame extends Game {
	@Override
	void initialize() {
		System.out.println("Football Game Initialized! Start playing.");
	}

	@Override
	void startPlay() {
		System.out.println("Football Game Started. Enjoy the game!");
	}

	@Override
	void endPlay() {
		System.out.println("Football Game Finished!");
	}
}
