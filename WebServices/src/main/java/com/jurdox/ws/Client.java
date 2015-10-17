package com.jurdox.ws;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {

	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://localhost:8888/ws/hello?wsdl");
		
		QName qname = new QName("http://ws.jurdox.com/", "HelloWorldImplService");
		
		Service service = Service.create(url, qname);
		
		HelloWorld obj = service.getPort(HelloWorld.class);
		
		System.out.println(obj.getHelloWorldAsString("jurdox"));
		
		System.out.println(obj.getFib(25));
	}
	
}
