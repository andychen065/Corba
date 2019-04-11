package server;

import HelloApp.HelloPOA;

/**
 * 
 *Module:          HelloImpl.java
 *Description:    服务端实现sayHello()方法
 *Company:       
 *Version:          1.0.0
 *Author:           pantp
 *Date:              Jul 8, 2012
 */
public class HelloImpl extends HelloPOA {

	public String sayHello() {
		return "\nHello World\n";
	}

}
