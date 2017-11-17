import javafx.event.EventHandler;
import javafx.event.Event;

import java.util.Vector;

import javafx.event.ActionEvent;

public class TestSubject {
	private Vector<TestObserver> observers = new Vector<TestObserver>();
	
	public void addTestEvent(TestObserver to) {
		observers.add(to);
	}
	
	public void removeTestEvent(TestObserver to) {
		observers.remove(to);
	}
	
	public void fireTestEvent() {
		for (TestObserver to: observers) {
			to.Notify();
		}
	}
}
