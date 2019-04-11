package server;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import HelloApp.Hello;
import HelloApp.HelloHelper;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NameComponent;

/**
 * 
 *Module:          HelloServer.java
 *Description:    启动服务端的服务
 *Company:       
 *Version:          1.0.0
 *Author:           pantp
 *Date:              Jul 8, 2012
 */
public class HelloServer {

	//启动ORB以及等待远程客户机的调用的代码
	public static void main(String args[]) throws Exception {
		// -ORBInitialPort 1050
		args = new String[2];
		args[0] = "-ORBInitialPort";
		args[1] = "1050";//端口

		// 创建一个ORB实例
		ORB orb = ORB.init(args, null);
		System.out.println("server--->11111");

		// 得到一个RootPOA的引用，并激活POAManager
		org.omg.CORBA.Object obj=orb.resolve_initial_references("RootPOA");
		POA rootpoa = POAHelper.narrow(obj);
		rootpoa.the_POAManager().activate();

		System.out.println("server--->22222");

		// 创建一个HelloImpl实例
		HelloImpl helloImpl = new HelloImpl();
		
		System.out.println("server--->33333");

		// 从服务中得到对象的引用
		org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
		Hello href = HelloHelper.narrow(ref);

		System.out.println("server--->44444");

		// 得到一个根名称的上下文
		org.omg.CORBA.Object objRef = orb
				.resolve_initial_references("NameService");
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

		System.out.println("server--->55555");

		// 在命名上下文中绑定这个对象
		String name = "Hello";
		NameComponent path[] = ncRef.to_name(name);
		ncRef.rebind(path, href);

		System.out.println("server--->66666");

		// 启动线程服务，等待客户端调用
		orb.run();
	}
}
