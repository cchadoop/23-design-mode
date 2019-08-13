package 行为型模式;

/*
 * 观察者模式：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
个人总结：一个对象（被观察者）状态变化时，通知所有依赖于它的对象（观察者）；
这种依赖方式具有双向性：观察者指定被观察的对象，或者被观察对象添加观察者，下面例子采用后者方式——1对多

Subject: 目标
ConcreteSubject: 具体目标
Observer: 观察者
ConcreteObserver: 具体观察者
 */
import java.util.ArrayList;
import java.util.List;

public class Observer {

	public static void main(String[] args) {
		Subject subject = new Subject();
		subject.addSubjectObserver(new Observer1());
		subject.addSubjectObserver(new Observer2());
		subject.setState(1);
	}
}

// Subject: 目标 被观察者
class Subject {
	// 一对多关系，多个该类的观察者
	private List<SubjectObserver> subjectObservers = new ArrayList<SubjectObserver>();
	// 状态（被观察），发生变化时通知所有观察者
	@SuppressWarnings("unused")
	private int state;

	public void setState(int state) {
		this.state = state;
		// 改变状态，通知所有观察者
		notifyAllSubjectObservers();
	}

	public void addSubjectObserver(SubjectObserver subjectObserver) {
		subjectObservers.add(subjectObserver);
	}

	// 通知所有观察者
	public void notifyAllSubjectObservers() {
		for (SubjectObserver subjectObserver : subjectObservers) {
			subjectObserver.alert();
		}
	}
}

// Observer 观察者
abstract class SubjectObserver {
	protected Subject subject;

	public abstract void alert();
}

// 观察者1
class Observer1 extends SubjectObserver {
	@Override
	public void alert() {
		System.out.println("Observer1: subject is changed!");
	}
}

// 观察者2
class Observer2 extends SubjectObserver {
	@Override
	public void alert() {
		System.out.println("Observer2: subject is changed!");
	}
}
