package com.jurdox.spring.logging;

import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter implements LogWriter {

	public void write(String text) {
		System.out.println("Write to console: " + text);
	}

}
