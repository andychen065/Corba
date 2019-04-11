@rem 切换到JDK安装路径下的bin目录 根据本机的环境做相应的更改
cd/d  "D:\Program Files\Java\jdk1.5.0_06\bin"

@rem 只有端口和IP是可以变化的，这里的端口和IP是根据HelloServer中的设置来定义的
@rem 1050为命名服务器监听的端口，对应HelloServer中的端口；
@rem 127.0.0.1为服务启动的IP地址，对应HelloServer中的IP地址
orbd -ORBInitialPort 1050 -ORBInitialHost 127.0.0.1
