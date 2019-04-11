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
 *Description:    ��������˵ķ���
 *Company:       
 *Version:          1.0.0
 *Author:           pantp
 *Date:              Jul 8, 2012
 */
public class HelloServer {

	//����ORB�Լ��ȴ�Զ�̿ͻ����ĵ��õĴ���
	public static void main(String args[]) throws Exception {
		// -ORBInitialPort 1050
		args = new String[2];
		args[0] = "-ORBInitialPort";
		args[1] = "1050";//�˿�

		// ����һ��ORBʵ��
		ORB orb = ORB.init(args, null);
		System.out.println("server--->11111");

		// �õ�һ��RootPOA�����ã�������POAManager
		org.omg.CORBA.Object obj=orb.resolve_initial_references("RootPOA");
		POA rootpoa = POAHelper.narrow(obj);
		rootpoa.the_POAManager().activate();

		System.out.println("server--->22222");

		// ����һ��HelloImplʵ��
		HelloImpl helloImpl = new HelloImpl();
		
		System.out.println("server--->33333");

		// �ӷ����еõ����������
		org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
		Hello href = HelloHelper.narrow(ref);

		System.out.println("server--->44444");

		// �õ�һ�������Ƶ�������
		org.omg.CORBA.Object objRef = orb
				.resolve_initial_references("NameService");
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

		System.out.println("server--->55555");

		// �������������а��������
		String name = "Hello";
		NameComponent path[] = ncRef.to_name(name);
		ncRef.rebind(path, href);

		System.out.println("server--->66666");

		// �����̷߳��񣬵ȴ��ͻ��˵���
		orb.run();
	}
}
