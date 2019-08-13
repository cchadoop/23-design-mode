package 结构型模式;
/*
 * 组合模式：将对象组合成树形结构以表示"部分-整体"的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。
	个人总结：创建了一个包含自己对象组的类，并提供修改对象组的方法。应用场景，如树形菜单，文件、文件夹的管理。
 */

import java.util.ArrayList;
import java.util.List;

public class Composite {

	public static void main(String[] args) {
		Person person = new Person("小明");
		person.addFriends(new Person("小红"));
		person.addFriends(new Person("小白"));
		System.out.println(person.getFriends());
	}
}

class Person {
	private String name;
	// 包含自己的对象组
	private List<Person> friends = new ArrayList<Person>();

	public Person(String name) {
		this.name = name;
	}

	public Person addFriends(Person p) {
		friends.add(p);
		return this;
	}

	public String getName() {
		return this.name;
	}

	public List<Person> getFriends() {
		return this.friends;
	}

	public String toString() {
		return this.name;
	}
}
