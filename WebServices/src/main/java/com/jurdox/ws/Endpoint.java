package com.jurdox.ws;

public class Endpoint {

	public static void main(String[] args) {
		javax.xml.ws.Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
	}
	
}
