package com.kk.section10;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CustomEvent(Object source) {
		super(source);
	}
	
}
