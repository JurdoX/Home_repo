package com.jurdox.spring.logging;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

@Component
public class Logger {

	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;

	@PostConstruct
	public void init() {
		System.out.println("Init:");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy!");
	}
	
	public void writeConsole(String text) {
		if (consoleWriter != null) {
			consoleWriter.write(text);
		}
	}

	public void writeFile(String text) {
		fileWriter.write(text);
	}

	@Inject
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}

	@Inject
	@Named(value= "fileWriter")
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
}
