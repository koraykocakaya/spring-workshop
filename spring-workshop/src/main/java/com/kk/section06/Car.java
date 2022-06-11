package com.kk.section06;

import java.util.List;

public class Car {
	private Engine engine;
	private Engine engine2;
	private List<String> manualList;
	
	public Car(Engine engine1, Engine engine2) {
		this.engine = engine1;
		this.engine2 = engine2;
	}
	
	public Engine getEngine() {
		return engine;
	}
	
	public Engine getEngine2() {
		return engine2;
	}
	
	public List<String> getManualList() {
		return manualList;
	}
	
	public void setManualList(List<String> manualList) {
		this.manualList = manualList;
	}
	
	
}
