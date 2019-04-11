package client;

import HelloApp.Hello;
import HelloApp.HelloHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * 
 *Module:          HelloClient.java
 *Description:    �ͻ��˵ĳ�ʼ���Լ����õĴ���
 *Company:       
 *Version:          1.0.0
 *Author:           pantp
 *Date:              Jul 8, 2012
 */
public class HelloClient {

	static Hello helloImpl;

	static {
		System.out.println("�ͻ��˵ĳ�ʼ�����ÿ�ʼ......." + System.currentTimeMillis());

		// -ORBInitialHost 127.0.0.1 -ORBInitialPort 1050
		String args[] = new String[4];
		args[0] = "-ORBInitialHost";
		args[1] = "127.0.0.1";// ����˵�IP��ַ
		args[2] = "-ORBInitialPort";
		args[3] = "1050";// ����˵Ķ˿�

		// ����һ��ORBʵ��
		ORB orb = ORB.init(args, null);

		// ��ȡ������������
		org.omg.CORBA.Object objRef = null;
		try {
			objRef = orb.resolve_initial_references("NameService");
		} catch (InvalidName e) {
			e.printStackTrace();
		}
		NamingContextExt neRef = NamingContextExtHelper.narrow(objRef);

		String name = "Hello";
		try {
			helloImpl = HelloHelper.narrow(neRef.resolve_str(name));
		} catch (NotFound e) {
			e.printStackTrace();
		} catch (CannotProceed e) {
			e.printStackTrace();
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			e.printStackTrace();
		}

		System.out.println("�ͻ��˵ĳ�ʼ�����ý���......." + System.currentTimeMillis());
	}
	
	public static void main(String args[]) throws Exception {
//		init();
		sayHello();
	}

	// �ͻ��˵ĳ�ʼ������
/*	public static void init() throws Exception {
		System.out.println("�ͻ��˵ĳ�ʼ�����ÿ�ʼ......." + System.currentTimeMillis());
		
		// -ORBInitialHost 127.0.0.1 -ORBInitialPort 1050
		String args[] = new String[4];
		args[0] = "-ORBInitialHost";
		args[1] = "127.0.0.1";//����˵�IP��ַ
		args[2] = "-ORBInitialPort";
		args[3] = "1050";//����˵Ķ˿�

		// ����һ��ORBʵ��
		ORB orb = ORB.init(args, null);

		// ��ȡ������������
		org.omg.CORBA.Object objRef = orb
				.resolve_initial_references("NameService");
		NamingContextExt neRef = NamingContextExtHelper.narrow(objRef);

		String name = "Hello";
		helloImpl = HelloHelper.narrow(neRef.resolve_str(name));

		System.out.println("�ͻ��˵ĳ�ʼ�����ý���......." + System.currentTimeMillis());
	}*/

	// ����corba����ķ���
	public static void sayHello() {
		String str = helloImpl.sayHello();
		System.out.println(str);
	}
}
