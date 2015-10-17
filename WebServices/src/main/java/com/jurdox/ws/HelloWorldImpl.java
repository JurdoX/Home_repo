package com.jurdox.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.jurdox.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String s) {
		return "Hello world JAX-WS" + s;
	}

	@Override
	public int getFib(int i) {
		if (i < 0)
			return -1;
		if (i == 0 || i == 1)
			return 1;
		return getFib(i - 1) + getFib(i - 2);
	}

}
