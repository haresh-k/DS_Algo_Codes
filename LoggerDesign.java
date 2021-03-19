package com.fr.application;

import java.util.LinkedHashMap;
import java.util.Map;

enum MessageType{
	ERROR, WARNING, GENERAL
}

class Subject{
	Map<MessageType, Observer> observers = new LinkedHashMap<MessageType, Observer>();
	String data;
	public String getData() {return this.data;};
	public void setData(String data) {this.data = data;}
	
	public void attach(MessageType messageType, Observer observer) {
		observers.put(messageType, observer);
	}
	
	public void deattach(Observer observer) {
		for (MessageType i: observers.keySet()) {
			if(observers.get(i) == observer)
				observers.remove(i);
		}
	}
	
	public void notify(MessageType messageType) {
		observers.get(messageType).update(this);
	}
}

class Logger extends Subject{
	public void writeLog(MessageType messageType, String message) {
		setData(message);
		notify(messageType);
	}
}

abstract class Observer{
	abstract void update(Subject subject);
}

class LogFileObserver extends Observer{
	@Override
	void update(Subject subject) {
		System.out.println("LogFileObserver " + subject.getData());
	}
}

class ConsoleObserver extends Observer{
	@Override
	void update(Subject subject) {
		System.out.println("ConsoleObserver " + subject.getData());
	}
}

public class FirstRound {
	public static void main(String[] args) {
		Logger logger = new Logger();
		LogFileObserver logFileObserver = new LogFileObserver();
		ConsoleObserver consoleObserver = new ConsoleObserver();
		logger.attach(MessageType.ERROR, logFileObserver);
		logger.attach(MessageType.WARNING, logFileObserver);
		logger.attach(MessageType.ERROR, consoleObserver);
		logger.attach(MessageType.GENERAL, consoleObserver);
		logger.writeLog(MessageType.ERROR, "This is an error");
		logger.writeLog(MessageType.WARNING, "This is a warning");
		logger.writeLog(MessageType.GENERAL, "This is a general message");
		
	}
}
